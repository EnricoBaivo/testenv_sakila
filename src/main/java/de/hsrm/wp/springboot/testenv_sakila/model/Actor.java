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
 * The persistent class for the actor database table.
 * 
 */
@Entity
public class Actor extends AbstractBaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ACTOR_ACTORID_GENERATOR", sequenceName = "ACTOR_ACTOR_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACTOR_ACTORID_GENERATOR")
	@Column(name = "actor_id")
	private Long actorId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	// bi-directional many-to-many association to Film
	@ManyToMany(mappedBy = "actors")
	private Set<Film> films;

	public Actor() {
	}

	public Long getActorId() {
		return this.actorId;
	}

	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Film> getFilms() {
		return this.films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

}