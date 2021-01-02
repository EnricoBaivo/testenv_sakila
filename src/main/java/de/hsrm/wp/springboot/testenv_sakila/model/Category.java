package de.hsrm.wp.springboot.testenv_sakila.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the category database table.
 * 
 */
@Entity
public class Category extends AbstractBaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CATEGORY_CATEGORYID_GENERATOR", sequenceName = "CATEGORY_CATEGORY_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_CATEGORYID_GENERATOR")
	@Column(name = "category_id")
	private Long categoryId;

	private String name;

	// bi-directional many-to-many association to Film
	@ManyToMany(mappedBy = "categories")
	private Set<Film> films;

	public Category() {
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Film> getFilms() {
		return this.films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

}