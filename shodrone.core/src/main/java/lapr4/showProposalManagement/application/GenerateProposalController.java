package lapr4.showProposalManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import lapr4.infrastructure.persistence.PersistenceContext;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.domain.ShowProposalStatus;
import lapr4.showProposalManagement.dto.ProposalTemplateDTO;
import lapr4.showProposalManagement.dto.ShowProposalDTO;
import lapr4.showProposalManagement.repositories.ProposalTemplateRepository;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;
import show_proposal_plugin.ShowProposalValidationService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.io.Console;

public class GenerateProposalController {

    private final ShowProposalRepository repo;
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserSession userSession = authz.session().orElseThrow(IllegalStateException::new);;
    ShowProposalValidationService validationService = new ShowProposalValidationService();
    private final ProposalTemplateRepository ptRepo = PersistenceContext.repositories().templates();


    // Production constructor
    public GenerateProposalController() {
        this.repo = PersistenceContext.repositories().showProposals();
    }

    // Test constructor (mock-friendly)
    public GenerateProposalController(ShowProposalRepository repo) {
        this.repo = repo;
    }

    public Optional<ShowProposalDTO> findNonAcceptedProposalByNumberDTO(int proposalNumber) {
        Optional<ShowProposal> optShowProposal = repo.findByProposalNumber(proposalNumber)
                .filter(p -> p.status() != ShowProposalStatus.ACCEPTED);

        ShowProposal showProposal = optShowProposal.get();

        return Optional.ofNullable(showProposal.toDTO());
    }

    public Optional<ShowProposal> findNonAcceptedProposalByNumber(int proposalNumber) {
        return repo.findByProposalNumber(proposalNumber)
                .filter(p -> p.status() != ShowProposalStatus.ACCEPTED);
    }


    public String writeProposalPT(ShowProposalDTO proposalDTO) {

        Optional<ShowProposal> opt = repo.findByProposalNumber(proposalDTO.getNumber());
        ShowProposal proposal = opt.get();

        StringBuilder sb = new StringBuilder();

        sb.append("Exmos. Senhores\n");
        sb.append(proposal.customer().name()).append("\n");
        sb.append(proposal.customer().address()).append("\n");
        sb.append(proposal.CustomerVAT().toString()).append("\n\n");

        final LocalDate datePart = proposal.eventDateTime().toLocalDate();
        final LocalTime timePart = proposal.eventDateTime().toLocalTime();

        sb.append("Referência ").append(proposal.identity()).append(" / ").append(datePart).append("\n");
        sb.append("Proposta de Show\n\n");

        sb.append("A Shodrone tem o prazer de submeter à V/ apreciação uma proposta para execução de um show aéreo com drones, conforme descrição abaixo. A Shodrone é uma empresa que dá prioridade à segurança, pelo que usa a mais avançada tecnologia de IA para apoiar o desenvolvimento dos seus shows, sendo que todos os shows são prévia e cuidadosamente testados/simulados com a tecnologia AI-Test© antes de serem apresentados ao cliente. No link ")
                .append(proposal.simulationVideoLink()).append(" encontra-se um vídeo com a simulação do show proposto.\n\n");

        sb.append("Com a aplicação do AI-Test©, um exclusivo da Shodrone, temos a confiança de oferecer um seguro de responsabilidade civil no valor de ")
                .append(proposal.insuranceValue()).append(" para o show. Os dados detalhados do show são apresentados em anexo.\n\n");

        sb.append("Estando certos que seremos alvo da V/ preferência.\n\n");
        sb.append("Subscrevemo-nos ao dispor.\n\n");
        sb.append("Melhores cumprimentos,\n\n");
        sb.append(userSession.authenticatedUser().name()).append("\n");
        sb.append("CRM Manager\n\n");

        sb.append("[page break]\n"); // Page break

        sb.append("Anexo – Detalhes do Show ").append(proposal.identity()).append("\n\n");
        sb.append("Local de realização – ").append(proposal.coordinates().latitude()).append(", ").append(proposal.coordinates().longitude()).append("\n");
        sb.append("Data – ").append(datePart).append("\n");
        sb.append("Hora – ").append(timePart).append("\n");
        sb.append("Duração – ").append(proposal.eventDuration()).append(" minutos\n\n");

        sb.append("#Lista de drones utilizados\n");
        sb.append("Modelo – Quantidade de Unidades\n");
        proposal.modelCountMap().forEach((model, quantity) -> {
            sb.append(model).append(" – ").append(quantity).append(" unidades.\n");
        });
        sb.append("...\n\n");

        sb.append("#Lista de figuras\n");
        sb.append("Posição – Nome da Figura\n");
        for (int i = 0; i < proposal.figuresList().size(); i++) {
            sb.append(i + 1).append(" – ").append(proposal.figuresList().get(i).figure().description()).append("\n");
        }
        sb.append("...");

        String string_proposal = sb.toString();

        System.out.println("Generated proposal string: " + string_proposal);
        List<String> errors = validationService.validate(string_proposal);

        if (!errors.isEmpty()) {
            System.out.println("Erros de validação:");
            errors.forEach(System.out::println);
            throw new IllegalArgumentException("A proposta contém erros de validação.");
        }

        return string_proposal;
    }

