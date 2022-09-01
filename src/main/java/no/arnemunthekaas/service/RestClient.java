package no.arnemunthekaas.service;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import no.arnemunthekaas.util.Config;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

public class RestClient {

    public enum SearchType {
        NAME,
        ADDRESS,
        EMAIL,
        PHONE
    }

    // Static access
    public static RestClient restClient;

    public RestClient() {
        restClient = this;
    }


    public String pepSearch(SearchType searchType, String input) {
        String result = "";

        switch (searchType) {
            case NAME -> result = searchName(input);
            case ADDRESS -> result = searchAddress(input);
            case PHONE -> result = searchPhone(input);
            case EMAIL -> result = searchEmail(input);
        }
        
        return result;
    }

    private String searchName(String name) {
        return doPepSearch("?q=" + name + "&limit=1");
    }

    private String searchAddress(String address) {
        return doPepSearch("?q=" + address + "&limit=1");
    }

    private String searchEmail(String email) {
        return doPepSearch("?q=" + email + "&limit=1");
    }

    private String searchPhone(String phone) {
        return doPepSearch("?q=" + phone + "&limit=1");
    }

    private String doPepSearch(String query) {
        OkHttpClient client = new OkHttpClient();
        String result = "";

        Request request = new Request.Builder().url(Config.pepPath + query).get().build();

        System.out.println(request.toString() + " " + Timestamp.from(Instant.now()) );
        try(Response response = client.newCall(request).execute()){
            result = response.body().string();
        } catch(JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
}


