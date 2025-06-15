package lapr4.showProposalManagement.dto;

@SuppressWarnings("squid:S1068")
public class ProposalTemplateDTO {

    public String name;
    public String filePath;

    public ProposalTemplateDTO(final String name, final String filePath) {
        this.name = name;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return name;
    }
}