package lapr4.showProposalManagement.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConfigureProposalTemplateController {

    private final String templatesDirectory = "docs/data/";
    private final String propertiesFilePath = "shodrone.app.backoffice.console/src/main/resources/application.properties";

    /**
     * Lists all available template files from the docs/data directory.
     * @return A list of template filenames.
     */
    public List<String> listAvailableTemplates() {
        File folder = new File(templatesDirectory);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().startsWith("proposta_mod_") && name.endsWith(".txt"));
        List<String> templateNames = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                templateNames.add(file.getName());
            }
        }
        return templateNames;
    }

    /**
     * Saves the selected template path to the properties file.
     * @param templateFilename The filename of the template to be set as active.
     * @return true if successful, false otherwise.
     */
    public boolean setProposalTemplate(String templateFilename) {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream(propertiesFilePath)) {
            props.load(in);
        } catch (IOException e) {
            System.err.println("Error reading properties file: " + e.getMessage());
            return false;
        }

        props.setProperty("shodrone.proposal.template.file", templatesDirectory + templateFilename);

        try (FileOutputStream out = new FileOutputStream(propertiesFilePath)) {
            props.store(out, "Updated proposal template configuration");
        } catch (IOException e) {
            System.err.println("Error writing to properties file: " + e.getMessage());
            return false;
        }
        return true;
    }
}