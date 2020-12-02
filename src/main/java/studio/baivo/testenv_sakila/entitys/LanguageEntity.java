package studio.baivo.testenv_sakila.entitys;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "language", schema = "sakila", catalog = "hsrm")
public class LanguageEntity {
    private int languageId;
    private String name;
    private Timestamp lastUpdate;
    private Collection<FilmEntity> filmsByLanguageId;
    private Collection<FilmEntity> filmsByLanguageId_0;

    @Id
    @Column(name = "language_id")
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        LanguageEntity that = (LanguageEntity) o;
        return languageId == that.languageId &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageId, name, lastUpdate);
    }

    @OneToMany(mappedBy = "languageByLanguageId")
    public Collection<FilmEntity> getFilmsByLanguageId() {
        return filmsByLanguageId;
    }

    public void setFilmsByLanguageId(Collection<FilmEntity> filmsByLanguageId) {
        this.filmsByLanguageId = filmsByLanguageId;
    }

    @OneToMany(mappedBy = "languageByOriginalLanguageId")
    public Collection<FilmEntity> getFilmsByLanguageId_0() {
        return filmsByLanguageId_0;
    }

    public void setFilmsByLanguageId_0(Collection<FilmEntity> filmsByLanguageId_0) {
        this.filmsByLanguageId_0 = filmsByLanguageId_0;
    }
}
