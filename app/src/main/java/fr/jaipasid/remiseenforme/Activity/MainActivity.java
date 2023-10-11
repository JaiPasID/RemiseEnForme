package fr.jaipasid.remiseenforme.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.jaipasid.remiseenforme.R;

public class MainActivity extends AppCompatActivity {


    Button createProfil, seeProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createProfil = findViewById(R.id.createProfile);
        seeProfil = findViewById(R.id.seeProfile);


        createProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateProfile.class);
                startActivity(intent);
            }
        });
    }
}