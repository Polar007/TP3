package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    boolean[] doors = {false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void createRandomDoors(){
        int trueDoorNumber = (int) (Math.random() * 2);
    }

    public void onButtonPress(View v) {
        Button b = (Button) v;
        int guess = Integer.parseInt(b.getText().toString());
        int toRemove = 0;
        if (doors[guess]) {
            List doorsNumber = Arrays.asList(1, 2, 3);
            doorsNumber.remove(guess);
            Random rand = new Random();
            toRemove = (int) doorsNumber.get(rand.nextInt(2));
        } else {
            List doorsNumber = Arrays.asList(1, 2, 3);
            doorsNumber.remove(guess);
            for (int i = 0; i < 2; i++) {
                int n = (int) doorsNumber.get(i);
                if (!doors[n]) {
                    toRemove = n;
                }
            }
        }
        switchActivities(toRemove);
    }
    private void switchActivities(int toRemove) {
            Intent switchActivityIntent = new Intent(this, MainActivity2.class);
            switchActivityIntent.putExtra("toRemove", toRemove);
            startActivity(switchActivityIntent);
        }

    public void APropos(View v){
        Intent myintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Monty_Hall"));
        startActivity(myintent);
    }
}