package lapr4.persistence.impl.inmemory;

import eapli.framework.domain.repositories.TransactionalContext;
import lapr4.showProposalManagement.domain.ShowProposal;
import lapr4.showProposalManagement.repositories.ShowProposalRepository;
import lapr4.showProposalManagement.domain.ProposalStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryShowProposalRepository implements ShowProposalRepository {
    private final List<ShowProposal> showProposals;

    public InMemoryShowProposalRepository() {
        this.showProposals = new ArrayList<>();
    }

    @Override
    public Optional<ShowProposal> findByProposalNumber(int proposalNumber) {
        return showProposals.stream()
                .filter(proposal -> proposal.identity() == proposalNumber)
                .findFirst();
    }

    @Override
    public Iterable<ShowProposal> findByStatus(String status) {
        ProposalStatus proposalStatus = ProposalStatus.valueOf(status);
        return showProposals.stream()
                .filter(proposal -> proposal.proposalStatus() == proposalStatus)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ShowProposal> ofIdentity(Integer id) {
        return showProposals.stream()
                .filter(proposal -> proposal.identity().equals(id))
                .findFirst();
    }

    @Override
    public List<ShowProposal> findAll() {
        return new ArrayList<>(showProposals);
    }

    @Override
    public ShowProposal save(ShowProposal entity) {
        showProposals.removeIf(existing -> existing.identity().equals(entity.identity()));
        showProposals.add(entity);
        return entity;
    }

    @Override
    public void delete(ShowProposal entity) {
        showProposals.remove(entity);
    }

    @Override
    public void deleteOfIdentity(Integer id) {
        showProposals.removeIf(proposal -> proposal.identity().equals(id));
    }

    @Override
    public long count() {
        return showProposals.size();
    }
} 