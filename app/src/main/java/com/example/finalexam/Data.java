package com.example.finalexam;
import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Data {

    private Context context;
    public Data(Context context) {
        this.context = context;
    }
    public List<Providers> readProvidersFromFile() {
        List<Providers> providers = new ArrayList<>();
        try {
            InputStream inputStream = context.getAssets().open("providers.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(";");

                    if (parts.length == 5) {
                        try {
                            int nbLike = Integer.parseInt(parts[3]);
                            int nbDislike = Integer.parseInt(parts[4]);
                            if (nbLike >= 0 && nbDislike >= 0) {
                                Providers event = new Providers(


                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return providers;
    }
}
