package no.arnemunthekaas.service;

import com.google.gson.*;
import no.arnemunthekaas.model.Pep;
import no.arnemunthekaas.util.Config;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RestClient {

    public enum SearchType {
        NAME,
        ADDRESS,
        EMAIL,
        COUNTRY,
        PHONE
    }

    // Static access
    public static RestClient restClient;

    public RestClient() {
        restClient = this;
    }


    public List<Pep> pepSearch(SearchType searchType, String input) {
        List<Pep> results = new ArrayList<>();

        switch (searchType) {
            case NAME -> results = searchName(input);
            case ADDRESS -> results = searchAddress(input);
            case PHONE -> results = searchPhone(input);
            case EMAIL -> results = searchEmail(input);
            case COUNTRY -> results = searchCountry(input);
        }
        
        return results;
    }

    // Haha alle disse er helt like, det er litt krise, men har muligheten til å tilpasse
    private List<Pep> searchCountry(String country) {
        return doPepSearch(country);
    }

    private List<Pep> searchName(String name) {
        return doPepSearch(name);
    }

    private List<Pep> searchAddress(String address) {
        return doPepSearch(address);
    }

    private List<Pep> searchEmail(String email) {
        return doPepSearch( email);
    }

    private List<Pep> searchPhone(String phone) {
        return doPepSearch(phone);
    }

    public List<Pep> doPepSearch(String query) {
        OkHttpClient client = new OkHttpClient();

        List<JsonObject> resultList = new ArrayList<>();

        Request request = new Request.Builder().url(Config.pepPath + query).get().build();

        System.out.println(request.toString() + " " + Timestamp.from(Instant.now()) );
        try(Response response = client.newCall(request).execute()){
            String body = response.body().string();
            JsonObject results = JsonParser.parseString(body).getAsJsonObject();
            int amount = results.getAsJsonObject("total").get("value").getAsInt();
            System.out.println(amount + " matches " + Timestamp.from(Instant.now()) );

            if(amount == 0) return null;

            if(amount > Config.maxResults) amount = Config.maxResults;

            for (int i = 0; i < amount; i++) {
                JsonObject obj = results.getAsJsonArray("results").get(i).getAsJsonObject();
                resultList.add(obj);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        List<Pep> peps = new ArrayList<>();

        resultList.forEach(o -> {
            peps.add(new Pep(o));
        });

        return peps;
    }

    public String wikiSummarySearch(String title) {
        String result = "";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Config.wikiSummaryPath + title).get().build();
        try(Response response = client.newCall(request).execute()) {
            String body = response.body().string();
            System.out.println(body);
            JsonObject jsonObject = JsonParser.parseString(body).getAsJsonObject();
            jsonObject = jsonObject.getAsJsonObject("query").getAsJsonObject("pages");
            Iterator<String> keys = jsonObject.keySet().iterator();

            String key = null;
            if (keys.hasNext()) {
                key = keys.next();
            }
            JsonObject obj = jsonObject.getAsJsonObject(key);
            if (obj != null) {
                JsonElement element;
                element = obj.get("extract");
                if( element != null) {
                    result = element.getAsString();
                }
            }


        } catch(Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public String wikiImageSearch(String title) {
        String result = "";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Config.wikiImagePath + title).get().build();
        try(Response response = client.newCall(request).execute()) {
            String body = response.body().string();
            System.out.println(body);
            JsonObject jsonObject = JsonParser.parseString(body).getAsJsonObject();
            jsonObject = jsonObject.getAsJsonObject("query").getAsJsonObject("pages");
            Iterator<String> keys = jsonObject.keySet().iterator();

            String key = null;
            if (keys.hasNext()) {
                key = keys.next();
            }

            JsonObject obj = jsonObject.getAsJsonObject(key).getAsJsonObject("original");
            if (obj != null) result = obj.get("source").getAsString();;


        } catch(Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}


