package de.hsrm.wp.springboot.testenv_sakila.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class City {
    private long cityId;
    private String city;
    private long countryId;
    private Timestamp lastUpdate;
    private Collection<Address> addressesByCityId;
    private Country countryByCountryId;

    @Id
    @Column(name = "CITY_ID" , insertable=false, updatable=false)
    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "COUNTRY_ID", insertable=false, updatable=false)
    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
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
        City city1 = (City) o;
        return cityId == city1.cityId &&
                countryId == city1.countryId &&
                Objects.equals(city, city1.city) &&
                Objects.equals(lastUpdate, city1.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, city, countryId, lastUpdate);
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<Address> getAddressesByCityId() {
        return addressesByCityId;
    }

    public void setAddressesByCityId(Collection<Address> addressesByCityId) {
        this.addressesByCityId = addressesByCityId;
    }

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", nullable = false)
    public Country getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(Country countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }
}
