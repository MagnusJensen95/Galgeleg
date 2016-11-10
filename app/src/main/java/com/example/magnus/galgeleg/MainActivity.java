package com.example.magnus.galgeleg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button)findViewById(R.id.startButton);


    }
    public void onStartGame (View v){

        Intent goToGame = new Intent(this.getApplicationContext(), GameActivity.class);

        startActivity(goToGame);

    }
}
