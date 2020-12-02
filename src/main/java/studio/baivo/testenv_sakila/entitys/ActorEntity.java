package studio.baivo.testenv_sakila.entitys;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "actor", schema = "sakila", catalog = "hsrm")
public class ActorEntity {
    private int actorId;
    private String firstName;
    private String lastName;
    private Timestamp lastUpdate;
    private Collection<FilmActorEntity> filmActorsByActorId;

    @Id
    @Column(name = "actor_id")
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        ActorEntity that = (ActorEntity) o;
        return actorId == that.actorId &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, firstName, lastName, lastUpdate);
    }


    public void setFilmActorsByActorId(Collection<FilmActorEntity> filmActorsByActorId) {
        this.filmActorsByActorId = filmActorsByActorId;
    }

    private Collection<FilmEntity> films;

    @ManyToMany
    public Collection<FilmEntity> getFilms() {
        return films;
    }

    public void setFilms(Collection<FilmEntity> films) {
        this.films = films;
    }
}
