package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

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

    public void onButtonPress(View v){
        Button b = (Button)v;
        Integer guess = Integer.parseInt(b.getText().toString());
        int toremove = 0;
        if (doors[guess]){
            List doorsnumber = Arrays.asList(1,2,3);
            doorsnumber.remove(guess);
            Random rand = new Random();
            toremove = (int) doorsnumber.get(rand.nextInt(2));
        }else{
            List doorsnumber = Arrays.asList(1,2,3);
            doorsnumber.remove(guess);
            for (int i = 0; i < 2; i++){
                int n = (int) doorsnumber.get(i);
                if (doors[n]){
                    toremove = n;
                }
            }
        }
        for (View view:v.getTouchables()){
            try {
                Button button = (Button)view;
            }catch (Exception e){
                //it's not a button!
            }
            

        }
    }
}