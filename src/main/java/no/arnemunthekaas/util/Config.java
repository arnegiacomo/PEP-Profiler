package no.arnemunthekaas.util;

import okhttp3.MediaType;

public class Config {

    public static int maxResults = 10;

    // API Paths
    public static String pepPath = "https://api.opensanctions.org/search/default/?limit=" + maxResults + "&q=";
    public static String wikiSummaryPath = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=";
    public static String wikiImagePath = "http://en.wikipedia.org/w/api.php?action=query&prop=pageimages&format=json&piprop=original&titles=";

}
