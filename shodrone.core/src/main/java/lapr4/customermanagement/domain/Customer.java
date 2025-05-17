package lapr4.customermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements AggregateRoot<VAT> {

	private static final long serialVersionUID = 1L;

	@Version
	private Long version;

	@EmbeddedId
	private VAT vat;

	private String name;

	@Embedded
	private Address address;

	@Embedded
	@Column(unique = true)
	private Email email;

	@Embedded
	@Column(unique = true)
	private Phone phone;

	@Enumerated(EnumType.STRING)
	public CustomerType customerType;

	@Enumerated(EnumType.STRING)
	public CustomerStatus customerStatus;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Representative> representatives = new ArrayList<>();

	public Customer(final VAT vat, final String name, final Address address, final Email email,
			final Phone phone, final CustomerType customerType, final CustomerStatus customerStatus,
			final List<Representative> representatives) {

		if (vat == null || name == null || address == null || email == null ||
				phone == null || customerType == null || customerStatus == null) {
			throw new IllegalArgumentException("All customer attributes must be provided");
		}

		if (representatives == null || representatives.isEmpty()) {
			throw new IllegalArgumentException("Customer must have at least one representative");
		}

		this.vat = vat;
		this.name = name.trim();
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.customerType = customerType;
		this.customerStatus = customerStatus;

		for (Representative rep : representatives) {
			addRepresentative(rep);
		}
	}

	protected Customer() {
		// for ORM only
	}

	public void addRepresentative(Representative representative) {
		Preconditions.noneNull(representative);
		if (representatives.contains(representative)) {
			throw new IllegalArgumentException("Representative already added to this customer.");
		}
		representative.associateCustomer(this);
		this.representatives.add(representative);
	}

	public List<Representative> representatives() {
		return Collections.unmodifiableList(this.representatives);
	}

	@Override
	public boolean equals(final Object o) {
		return DomainEntities.areEqual(this, o);
	}

	@Override
	public int hashCode() {
		return DomainEntities.hashCode(this);
	}

	@Override
	public boolean sameAs(final Object other) {
		return DomainEntities.areEqual(this, other);
	}

	@Override
	public VAT identity() {
		return this.vat;
	}

	public CustomerType customerType() {
		return this.customerType;
	}

	public CustomerStatus customerStatus() {
		return this.customerStatus;
	}
}
