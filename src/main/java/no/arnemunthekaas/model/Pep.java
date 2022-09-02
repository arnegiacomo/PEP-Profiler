package no.arnemunthekaas.model;

import com.google.gson.JsonObject;

import java.util.Date;
import java.util.List;

public class Pep {

    private String id;
    private String schema;
    public String name;
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

    public Pep(JsonObject object) {


    }

    @Override
    public String toString() {
        return "Pep{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birth_date=" + birth_date +
                '}';
    }
}