    public String writeProposalEN(ShowProposalDTO proposalDTO) {
        StringBuilder sb = new StringBuilder();

        Optional<ShowProposal> opt = repo.findByProposalNumber(proposalDTO.getNumber());
        ShowProposal proposal = opt.get();

        sb.append("Dear Sirs,\n");
        sb.append(proposal.customer().name()).append("\n");
        sb.append(proposal.customer().address()).append("\n");
        sb.append(proposal.CustomerVAT().toString()).append("\n\n");

        final LocalDate datePart = proposal.eventDateTime().toLocalDate();
        final LocalTime timePart = proposal.eventDateTime().toLocalTime();

        sb.append("Reference ").append(proposal.identity()).append(" / ").append(datePart).append("\n");
        sb.append("Show Proposal\n\n");

        sb.append("Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.\n");
        sb.append("Shodrone is a company that prioritizes safety, which is why it uses the most advanced AI technology to support the development of its shows, ");
        sb.append("with all shows being previously and carefully tested/simulated with AI-Test© technology before being presented to the client. ");
        sb.append("In the link ").append(proposal.simulationVideoLink()).append(" there is a video with a simulation of the proposed show.\n\n");

        sb.append("With the application of AI-Test©, a Shodrone exclusive, we are confident in offering liability insurance in the amount of ")
                .append(proposal.insuranceValue()).append(" euros for the show. Detailed show data is presented in the attachment.\n\n");

        sb.append("Being certain that we will be the target of your preference.\n\n");
        sb.append("We subscribe at your disposal.\n\n");
        sb.append("Best regards,\n\n");
        sb.append(userSession.authenticatedUser().name()).append("\n");
        sb.append("CRM Manager\n\n");

        sb.append("[page break]\n\n"); // Page break

        sb.append("Attachment – Show Details ").append(proposal.identity()).append("\n\n");
        sb.append("Location – ").append(proposal.coordinates().latitude()).append(", ").append(proposal.coordinates().longitude()).append("\n");
        sb.append("Date – ").append(datePart).append("\n");
        sb.append("Time – ").append(timePart).append("\n");
        sb.append("Duration – ").append(proposal.eventDuration()).append(" minutes\n\n");

        sb.append("#List of used drones\n");
        proposal.modelCountMap().forEach((model, quantity) -> {
            sb.append(model).append(" – ").append(quantity).append(" units.\n");
        });
        sb.append("XYZ - 5").append("\n");
        sb.append("...\n\n");

        sb.append("#List of figures\n");
        sb.append("Position – Figure Name\n");
        for (int i = 0; i < proposal.figuresList().size(); i++) {
            sb.append(i + 1).append(" – ").append(proposal.figuresList().get(i).figure().description()).append("\n");
        }
        sb.append("...");

        String string_proposal = sb.toString();

        System.out.println("Generated proposal string: " + string_proposal);
        List<String> errors = validationService.validate(string_proposal);

        if (!errors.isEmpty()) {
            System.out.println("Erros de validação:");
            errors.forEach(System.out::println);
            throw new IllegalArgumentException("A proposta contém erros de validação.");
        }

        return string_proposal;

    }

