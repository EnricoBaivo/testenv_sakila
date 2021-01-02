package de.hsrm.wp.springboot.testenv_sakila.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the inventory database table.
 * 
 */
@Entity
public class Inventory extends AbstractBaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "INVENTORY_INVENTORYID_GENERATOR", sequenceName = "INVENTORY_INVENTORY_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVENTORY_INVENTORYID_GENERATOR")
	@Column(name = "inventory_id")
	private Long inventoryId;

	private Boolean active;

	// bi-directional many-to-one association to Film
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id")
	private Film film;

	// bi-directional many-to-one association to Store
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;

	// bi-directional many-to-one association to Rental
	@OneToMany(mappedBy = "inventory")
	private Set<Rental> rentals;

	public Inventory() {
	}

	public Long getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Set<Rental> getRentals() {
		return this.rentals;
	}

	public void setRentals(Set<Rental> rentals) {
		this.rentals = rentals;
	}

	public Rental addRental(Rental rental) {
		getRentals().add(rental);
		rental.setInventory(this);

		return rental;
	}

	public Rental removeRental(Rental rental) {
		getRentals().remove(rental);
		rental.setInventory(null);

		return rental;
	}

}