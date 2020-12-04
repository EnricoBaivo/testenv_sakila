package de.hsrm.wp.springboot.testenv_sakila.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Country {
    private long countryId;
    private String country;
    private Timestamp lastUpdate;
    private Collection<City> citiesByCountryId;

    @Id
    @Column(name = "COUNTRY_ID")
    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        Country country1 = (Country) o;
        return countryId == country1.countryId &&
                Objects.equals(country, country1.country) &&
                Objects.equals(lastUpdate, country1.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, country, lastUpdate);
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<City> getCitiesByCountryId() {
        return citiesByCountryId;
    }

    public void setCitiesByCountryId(Collection<City> citiesByCountryId) {
        this.citiesByCountryId = citiesByCountryId;
    }
}
