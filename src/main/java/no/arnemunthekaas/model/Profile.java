package no.arnemunthekaas.model;

import no.arnemunthekaas.service.RestClient;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Profile {

    public static Set<Profile> cache = new HashSet<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(name, profile.name) && Objects.equals(pep.getId(), profile.pep.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pep.getId());
    }
}
