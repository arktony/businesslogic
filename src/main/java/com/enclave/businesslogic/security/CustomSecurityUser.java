package com.enclave.businesslogic.security;


import com.enclave.businesslogic.domain.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

public class CustomSecurityUser extends User implements UserDetails {

    private static final long serialVersionUID = -8361358182811054849L;

    public CustomSecurityUser() {
    }

    public CustomSecurityUser(User user) {
        this.setId(user.getId());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setUsername(user.getUsername());
        this.setPhone(user.getPhone());
        this.setPassword(user.getPassword());
        this.setAuthorities(user.getAuthorities());
    }

    @Override
    public Set<Authority> getAuthorities() {
        return super.getAuthorities();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
