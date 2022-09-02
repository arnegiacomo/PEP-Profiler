package no.arnemunthekaas.model;

import com.google.gson.JsonObject;
import org.apache.commons.text.WordUtils;

import java.util.Date;
import java.util.List;

public class Pep {

    private String id = "";
    private String schema  = "";
    public String name  = "";
    private String position  = "";
    private String country  = "";
    private String dataset  = "";
    private String last_seen  = "";
    private String first_seen  = "";
    private String birthDate  = "";

    public Pep(JsonObject object) {
        setId(object.get("id").getAsString());
        setSchema(object.get("schema").getAsString());
        setName(object.getAsJsonObject("properties").get("name").getAsJsonArray().get(0).getAsString());
        // setCountry(object.getAsJsonObject("properties").get("country").getAsJsonArray().get(0).getAsString());
        // setPosition(object.getAsJsonObject("properties").get("position").getAsJsonArray().get(0).getAsString());
        // setBirthDate(object.getAsJsonObject("properties").get("birthDate").getAsJsonArray().get(0).getAsString());
        setFirst_seen(object.get("first_seen").getAsString());
        setLast_seen(object.get("last_seen").getAsString());
        setDataset(object.get("datasets").getAsJsonArray().get(0).getAsString());
    }

    @Override
    public String toString() {
        return "Pep{" +
                "id='" + id + '\'' +
                ", schema='" + schema + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", birth_date=" + birthDate +
                ", country='" + country + '\'' +
                ", dataset='" + dataset + '\'' +
                '}';
    }

    private void setId(String id) {
        if (id != null)
            this.id = id;
    }

    private void setSchema(String schema) {
        if (schema != null)
            this.schema = schema;
    }

    private void setName(String name)  {
        if (name != null)
            this.name = WordUtils.capitalizeFully(name);
    }

    private void setPosition(String position) {
        if (position != null)
            this.position = position;
    }

    private void setBirthDate(String birthDate) {
        if (birthDate != null)
            this.birthDate = birthDate;
    }

    private void setCountry(String country) {
        if (country != null)
            this.country = country;
    }

    private void setDataset(String dataset) {
        if (dataset != null)
            this.dataset = dataset;
    }

    private void setLast_seen(String last_seen) {
        if (last_seen != null)
            this.last_seen = last_seen;
    }

    private void setFirst_seen(String first_seen) {
        if (first_seen != null)
            this.first_seen = first_seen;
    }
}
