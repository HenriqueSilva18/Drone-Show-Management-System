// src/main/java/show_high_level_description_plugin/ShowGeneratorPlugin.java
package show_high_level_description_plugin;

import lapr4.showProposalManagement.domain.ShowProposal;

public interface ShowGeneratorPlugin {
    String generateShowDescription(ShowProposal proposal);
}
