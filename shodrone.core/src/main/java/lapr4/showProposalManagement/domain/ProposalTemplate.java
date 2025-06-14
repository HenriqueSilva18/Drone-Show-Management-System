package lapr4.showProposalManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.validations.Preconditions;
import eapli.framework.domain.model.DomainEntities;

import java.io.Serializable;
import java.util.Objects;

@XmlRootElement
@Entity
@Table(name = "PROPOSAL_TEMPLATE")
public class ProposalTemplate implements Serializable, AggregateRoot<String> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(unique = true, nullable = false)
    @XmlElement
    @JsonProperty
    private String name;

    @Id
    @Column
    @XmlElement
    @JsonProperty
    private String filePath;

    protected ProposalTemplate() {
        // for ORM
    }

    public ProposalTemplate(final String name, final String filePath) {
        Preconditions.nonEmpty(name, "Template name cannot be empty.");
        Preconditions.nonEmpty(filePath, "Template file cannot be empty.");
        this.name = name;
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProposalTemplate that = (ProposalTemplate) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProposalTemplate)) {
            return false;
        }
        final ProposalTemplate that = (ProposalTemplate) other;
        // sameAs compares domain-significant attributes
        return this.name.equals(that.name);
    }

    @Override
    public String identity() {
        return this.name;
    }
}