    public String writeProposalVIP(ShowProposalDTO proposalDTO) {
        StringBuilder sb = new StringBuilder();

        Optional<ShowProposal> opt = repo.findByProposalNumber(proposalDTO.getNumber());
        ShowProposal proposal = opt.get();

        sb.append("Dear ");
        for (int i = 0; i < proposal.customer().representatives().size(); i++) {
            sb.append(proposal.customer().representatives().get(i).name());
            if (i < proposal.customer().representatives().size() - 2) {
                sb.append(", ");
            } else if (i < proposal.customer().representatives().size() - 1) {
                sb.append(" and ");
            }
        }
        sb.append(",\n");



        sb.append(proposal.customer().name()).append("\n");
        sb.append(proposal.customer().address()).append("\n");
        sb.append(proposal.CustomerVAT().toString()).append("\n\n");

        final LocalDate datePart = proposal.eventDateTime().toLocalDate();
        final LocalTime timePart = proposal.eventDateTime().toLocalTime();

        sb.append("Reference ").append(proposal.identity()).append(" / ").append(datePart).append("\n");
        sb.append("Show Proposal\n\n");

        sb.append(proposal.customer().name()).append(" is a VIP client and Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.\n");
        sb.append("Shodrone is a company that prioritizes safety, which is why it uses the most advanced AI technology to support the development of its shows, ");
        sb.append("with all shows being previously and carefully tested/simulated with AI-Test© technology before being presented to the client. ");
        sb.append("In the link ").append(proposal.simulationVideoLink()).append(" there is a video with a simulation of the proposed show.\n\n");

        sb.append("With the application of AI-Test©, a Shodrone exclusive, we are confident in offering liability insurance in the amount of ")
                .append(proposal.insuranceValue()).append(" for the show. Detailed show data is presented in the attachment.\n\n");

        sb.append("Looking forward to hearing from you soon.\n\n");
        sb.append("Best regards,\n\n");
        sb.append(userSession.authenticatedUser().name()).append("\n");
        sb.append("CRM Manager\n\n");

        sb.append("[page break]\n\n"); // Page break

        sb.append("Attachment – Show Details ").append(proposal.identity()).append("\n\n");
        sb.append("Location – ").append(proposal.coordinates().latitude()).append(", ").append(proposal.coordinates().longitude()).append("\n");
        sb.append("Date – ").append(datePart).append("\n");
        sb.append("Time – ").append(timePart).append("\n");
        sb.append("Duration – ").append(proposal.eventDuration()).append(" minutes\n\n");

        sb.append("#List of used drones\n");
        proposal.modelCountMap().forEach((model, quantity) -> {
            sb.append(model).append(" – ").append(quantity).append(" units.\n");
        });
        sb.append("XYZ - 5").append("\n");
        sb.append("...\n\n");

        sb.append("#List of figures\n");
        sb.append("Position – Figure Name\n");
        for (int i = 0; i < proposal.figuresList().size(); i++) {
            sb.append(i + 1).append(" – ").append(proposal.figuresList().get(i).figure().description()).append("\n");
        }
        sb.append("...");

        String string_proposal = sb.toString();

        System.out.println("Generated proposal string: " + string_proposal);
        List<String> errors = validationService.validate(string_proposal);

        if (!errors.isEmpty()) {
            System.out.println("Erros de validação:");
            errors.forEach(System.out::println);
            throw new IllegalArgumentException("A proposta contém erros de validação.");
        }

        return string_proposal;
    }

    public boolean setDateAndManagerSent(ShowProposalDTO proposalDTO, LocalDate date) {
        Optional<ShowProposal> opt = repo.findByProposalNumber(proposalDTO.getNumber());
        if (opt.isEmpty()) {
            System.out.println("Proposal not found.");
            return false;
        }

        ShowProposal proposal = opt.get();

        proposal.changeSentBy(userSession.authenticatedUser().name());
        proposal.changeSentDate(date);

        repo.save(proposal);

        System.out.println("Proposal updated successfully.");
        return true;
    }

    public ProposalTemplateDTO getFilePathProposalTemplate(String proposalTemplateName) {

        return ptRepo.findByName(proposalTemplateName).toDTO();

    }
}
