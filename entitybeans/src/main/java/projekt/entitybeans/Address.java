package projekt.entitybeans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Address {
    private long addressId;
    private String address;
    private String address2;
    private String district;
    private String postalCode;
    private String phone;
    private Timestamp lastUpdate;
    private City cityByCityId;
    private Collection<Customer> customersByAddressId;
    private Collection<Staff> staffByAddressId;
    private Collection<Store> storesByAddressId;

    @Id
    @Column(name = "ADDRESS_ID", nullable = false, precision = 0)
    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "ADDRESS", nullable = false, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "ADDRESS2", nullable = true, length = 50)
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Basic
    @Column(name = "DISTRICT", nullable = false, length = 20)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "POSTAL_CODE", nullable = true, length = 10)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "PHONE", nullable = false, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        Address address1 = (Address) o;
        return addressId == address1.addressId &&
                Objects.equals(address, address1.address) &&
                Objects.equals(address2, address1.address2) &&
                Objects.equals(district, address1.district) &&
                Objects.equals(postalCode, address1.postalCode) &&
                Objects.equals(phone, address1.phone) &&
                Objects.equals(lastUpdate, address1.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, address, address2, district, postalCode, phone, lastUpdate);
    }

    @ManyToOne
    @JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID", nullable = false)
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Customer> getCustomersByAddressId() {
        return customersByAddressId;
    }

    public void setCustomersByAddressId(Collection<Customer> customersByAddressId) {
        this.customersByAddressId = customersByAddressId;
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Staff> getStaffByAddressId() {
        return staffByAddressId;
    }

    public void setStaffByAddressId(Collection<Staff> staffByAddressId) {
        this.staffByAddressId = staffByAddressId;
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Store> getStoresByAddressId() {
        return storesByAddressId;
    }

    public void setStoresByAddressId(Collection<Store> storesByAddressId) {
        this.storesByAddressId = storesByAddressId;
    }
}
