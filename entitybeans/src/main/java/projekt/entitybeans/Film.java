package projekt.entitybeans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
public class Film {
    private long filmId;
    private String title;
    private String description;
    private String releaseYear;
    private long languageId;
    private Long originalLanguageId;
    private long rentalDuration;
    private long rentalRate;
    private Long length;
    private long replacementCost;
    private String rating;
    private String specialFeatures;
    private Timestamp lastUpdate;
    private Language languageByLanguageId;
    private Language languageByOriginalLanguageId;
    private Collection<Inventory> inventoriesByFilmId;
    private Set<Actor> Actors;
    private Set<Category> Categories;

    @Id
    @Column(name = "FILM_ID", nullable = false, precision = 0)
    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "TITLE", nullable = false, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "RELEASE_YEAR", nullable = true, length = 4)
    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Basic
    @Column(name = "LANGUAGE_ID", nullable = false, precision = 0)
    public long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(long languageId) {
        this.languageId = languageId;
    }

    @Basic
    @Column(name = "ORIGINAL_LANGUAGE_ID", nullable = true, precision = 0)
    public Long getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Long originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    @Basic
    @Column(name = "RENTAL_DURATION", nullable = false, precision = 0)
    public long getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(long rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    @Basic
    @Column(name = "RENTAL_RATE", nullable = false, precision = 2)
    public long getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(long rentalRate) {
        this.rentalRate = rentalRate;
    }

    @Basic
    @Column(name = "LENGTH", nullable = true, precision = 0)
    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    @Basic
    @Column(name = "REPLACEMENT_COST", nullable = false, precision = 2)
    public long getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(long replacementCost) {
        this.replacementCost = replacementCost;
    }

    @Basic
    @Column(name = "RATING", nullable = true, length = 10)
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "SPECIAL_FEATURES", nullable = true, length = 100)
    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    @Basic
    @Column(name = "LAST_UPDATE", nullable = false)
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
        Film film = (Film) o;
        return filmId == film.filmId &&
                languageId == film.languageId &&
                rentalDuration == film.rentalDuration &&
                rentalRate == film.rentalRate &&
                replacementCost == film.replacementCost &&
                Objects.equals(title, film.title) &&
                Objects.equals(description, film.description) &&
                Objects.equals(releaseYear, film.releaseYear) &&
                Objects.equals(originalLanguageId, film.originalLanguageId) &&
                Objects.equals(length, film.length) &&
                Objects.equals(rating, film.rating) &&
                Objects.equals(specialFeatures, film.specialFeatures) &&
                Objects.equals(lastUpdate, film.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, title, description, releaseYear, languageId, originalLanguageId, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, lastUpdate);
    }

    @ManyToOne
    @JoinColumn(name = "LANGUAGE_ID", referencedColumnName = "LANGUAGE_ID", nullable = false)
    public Language getLanguageByLanguageId() {
        return languageByLanguageId;
    }

    public void setLanguageByLanguageId(Language languageByLanguageId) {
        this.languageByLanguageId = languageByLanguageId;
    }

    @ManyToOne
    @JoinColumn(name = "ORIGINAL_LANGUAGE_ID", referencedColumnName = "LANGUAGE_ID")
    public Language getLanguageByOriginalLanguageId() {
        return languageByOriginalLanguageId;
    }

    public void setLanguageByOriginalLanguageId(Language languageByOriginalLanguageId) {
        this.languageByOriginalLanguageId = languageByOriginalLanguageId;
    }

    @OneToMany(mappedBy = "filmByFilmId")
    public Collection<Inventory> getInventoriesByFilmId() {
        return inventoriesByFilmId;
    }

    public void setInventoriesByFilmId(Collection<Inventory> inventoriesByFilmId) {
        this.inventoriesByFilmId = inventoriesByFilmId;
    }

    @ManyToMany
    @JoinTable(name = "FILM_ACTOR", catalog = "", schema = "SAKILA", joinColumns = @JoinColumn(name = "FILM_ID", referencedColumnName = "FILM_ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "ACTOR_ID", referencedColumnName = "ACTOR_ID", nullable = false))
    public Set<Actor> getActors() {
        return Actors;
    }

    public void setActors(Set<Actor> actors) {
        Actors = actors;
    }

    @ManyToMany
    @JoinTable(name = "FILM_CATEGORY", catalog = "", schema = "SAKILA", joinColumns = @JoinColumn(name = "FILM_ID", referencedColumnName = "FILM_ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID", nullable = false))
    public Set<Category> getCategories() {
        return Categories;
    }

    public void setCategories(Set<Category> categories) {
        Categories = categories;
    }
}
