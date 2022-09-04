package no.arnemunthekaas;

import no.arnemunthekaas.service.RestClient;
import no.arnemunthekaas.service.Serializer;
import no.arnemunthekaas.ui.Frame;

public class Main{

    public static void main(String[] args) {

        Serializer.loadProfiles(); // Load all cached profiles on startup
        RestClient restClient = new RestClient();
        Frame frame = new Frame();

    }
}