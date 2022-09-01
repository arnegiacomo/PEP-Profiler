package no.arnemunthekaas.service;

import okhttp3.MediaType;

public class RestClient {

    public RestClient() {
        // TODO Auto-generated constructor stub
    }

    private static String pepPath = "https://code-challenge.stacc.dev/api/pep";
    private static String wikiPath = "https://en.wikipedia.org/w/api.php";
    public static final MediaType JSON = MediaType.parse("application/json; charset=UTF-8");

    public void pepSearch(SearchType searchType, String input) {


    }

    private void nameSearch(String name) {

    }

    private void addressSearch(String name) {

    }

    private void emailSearch(String name) {

    }

    private void phoneSearch(String name) {

    }
}


