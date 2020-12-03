package studio.baivo.testenv_sakila.model;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Payment {
    private long paymentId;
    private long customerId;
    private long staffId;
    private Long rentalId;
    private long amount;
    private Timestamp paymentDate;
    private Timestamp lastUpdate;
    private Customer customerByCustomerId;
    private Staff staffByStaffId;
    private Rental rentalByRentalId;

    @Id
    @Column(name = "PAYMENT_ID")
    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    @Basic
    @Column(name = "CUSTOMER_ID")
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "STAFF_ID")
    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "RENTAL_ID")
    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    @Basic
    @Column(name = "AMOUNT")
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "PAYMENT_DATE")
    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
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
        Payment payment = (Payment) o;
        return paymentId == payment.paymentId &&
                customerId == payment.customerId &&
                staffId == payment.staffId &&
                amount == payment.amount &&
                Objects.equals(rentalId, payment.rentalId) &&
                Objects.equals(paymentDate, payment.paymentDate) &&
                Objects.equals(lastUpdate, payment.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, customerId, staffId, rentalId, amount, paymentDate, lastUpdate);
    }

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", insertable=false, updatable=false)
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "STAFF_ID", referencedColumnName = "STAFF_ID", insertable=false, updatable=false)
    public Staff getStaffByStaffId() {
        return staffByStaffId;
    }

    public void setStaffByStaffId(Staff staffByStaffId) {
        this.staffByStaffId = staffByStaffId;
    }

    @ManyToOne
    @JoinColumn(name = "RENTAL_ID", referencedColumnName = "RENTAL_ID", insertable=false, updatable=false)
    public Rental getRentalByRentalId() {
        return rentalByRentalId;
    }

    public void setRentalByRentalId(Rental rentalByRentalId) {
        this.rentalByRentalId = rentalByRentalId;
    }
}
