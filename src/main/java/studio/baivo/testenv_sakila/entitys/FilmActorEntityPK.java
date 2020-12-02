package studio.baivo.testenv_sakila.entitys;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FilmActorEntityPK implements Serializable {
    private short actorId;
    private short filmId;

    @Column(name = "actor_id")
    @Id
    public short getActorId() {
        return actorId;
    }

    public void setActorId(short actorId) {
        this.actorId = actorId;
    }

    @Column(name = "film_id")
    @Id
    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorEntityPK that = (FilmActorEntityPK) o;
        return actorId == that.actorId &&
                filmId == that.filmId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }
}
