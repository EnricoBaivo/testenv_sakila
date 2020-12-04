package de.hsrm.wp.springboot.testenv_sakila.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Staff {
    private long staffId;
    private String firstName;
    private String lastName;
    private long addressId;
    private byte[] picture;
    private String email;
    private long storeId;
    private boolean active;
    private String username;
    private String password;
    private Timestamp lastUpdate;
    private Collection<Payment> paymentsByStaffId;
    private Collection<Rental> rentalsByStaffId;
    private Address addressByAddressId;
    private Store storeByStoreId;
    private Collection<Store> storesByStaffId;

    @Id
    @Column(name = "STAFF_ID")
    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "ADDRESS_ID" , insertable=false, updatable=false)
    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Lob
    @Column(name = "PICTURE")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "STORE_ID" , insertable=false, updatable=false)
    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "ACTIVE")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "LAST_UPDATE")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return staffId == staff.staffId &&
                addressId == staff.addressId &&
                storeId == staff.storeId &&
                active == staff.active &&
                Objects.equals(firstName, staff.firstName) &&
                Objects.equals(lastName, staff.lastName) &&
                Arrays.equals(picture, staff.picture) &&
                Objects.equals(email, staff.email) &&
                Objects.equals(username, staff.username) &&
                Objects.equals(password, staff.password) &&
                Objects.equals(lastUpdate, staff.lastUpdate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(staffId, firstName, lastName, addressId, email, storeId, active, username, password, lastUpdate);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }

    @OneToMany(mappedBy = "staffByStaffId")
    public Collection<Payment> getPaymentsByStaffId() {
        return paymentsByStaffId;
    }

    public void setPaymentsByStaffId(Collection<Payment> paymentsByStaffId) {
        this.paymentsByStaffId = paymentsByStaffId;
    }

    @OneToMany(mappedBy = "staffByStaffId")
    public Collection<Rental> getRentalsByStaffId() {
        return rentalsByStaffId;
    }

    public void setRentalsByStaffId(Collection<Rental> rentalsByStaffId) {
        this.rentalsByStaffId = rentalsByStaffId;
    }

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = false)
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    @ManyToOne
    @JoinColumn(name = "STORE_ID", referencedColumnName = "STORE_ID", nullable = false)
    public Store getStoreByStoreId() {
        return storeByStoreId;
    }

    public void setStoreByStoreId(Store storeByStoreId) {
        this.storeByStoreId = storeByStoreId;
    }

    @OneToMany(mappedBy = "staffByManagerStaffId")
    public Collection<Store> getStoresByStaffId() {
        return storesByStaffId;
    }

    public void setStoresByStaffId(Collection<Store> storesByStaffId) {
        this.storesByStaffId = storesByStaffId;
    }
}
