package lapr4.droneModelManagement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Language {

	@Column(name = "LANGUAGE_VALUE", nullable = false)
	private String value;

	// Required no-args constructor for JPA
	protected Language() {
		// for JPA
	}

	public Language(String value) {
		if (value == null || value.isBlank())
			throw new IllegalArgumentException("Language cannot be blank.");
		this.value = value.trim().toUpperCase();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		if (value == null || value.isBlank())
			throw new IllegalArgumentException("Language cannot be blank.");
		this.value = value.trim().toUpperCase();
	}

	public static Language valueOf(String input) {
		return new Language(input);
	}

	@Override
	public String toString() {
		return value;
	}
}
