package lapr4.droneModelManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;
import lapr4.maintenanceManagement.domain.Maintenance;
import lapr4.maintenanceManagement.domain.MaintenanceType;

import java.util.*;

@Entity
@Table(name = "DRONE_MODEL")
public class DroneModel implements AggregateRoot<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@ElementCollection
	@CollectionTable(name = "DRONE_MODEL_SPECIFICATIONS")
	@Column(name = "SPECIFICATION")
	private List<String> modelSpecifications;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "value", column = @Column(name = "LANGUAGE_VALUE", nullable = false))
	})
	private Language language;

	@OneToMany(mappedBy = "droneModel", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private final Set<Maintenance> maintenances = new HashSet<>();

	@Column(name = "SECURE_PRICE", nullable = false)
	private double securePrice;

	protected DroneModel() {
		// for JPA
	}

	public DroneModel(List<String> modelSpecifications, String name, Language language, double securePrice) {
		if (modelSpecifications == null || modelSpecifications.isEmpty())
			throw new IllegalArgumentException("Model specifications cannot be empty.");
		if (name == null || name.isBlank())
			throw new IllegalArgumentException("Name cannot be null or blank.");
		if (language == null)
			throw new IllegalArgumentException("Language cannot be null.");
		if (securePrice < 0)
			throw new IllegalArgumentException("Secure price must be non-negative.");

		this.modelSpecifications = List.copyOf(modelSpecifications);
		this.name = name;
		this.language = language;
		this.securePrice = securePrice;
	}


	public List<String> modelSpecifications() {
		return modelSpecifications;
	}

	public String name() {
		return name;
	}

	public Language language() {
		return language;
	}

	public Set<Maintenance> maintenances() {
		return Collections.unmodifiableSet(maintenances);
	}

	/**
	 * Agendar nova manutenção para este modelo.
	 */
	public void scheduleMaintenance(String description, String startDate, String endDate, MaintenanceType type) {
		Maintenance m = new Maintenance(description, startDate, endDate, type, this);
		maintenances.add(m);
	}

	@Override
	public Long identity() {
		return id;
	}

	@Override
	public boolean hasIdentity(Long id) {
		return this.id != null && this.id.equals(id);
	}

	@Override
	public boolean sameAs(Object other) {
		if (this == other)
			return true;
		if (other == null || getClass() != other.getClass())
			return false;
		DroneModel that = (DroneModel) other;
		return Objects.equals(id, that.id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof DroneModel))
			return false;
		DroneModel that = (DroneModel) o;
		return Objects.equals(id, that.id);
	}

	public double securePrice() {
		return securePrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
