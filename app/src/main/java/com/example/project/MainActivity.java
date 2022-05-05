package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    // in My MainActivity class
    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;

    private TextView prefTextRef;

    private Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //let button open function to second activity
        startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClick();
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        // Read a preference in onResume
        myPreferenceRef = getSharedPreferences("MyPreferencesName", MODE_PRIVATE);
        //Log.d("skola",myPreferenceRef.getString("MyAppPreferenceString", "No preference found."));
        prefTextRef=findViewById(R.id.prefText);
        prefTextRef.setText(myPreferenceRef.getString("MyAppPreferenceString", "No preference found."));
    }

        //function to open second activity
    private void onButtonClick(){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

}
