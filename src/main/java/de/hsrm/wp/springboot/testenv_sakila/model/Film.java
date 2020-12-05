package de.hsrm.wp.springboot.testenv_sakila.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
public class Film {
    private long filmId;
    private String title;
    private String description;
    private Integer releaseYear;
    private long languageId;
    private Long originalLanguageId;
    private long rentalDuration;
    private BigDecimal rentalRate;
    private Long length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    private Timestamp lastUpdate;
    private Language languageByLanguageId;
    private Language languageByOriginalLanguageId;
    private Collection<Inventory> inventoriesByFilmId;
    private Set<Actor> actors;
    private Set<Category> categories;

    @Id
    @Column(name = "FILM_ID")
    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Lob
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "RELEASE_YEAR")
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Basic
    @Column(name = "LANGUAGE_ID" , insertable=false, updatable=false)
    public long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(long languageId) {
        this.languageId = languageId;
    }

    @Basic
    @Column(name = "ORIGINAL_LANGUAGE_ID", insertable=false, updatable=false)
    public Long getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Long originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    @Basic
    @Column(name = "RENTAL_DURATION")
    public long getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(long rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    @Basic
    @Column(name = "RENTAL_RATE", precision = 4, scale = 2)
    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    @Basic
    @Column(name = "LENGTH")
    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    @Basic
    @Column(name = "REPLACEMENT_COST", precision = 5, scale = 2)
    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    @Basic
    @Column(name = "RATING")
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Basic
    @Lob
    @Column(name = "SPECIAL_FEATURES")
    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
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
    @JoinTable(name = "FILM_ACTOR", schema = "SAKILA", joinColumns = @JoinColumn(name = "FILM_ID", referencedColumnName = "FILM_ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "ACTOR_ID", referencedColumnName = "ACTOR_ID", nullable = false))
    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @ManyToMany
    @JoinTable(name = "FILM_CATEGORY", schema = "SAKILA", joinColumns = @JoinColumn(name = "FILM_ID", referencedColumnName = "FILM_ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID", nullable = false))
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
