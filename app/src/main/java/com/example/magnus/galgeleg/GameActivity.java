package com.example.magnus.galgeleg;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    GalgeLogik game;
    Drawable[] images;
    private TextView visibleWord;
    private Button guessButton;
    private EditText guessLetter;
    private TextView usedLetters;
    private ImageView gallowImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_acticity);

        images = new Drawable[7];

        guessButton = (Button) findViewById(R.id.guessButton);
        guessLetter = (EditText) findViewById(R.id.guessLetter);
        usedLetters = (TextView) findViewById(R.id.usedLetters);
        gallowImage = (ImageView)findViewById(R.id.gallowView);
        visibleWord = (TextView) findViewById(R.id.synligtOrd);

        images[0] = getResources().getDrawable(R.drawable.galge);
        images[1] = getResources().getDrawable(R.drawable.forkert1);
        images[2] = getResources().getDrawable(R.drawable.forkert2);
        images[3] = getResources().getDrawable(R.drawable.forkert3);
        images[4] = getResources().getDrawable(R.drawable.forkert4);
        images[5] = getResources().getDrawable(R.drawable.forkert5);
        images[6] = getResources().getDrawable(R.drawable.forkert6);


        game = new GalgeLogik();
    }

    public void onGuessLetter(View v){

        game.gætBogstav(guessLetter.getText().toString());
        visibleWord.setText(game.getSynligtOrd());
        usedLetters.setText(game.getBrugteBogstaver().toString());
        Log.i("DEBUG", "Er vi færdige?"+game.erSpilletVundet());
        Log.i("DEBUG", "Hvor mange forkerte?"+game.getAntalForkerteBogstaver());



        if (game.erSpilletTabt()){

            Intent tabtSpil = new Intent(this, SummaryActivity.class);

            tabtSpil.putExtra("TabtEllerVundet", "Tabt");

            startActivity(tabtSpil);


        }

        if (game.erSpilletVundet()){

            Intent vundetSpil = new Intent(this, SummaryActivity.class);

            vundetSpil.putExtra("TabtEllerVundet", "Vundet");
            vundetSpil.putExtra("ForkerteBogstaver", game.getAntalForkerteBogstaver());

            startActivity(vundetSpil);

        }

        if (game.getAntalForkerteBogstaver() < 7) {
            gallowImage.setImageDrawable(images[game.getAntalForkerteBogstaver()]);
        }


        guessLetter.setText("");
        hideKeyboard(v);

    }

    public void onEditClick(View v){

        guessLetter.setText("");
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
}



}
