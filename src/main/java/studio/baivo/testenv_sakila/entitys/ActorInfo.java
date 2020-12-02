package studio.baivo.testenv_sakila.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ACTOR_INFO database table.
 * 
 */
@Entity
@Table(name="ACTOR_INFO")
@NamedQuery(name="ActorInfo.findAll", query="SELECT a FROM ActorInfo a")
public class ActorInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ACTOR_ID")
	private BigDecimal actorId;

	@Column(name="FILM_INFO")
	private String filmInfo;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	public ActorInfo() {
	}

	public BigDecimal getActorId() {
		return this.actorId;
	}

	public void setActorId(BigDecimal actorId) {
		this.actorId = actorId;
	}

	public String getFilmInfo() {
		return this.filmInfo;
	}

	public void setFilmInfo(String filmInfo) {
		this.filmInfo = filmInfo;
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

}