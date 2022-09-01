package no.arnemunthekaas.model;

public class Profile {

    private String name;
    private Pep pep;
    private String description;
    private String imageUrl;
    private String notes;

    public Profile(String name, Pep pep, String description, String imageUrl) {
        this.name = name;
        this.pep = pep;
        this.description = description;
        this.imageUrl = imageUrl;
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
}
