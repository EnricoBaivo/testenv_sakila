package de.hsrm.wp.springboot.testenv_sakila.model;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Customer {
    private long customerId;
    private long storeId;
    private String firstName;
    private String lastName;
    private String email;
    private long addressId;
    private boolean active;
    private Timestamp createDate;
    private Timestamp lastUpdate;
    private Store storeByStoreId;
    private Address addressByAddressId;
    private Collection<Payment> paymentsByCustomerId;
    private Collection<Rental> rentalsByCustomerId;

    @Id
    @Column(name = "CUSTOMER_ID")
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "STORE_ID", insertable=false, updatable=false)
    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
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
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "ADDRESS_ID", insertable=false, updatable=false)
    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
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
    @Column(name = "CREATE_DATE")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
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
        Customer customer = (Customer) o;
        return customerId == customer.customerId &&
                storeId == customer.storeId &&
                addressId == customer.addressId &&
                active == customer.active &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(createDate, customer.createDate) &&
                Objects.equals(lastUpdate, customer.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, storeId, firstName, lastName, email, addressId, active, createDate, lastUpdate);
    }

    @ManyToOne
    @JoinColumn(name = "STORE_ID", referencedColumnName = "STORE_ID", nullable = false)
    public Store getStoreByStoreId() {
        return storeByStoreId;
    }

    public void setStoreByStoreId(Store storeByStoreId) {
        this.storeByStoreId = storeByStoreId;
    }

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = false)
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Payment> getPaymentsByCustomerId() {
        return paymentsByCustomerId;
    }

    public void setPaymentsByCustomerId(Collection<Payment> paymentsByCustomerId) {
        this.paymentsByCustomerId = paymentsByCustomerId;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Rental> getRentalsByCustomerId() {
        return rentalsByCustomerId;
    }

    public void setRentalsByCustomerId(Collection<Rental> rentalsByCustomerId) {
        this.rentalsByCustomerId = rentalsByCustomerId;
    }
}
