package com.example.darksoulsstorybuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText heroName, origin, weapon, enemy;
    Button generateButton;
    TextView storyOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heroName = findViewById(R.id.heroName);
        origin = findViewById(R.id.origin);
        weapon = findViewById(R.id.weapon);
        enemy = findViewById(R.id.enemy);
        generateButton = findViewById(R.id.generateButton);
        storyOutput = findViewById(R.id.storyOutput);

        generateButton.setOnClickListener(v -> {
            String prompt = buildPrompt(
                    heroName.getText().toString(),
                    origin.getText().toString(),
                    weapon.getText().toString(),
                    enemy.getText().toString()
            );

            storyOutput.setText("Création de l'histoire en cours...");
            callChatGPT.callChatGPT(MainActivity.this, prompt, storyOutput);
        });
    }

    private String buildPrompt(String name, String origin, String weapon, String enemy) {
        return "Crée une histoire inspirée de Dark Souls et Elden Ring avec un ton sombre, tragique et épique. "
                + "Le personnage principal s'appelle " + name
                + ", il vient de " + origin
                + ", manie une " + weapon
                + ", et son ennemi juré est " + enemy
                + ". L'histoire doit être mystérieuse, brutale et immersive, comme dans l'univers de Dark Souls ou Elden Ring.";
    }
}
