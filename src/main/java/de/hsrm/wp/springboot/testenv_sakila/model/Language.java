package de.hsrm.wp.springboot.testenv_sakila.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the language database table.
 * 
 */
@Entity
public class Language extends AbstractBaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "LANGUAGE_LANGUAGEID_GENERATOR", sequenceName = "LANGUAGE_LANGUAGE_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LANGUAGE_LANGUAGEID_GENERATOR")
	@Column(name = "language_id")
	private Long languageId;

	private String name;

	// bi-directional many-to-one association to Film
	@OneToMany(mappedBy = "language")
	private Set<Film> films;

	// bi-directional many-to-one association to Film
	@OneToMany(mappedBy = "originalLanguage")
	private Set<Film> filmsInOriginalLanguage;

	public Language() {
	}

	public Long getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Film> getFilms() {
		return this.films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	public Film addFilms(Film films) {
		getFilms().add(films);
		films.setLanguage(this);

		return films;
	}

	public Film removeFilms1(Film films) {
		getFilms().remove(films);
		films.setLanguage(null);

		return films;
	}

	public Set<Film> getFilmsInOriginalLanguage() {
		return this.filmsInOriginalLanguage;
	}

	public void setFilmsInOriginalLanguage(Set<Film> filmsInOriginalLanguage) {
		this.filmsInOriginalLanguage = filmsInOriginalLanguage;
	}

	public Film addFilmsInOriginalLanguage(Film filmsInOriginalLanguage) {
		getFilmsInOriginalLanguage().add(filmsInOriginalLanguage);
		filmsInOriginalLanguage.setOriginalLanguage(this);

		return filmsInOriginalLanguage;
	}

	public Film removeFilmsInOriginalLanguage(Film filmsInOriginalLanguage) {
		getFilmsInOriginalLanguage().remove(filmsInOriginalLanguage);
		filmsInOriginalLanguage.setOriginalLanguage(null);

		return filmsInOriginalLanguage;
	}

}