package com.rkcorner.assignment_5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PetAdapter petAdapter;
    private List<Pet> petList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the pet list
        petList = new ArrayList<>();

        // Populate pet data
        initializePetData();

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // *** These are the two lines you mentioned ***
        petAdapter = new PetAdapter(this, petList);
        recyclerView.setAdapter(petAdapter);
        // *********************************************
    }

    // Method to initialize pet data
    private void initializePetData() {
        petList.add(new Pet(
                Arrays.asList("Buddy", "Max"),
                "Golden Retriever",
                Arrays.asList("2 years", "3 years"),
                "Dog",
                new int[]{R.drawable.dog1, R.drawable.dog2}
        ));

        petList.add(new Pet(
                Arrays.asList("Whiskers", "Shadow"),
                "Siamese",
                Arrays.asList("1 year", "2 years"),
                "Cat",
                new int[]{R.drawable.cat1, R.drawable.cat2}
        ));

        petList.add(new Pet(
                Arrays.asList("Tweety", "Chirpy"),
                "Canary",
                Arrays.asList("6 months", "1 year"),
                "Bird",
                new int[]{R.drawable.bird1, R.drawable.bird2}
        ));
    }
}