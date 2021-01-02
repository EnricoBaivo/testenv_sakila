package de.hsrm.wp.springboot.testenv_sakila.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public abstract class AbstractBaseEntity implements Serializable {

	// dummy, this is an abstract class anyway
	private static final long serialVersionUID = -1L;

	@Column(name = "last_update")
	private Timestamp lastUpdate;

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@PrePersist
	@PreUpdate
	public void lastUpdatedNow() {
		setLastUpdate(Timestamp.from(Instant.now()));
	}

}
