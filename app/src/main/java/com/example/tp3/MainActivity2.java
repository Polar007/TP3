package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private int guess;
    private int trueDoor;
    @SuppressLint("StringFormatMatches")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.guess = extras.getInt("guess");
            this.trueDoor = extras.getInt("trueDoor");
        }

        int otherDoor = 3 - guess - trueDoor; //The text displayed is different with each execution
        ((TextView)findViewById(R.id.textView)).setText(getString(R.string.ChangeChoice, otherDoor));
        setContentView(R.layout.activity_main2);
    }

    protected void yesOrNo(View v){
        Button b = (Button) v;
        String text = (String) b.getText();
        if(text.equals("Yes")){
            if(guess == trueDoor) setContentView(R.layout.won);
            else setContentView(R.layout.lost);
        }
        else{
            if(guess != trueDoor) setContentView(R.layout.lost);
            else setContentView(R.layout.won);
        }
    }


}