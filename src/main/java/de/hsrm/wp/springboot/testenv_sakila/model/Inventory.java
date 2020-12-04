package de.hsrm.wp.springboot.testenv_sakila.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Inventory {
    private long inventoryId;
    private long filmId;
    private long storeId;
    private boolean active;
    private Timestamp lastUpdate;
    private Film filmByFilmId;
    private Store storeByStoreId;
    private Collection<Rental> rentalsByInventoryId;

    @Id
    @Column(name = "INVENTORY_ID")
    public long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(long inventoryId) {
        this.inventoryId = inventoryId;
    }

    @Basic
    @Column(name = "FILM_ID" , insertable=false, updatable=false)
    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
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
        Inventory inventory = (Inventory) o;
        return inventoryId == inventory.inventoryId &&
                filmId == inventory.filmId &&
                storeId == inventory.storeId &&
                active == inventory.active &&
                Objects.equals(lastUpdate, inventory.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, filmId, storeId, active, lastUpdate);
    }

    @ManyToOne
    @JoinColumn(name = "FILM_ID", referencedColumnName = "FILM_ID", nullable = false)
    public Film getFilmByFilmId() {
        return filmByFilmId;
    }

    public void setFilmByFilmId(Film filmByFilmId) {
        this.filmByFilmId = filmByFilmId;
    }

    @ManyToOne
    @JoinColumn(name = "STORE_ID", referencedColumnName = "STORE_ID", nullable = false)
    public Store getStoreByStoreId() {
        return storeByStoreId;
    }

    public void setStoreByStoreId(Store storeByStoreId) {
        this.storeByStoreId = storeByStoreId;
    }

    @OneToMany(mappedBy = "inventoryByInventoryId")
    public Collection<Rental> getRentalsByInventoryId() {
        return rentalsByInventoryId;
    }

    public void setRentalsByInventoryId(Collection<Rental> rentalsByInventoryId) {
        this.rentalsByInventoryId = rentalsByInventoryId;
    }
}
