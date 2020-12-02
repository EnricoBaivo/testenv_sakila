package studio.baivo.testenv_sakila.entitys;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "film", schema = "sakila", catalog = "hsrm")
public class FilmEntity {
    private int filmId;
    private String title;
    private String description;
    private Object releaseYear;
    private short languageId;
    private Short originalLanguageId;
    private short rentalDuration;
    private BigDecimal rentalRate;
    private Short length;
    private BigDecimal replacementCost;
    private Object rating;
    private Timestamp lastUpdate;
    private Object specialFeatures;
    private Object fulltext;
    private LanguageEntity languageByLanguageId;
    private LanguageEntity languageByOriginalLanguageId;
    private Collection<FilmActorEntity> filmActorsByFilmId;
    private Collection<InventoryEntity> inventoriesByFilmId;
    private Set<CategoryEntity> categories;

    @Id
    @Column(name = "film_id")
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "release_year")
    public Object getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Object releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Basic
    @Column(name = "language_id")
    public short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(short languageId) {
        this.languageId = languageId;
    }

    @Basic
    @Column(name = "original_language_id")
    public Short getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Short originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    @Basic
    @Column(name = "rental_duration")
    public short getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(short rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    @Basic
    @Column(name = "rental_rate")
    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    @Basic
    @Column(name = "length")
    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    @Basic
    @Column(name = "replacement_cost")
    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    @Basic
    @Column(name = "rating")
    public Object getRating() {
        return rating;
    }

    public void setRating(Object rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Basic
    @Column(name = "special_features")
    public Object getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(Object specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    @Basic
    @Column(name = "fulltext")
    public Object getFulltext() {
        return fulltext;
    }

    public void setFulltext(Object fulltext) {
        this.fulltext = fulltext;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmEntity that = (FilmEntity) o;
        return filmId == that.filmId &&
                languageId == that.languageId &&
                rentalDuration == that.rentalDuration &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(releaseYear, that.releaseYear) &&
                Objects.equals(originalLanguageId, that.originalLanguageId) &&
                Objects.equals(rentalRate, that.rentalRate) &&
                Objects.equals(length, that.length) &&
                Objects.equals(replacementCost, that.replacementCost) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(lastUpdate, that.lastUpdate) &&
                Objects.equals(specialFeatures, that.specialFeatures) &&
                Objects.equals(fulltext, that.fulltext);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, title, description, releaseYear, languageId, originalLanguageId, rentalDuration, rentalRate, length, replacementCost, rating, lastUpdate, specialFeatures, fulltext);
    }

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "language_id", nullable = false)
    public LanguageEntity getLanguageByLanguageId() {
        return languageByLanguageId;
    }

    public void setLanguageByLanguageId(LanguageEntity languageByLanguageId) {
        this.languageByLanguageId = languageByLanguageId;
    }

    @ManyToOne
    @JoinColumn(name = "original_language_id", referencedColumnName = "language_id")
    public LanguageEntity getLanguageByOriginalLanguageId() {
        return languageByOriginalLanguageId;
    }

    public void setLanguageByOriginalLanguageId(LanguageEntity languageByOriginalLanguageId) {
        this.languageByOriginalLanguageId = languageByOriginalLanguageId;
    }



    public void setFilmActorsByFilmId(Collection<FilmActorEntity> filmActorsByFilmId) {
        this.filmActorsByFilmId = filmActorsByFilmId;
    }

    @OneToMany(mappedBy = "filmByFilmId")
    public Collection<InventoryEntity> getInventoriesByFilmId() {
        return inventoriesByFilmId;
    }

    public void setInventoriesByFilmId(Collection<InventoryEntity> inventoriesByFilmId) {
        this.inventoriesByFilmId = inventoriesByFilmId;
    }

    @ManyToMany
    @JoinTable(name = "film_category", catalog = "hsrm", schema = "sakila", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false))
    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
    }

    private Collection<ActorEntity> actors;

    @ManyToMany(mappedBy = "films")
    public Collection<ActorEntity> getActors() {
        return actors;
    }

    public void setActors(Collection<ActorEntity> actors) {
        this.actors = actors;
    }
}
