package com.enclave.businesslogic.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "business")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    private String type;
    private String address;
    @NotBlank
    private String phone;
    private String bondNo;
    private int bondInForce;
    private String status;

    @OneToMany(mappedBy = "business", fetch = FetchType.LAZY)
    private List<User> user;

    @OneToMany(mappedBy = "business", fetch = FetchType.LAZY)
    private List<Vehicle> vehicle;

    public Business() {
    }

    public Business(Long id, String name, String email, String type, String address, String phone, String bondNo, int bondInForce, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
        this.address = address;
        this.phone = phone;
        this.bondNo = bondNo;
        this.bondInForce = bondInForce;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBondNo() {
        return bondNo;
    }

    public void setBondNo(String bondNo) {
        this.bondNo = bondNo;
    }

    public int getBondInForce() {
        return bondInForce;
    }

    public void setBondInForce(int bondInForce) {
        this.bondInForce = bondInForce;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", bondNo='" + bondNo + '\'' +
                ", bondInForce=" + bondInForce +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", vehicle=" + vehicle +
                '}';
    }
}
