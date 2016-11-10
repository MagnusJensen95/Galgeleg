package com.example.magnus.galgeleg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    String result;
    private TextView summaryText;
    private int usedLetters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle status = getIntent().getExtras();

        result = status.getString("TabtEllerVundet");

        summaryText = (TextView)findViewById(R.id.statusText);

        if (result.equals("Tabt")){

            summaryText.setText("Du har tabt spillet. Prøv igen!");

        }

        if (result.equals("Vundet")){
            usedLetters = status.getInt("ForkerteBogstaver");
            summaryText.setText("Du har vundet spillet med kun "+usedLetters+ " forkerte bogstaver!" );

        }
    }

    public void onTryAgain(View v){

        Intent again = new Intent(this, GameActivity.class);

        startActivity(again);

    }

    public void backToMenu(View v){

        Intent menu = new Intent(this, MainActivity.class);

        startActivity(menu);

    }

}
