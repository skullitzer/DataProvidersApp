package com.example.finalexam;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.Nullable;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Button quitButton;
    private Button bestProviderButton;
    private List<Providers> eventList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.textView2);
        quitButton = findViewById(R.id.button);
        bestProviderButton = findViewById(R.id.button2);

        ProviderDataReader providerDataReader = new ProviderDataReader(this);
        providerList = providerDataReader.readProvidersFromFile();
        displayProviders();

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bestProviderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Providers.class);
                startActivity(intent);
            }
        });
    }

    private void displayProviders() {
        if (providerList != null && !providerList.isEmpty()) {
            String[] providerNames = new String[providerList.size()];
            for (int i = 0; i < providerList.size(); i++) {
                providerNames[i] = providerList.get(i).getFormattedProviderNames();
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, providerNames);

            listView.setAdapter(adapter);
        }
    }
}