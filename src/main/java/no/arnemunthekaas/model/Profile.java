package no.arnemunthekaas.model;

import no.arnemunthekaas.service.RestClient;

import java.util.ResourceBundle;

public class Profile {

    private String name;
    private Pep pep;
    private String description;
    private String imageUrl;
    private String notes;

    public Profile(Pep pep) {
        this.pep = pep;
        this.name = pep.name;
        this.imageUrl = RestClient.restClient.wikiImageSearch(name);
        this.description = RestClient.restClient.wikiSummarySearch(name);
    }

    public String getName() {
        return name;
    }

    public Pep getPep() {
        return pep;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPepInfo() {
        return pep.toString();
    }
}
