package com.enclave.businesslogic.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Payment {

    private PaymentId pk;
    private Boolean paid;
    private int days;

    @EmbeddedId
    public PaymentId getPk() {
        return pk;
    }

    public void setPk(PaymentId pk) {
        this.pk = pk;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
