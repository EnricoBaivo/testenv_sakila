package de.hsrm.wp.springboot.testenv_sakila.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Rental {
    private long rentalId;
    private Timestamp rentalDate;
    private long inventoryId;
    private long customerId;
    private Timestamp returnDate;
    private long staffId;
    private Timestamp lastUpdate;
    private Collection<Payment> paymentsByRentalId;
    private Inventory inventoryByInventoryId;
    private Customer customerByCustomerId;
    private Staff staffByStaffId;

    @Id
    @Column(name = "RENTAL_ID")
    public long getRentalId() {
        return rentalId;
    }

    public void setRentalId(long rentalId) {
        this.rentalId = rentalId;
    }

    @Basic
    @Column(name = "RENTAL_DATE")
    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    @Basic
    @Column(name = "INVENTORY_ID", insertable=false, updatable=false)
    public long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(long inventoryId) {
        this.inventoryId = inventoryId;
    }

    @Basic
    @Column(name = "CUSTOMER_ID" , insertable=false, updatable=false)
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "RETURN_DATE")
    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    @Basic
    @Column(name = "STAFF_ID", insertable=false, updatable=false)
    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
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
        Rental rental = (Rental) o;
        return rentalId == rental.rentalId &&
                inventoryId == rental.inventoryId &&
                customerId == rental.customerId &&
                staffId == rental.staffId &&
                Objects.equals(rentalDate, rental.rentalDate) &&
                Objects.equals(returnDate, rental.returnDate) &&
                Objects.equals(lastUpdate, rental.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId, rentalDate, inventoryId, customerId, returnDate, staffId, lastUpdate);
    }

    @OneToMany(mappedBy = "rentalByRentalId")
    public Collection<Payment> getPaymentsByRentalId() {
        return paymentsByRentalId;
    }

    public void setPaymentsByRentalId(Collection<Payment> paymentsByRentalId) {
        this.paymentsByRentalId = paymentsByRentalId;
    }

    @ManyToOne
    @JoinColumn(name = "INVENTORY_ID", referencedColumnName = "INVENTORY_ID", nullable = false)
    public Inventory getInventoryByInventoryId() {
        return inventoryByInventoryId;
    }

    public void setInventoryByInventoryId(Inventory inventoryByInventoryId) {
        this.inventoryByInventoryId = inventoryByInventoryId;
    }

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", nullable = false)
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "STAFF_ID", referencedColumnName = "STAFF_ID", nullable = false)
    public Staff getStaffByStaffId() {
        return staffByStaffId;
    }

    public void setStaffByStaffId(Staff staffByStaffId) {
        this.staffByStaffId = staffByStaffId;
    }
}
