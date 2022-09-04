package no.arnemunthekaas.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import no.arnemunthekaas.model.Profile;
import no.arnemunthekaas.util.Config;
import okio.Path;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Serializer {

    public static void saveProfiles() {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter writer = new FileWriter(new String(Paths.get(Serializer.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/" + Config.savePath));
            //TODO FileWriter writer = new FileWriter(Config.savePath);
            writer.write(gson.toJson(Profile.cache));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void loadProfiles() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String inFile = null;

        try {
            inFile = new String(Files.readAllBytes(Paths.get(Paths.get(Serializer.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent() + "/" + Config.savePath)));
            //TODO inFile = new String(Files.readAllBytes(Paths.get(Config.savePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(inFile != null) {
            Profile[] objs = gson.fromJson(inFile, Profile[].class);
            Profile.cache = new HashSet<>(Arrays.asList(objs));
        }
    }
}
