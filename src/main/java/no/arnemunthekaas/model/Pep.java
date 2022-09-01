package no.arnemunthekaas.model;

import java.util.Date;
import java.util.List;

public class Pep {

    private int score;
    private String id;
    private String schema;
    private String name;
    private List<String> aliases;
    private Date birth_date;
    private List<String> countries;
    private List<String> addresses;
    private List<String> indentifiers;
    private List<String> sanctions;
    private List<String> phones;
    private List<String> emails;
    private List<String> dataset;
    private Date last_seen;
    private Date first_seen;

    public Pep() {

    }

    public int getScore() {
        return score;
    }

    public String getId() {
        return id;
    }

    public String getSchema() {
        return schema;
    }

    public String getName() {
        return name;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public List<String> getCountries() {
        return countries;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public List<String> getIndentifiers() {
        return indentifiers;
    }

    public List<String> getSanctions() {
        return sanctions;
    }

    public List<String> getPhones() {
        return phones;
    }

    public List<String> getEmails() {
        return emails;
    }

    public List<String> getDataset() {
        return dataset;
    }

    public Date getLast_seen() {
        return last_seen;
    }

    public Date getFirst_seen() {
        return first_seen;
    }
}
