package studio.baivo.testenv_sakila.entitys;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "store", schema = "sakila", catalog = "hsrm")
public class StoreEntity {
    private int storeId;
    private short managerStaffId;
    private short addressId;
    private Timestamp lastUpdate;
    private Collection<CustomerEntity> customersByStoreId;
    private Collection<InventoryEntity> inventoriesByStoreId;
    private Collection<StaffEntity> staffByStoreId;
    private StaffEntity staffByManagerStaffId;
    private AddressEntity addressByAddressId;

    @Id
    @Column(name = "store_id")
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "manager_staff_id")
    public short getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(short managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    @Basic
    @Column(name = "address_id")
    public short getAddressId() {
        return addressId;
    }

    public void setAddressId(short addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "last_update")
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
        StoreEntity that = (StoreEntity) o;
        return storeId == that.storeId &&
                managerStaffId == that.managerStaffId &&
                addressId == that.addressId &&
                Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, managerStaffId, addressId, lastUpdate);
    }

    @OneToMany(mappedBy = "storeByStoreId")
    public Collection<CustomerEntity> getCustomersByStoreId() {
        return customersByStoreId;
    }

    public void setCustomersByStoreId(Collection<CustomerEntity> customersByStoreId) {
        this.customersByStoreId = customersByStoreId;
    }

    @OneToMany(mappedBy = "storeByStoreId")
    public Collection<InventoryEntity> getInventoriesByStoreId() {
        return inventoriesByStoreId;
    }

    public void setInventoriesByStoreId(Collection<InventoryEntity> inventoriesByStoreId) {
        this.inventoriesByStoreId = inventoriesByStoreId;
    }

    @OneToMany(mappedBy = "storeByStoreId")
    public Collection<StaffEntity> getStaffByStoreId() {
        return staffByStoreId;
    }

    public void setStaffByStoreId(Collection<StaffEntity> staffByStoreId) {
        this.staffByStoreId = staffByStoreId;
    }

    @ManyToOne
    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id", nullable = false)
    public StaffEntity getStaffByManagerStaffId() {
        return staffByManagerStaffId;
    }

    public void setStaffByManagerStaffId(StaffEntity staffByManagerStaffId) {
        this.staffByManagerStaffId = staffByManagerStaffId;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    public AddressEntity getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(AddressEntity addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }
}
