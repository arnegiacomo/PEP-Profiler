package no.arnemunthekaas.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.text.WordUtils;

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

        JsonObject obj = object.getAsJsonObject("properties") ;

        setName(obj);
        setCountry(obj);
        setPosition(obj);
        setBirthDate(obj);
        setFirst_seen(object.get("first_seen").getAsString());
        setLast_seen(object.get("last_seen").getAsString());
        setDataset(object.get("datasets").getAsJsonArray().get(0).getAsString());
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", schema='" + schema + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", birth_date=" + birthDate +
                ", country='" + country + '\'' +
                ", dataset='" + dataset + '\'' +
                '}';
    }

    public String toSexyButtonString() {
        String str = "<html>" + "<p>" + name;
        if (position != "") {
            str += ", " + position;
        }
        if (country != "") {
            str += ", " + country;
        }
        if (birthDate != "") {
            str += ", " + birthDate;
        }

        return str + "<br>" + "<br>"  + toString() + "</p>" + "</html>";
    }

    public String toSexyPepString() {
        String str = "";
        str += "ID: " + id + "\n" + "\n";
        str += "Dataset: " + dataset + "\n" + "\n";
        str += "Schema: " + schema + "\n" + "\n";
        str += "Name: " + name + "\n" + "\n";
        str += "Position: " + position + "\n" + "\n";
        str += "Birth Date: " + birthDate + "\n" + "\n";
        str += "Country: " + country + "\n" + "\n";
        str += "Last Seen: " + last_seen + "\n" + "\n";
        str += "First Seen: " + first_seen + "\n" + "\n";
        return str;
    }

    private void setId(String id) {
        if (id != null)
            this.id = id;
    }

    private void setSchema(String schema) {
        if (schema != null)
            this.schema = schema;
    }

    private void setName(JsonObject obj)  {
        JsonElement el = obj.get("name");
        if(el != null) {
            name = WordUtils.capitalizeFully(el.getAsJsonArray().get(0).getAsString());
        } else {
            name = "";
        }
    }

    private void setPosition(JsonObject obj) {
        JsonElement el = obj.get("position");
        if(el != null) {
            position = el.getAsJsonArray().get(0).getAsString().toUpperCase();
        } else {
            position = "";
        }
    }

    private void setBirthDate(JsonObject obj) {
        JsonElement el = obj.get("birthDate");
        if(el != null) {
            birthDate = el.getAsJsonArray().get(0).getAsString().toUpperCase();
        } else {
            birthDate = "";
        }
    }

    private void setCountry(JsonObject obj) {
        JsonElement el = obj.get("country");
        if(el != null) {
            country = el.getAsJsonArray().get(0).getAsString().toUpperCase();
        } else {
            country = "";
        }
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
