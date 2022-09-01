package no.arnemunthekaas.util;

import okhttp3.MediaType;

public class Config {

    // API Paths
    public static String pepPath = "https://api.opensanctions.org/search/default/";
    public static String wikiPath = "https://en.wikipedia.org/w/api.php";

    public static final MediaType JSON = MediaType.parse("application/json; charset=UTF-8");
}
