package org.example.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.Enumerated;
import org.example.model.gender;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Celebrity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	@NotNull
	private String url;

	@Column
	@NotNull
	private String firstname;

	@Column
	@NotNull
	private String surname;

	@Enumerated
	@NotNull
	private gender gender;

	@Column
	private Integer rating;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Celebrity)) {
			return false;
		}
		Celebrity other = (Celebrity) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public gender getGender() {
		return gender;
	}

	public void setGender(gender gender) {
		this.gender = gender;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (url != null && !url.trim().isEmpty())
			result += "url: " + url;
		if (firstname != null && !firstname.trim().isEmpty())
			result += ", firstname: " + firstname;
		if (surname != null && !surname.trim().isEmpty())
			result += ", surname: " + surname;
		if (rating != null)
			result += ", rating: " + rating;
		return result;
	}
}