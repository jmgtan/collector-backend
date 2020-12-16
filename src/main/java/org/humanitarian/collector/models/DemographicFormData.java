package org.humanitarian.collector.models;

import javax.persistence.*;

@Entity
@Table(name = "form_data_demographic")
public class DemographicFormData extends FormData {

    private String address;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
