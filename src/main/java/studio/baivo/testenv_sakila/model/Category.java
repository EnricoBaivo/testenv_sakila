package studio.baivo.testenv_sakila.model;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
public class Category {
    private long categoryId;
    private String name;
    private Timestamp lastUpdate;
    private Set<Film> films;

    @Id
    @Column(name = "CATEGORY_ID")
    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Category category = (Category) o;
        return categoryId == category.categoryId &&
                Objects.equals(name, category.name) &&
                Objects.equals(lastUpdate, category.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, lastUpdate);
    }

    @ManyToMany(mappedBy = "categories")
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
