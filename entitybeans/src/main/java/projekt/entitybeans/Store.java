package projekt.entitybeans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Store {
    private long storeId;
    private long managerStaffId;
    private long addressId;
    private Timestamp lastUpdate;
    private Collection<Customer> customersByStoreId;
    private Collection<Inventory> inventoriesByStoreId;
    private Collection<Staff> staffByStoreId;
    private Staff staffByManagerStaffId;
    private Address addressByAddressId;

    @Id
    @Column(name = "STORE_ID", nullable = false, precision = 0)
    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "MANAGER_STAFF_ID", nullable = false, precision = 0)
    public long getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(long managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    @Basic
    @Column(name = "ADDRESS_ID", nullable = false, precision = 0)
    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "LAST_UPDATE", nullable = false)
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
        Store store = (Store) o;
        return storeId == store.storeId &&
                managerStaffId == store.managerStaffId &&
                addressId == store.addressId &&
                Objects.equals(lastUpdate, store.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, managerStaffId, addressId, lastUpdate);
    }

    @OneToMany(mappedBy = "storeByStoreId")
    public Collection<Customer> getCustomersByStoreId() {
        return customersByStoreId;
    }

    public void setCustomersByStoreId(Collection<Customer> customersByStoreId) {
        this.customersByStoreId = customersByStoreId;
    }

    @OneToMany(mappedBy = "storeByStoreId")
    public Collection<Inventory> getInventoriesByStoreId() {
        return inventoriesByStoreId;
    }

    public void setInventoriesByStoreId(Collection<Inventory> inventoriesByStoreId) {
        this.inventoriesByStoreId = inventoriesByStoreId;
    }

    @OneToMany(mappedBy = "storeByStoreId")
    public Collection<Staff> getStaffByStoreId() {
        return staffByStoreId;
    }

    public void setStaffByStoreId(Collection<Staff> staffByStoreId) {
        this.staffByStoreId = staffByStoreId;
    }

    @ManyToOne
    @JoinColumn(name = "MANAGER_STAFF_ID", referencedColumnName = "STAFF_ID", nullable = false)
    public Staff getStaffByManagerStaffId() {
        return staffByManagerStaffId;
    }

    public void setStaffByManagerStaffId(Staff staffByManagerStaffId) {
        this.staffByManagerStaffId = staffByManagerStaffId;
    }

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = false)
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }
}
