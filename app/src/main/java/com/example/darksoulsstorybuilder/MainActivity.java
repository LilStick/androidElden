package com.example.darksoulsstorybuilder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText heroName, origin, weapon, enemy;
    Button generateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heroName = findViewById(R.id.heroName);
        origin = findViewById(R.id.origin);
        weapon = findViewById(R.id.weapon);
        enemy = findViewById(R.id.enemy);
        generateButton = findViewById(R.id.generateButton);

        generateButton.setOnClickListener(v -> {
            String prompt = buildPrompt(
                    heroName.getText().toString(),
                    origin.getText().toString(),
                    weapon.getText().toString(),
                    enemy.getText().toString()
            );

            // Pass the prompt to the next activity
            Intent intent = new Intent(MainActivity.this, StoryActivity.class);
            intent.putExtra("prompt", prompt);
            startActivity(intent);
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
