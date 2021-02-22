package com.enclave.businesslogic.controllers;

import com.enclave.businesslogic.domain.AuthenticationRequest;
import com.enclave.businesslogic.domain.AuthenticationResponse;
import com.enclave.businesslogic.domain.Business;
import com.enclave.businesslogic.domain.User;
import com.enclave.businesslogic.service.BusinessService;
import com.enclave.businesslogic.service.UserDetailsServiceImpl;
import com.enclave.businesslogic.service.UserService;
import com.enclave.businesslogic.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private BusinessService businessService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public String greeting() {
        return "Hello world";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken
                            (authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect Username or Password");
        }

        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @RequestMapping(value = "/onboard", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public Business createBusiness(@RequestBody Business business) {
        Business businessObject = new Business();
        businessObject = businessService.createBusiness(business);
        System.out.println(businessObject);
        return businessObject;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public User saveUser(@RequestBody User user) {
        System.out.println("This user object" + user);
        User userObject = new User();
//        userObject.setBusiness(user.setBusiness());
        userObject = userService.save(user);
        return userObject;
    }
}
