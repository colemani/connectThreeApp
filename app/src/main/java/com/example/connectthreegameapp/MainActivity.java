package com.example.connectthreegameapp;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
    {
        //activeplayer: 0 batman, 1 superman, 2 empty
      
        int activeplayer = 0;
        
    int gamestate[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{1,2,3}, {4,5,6}, {7,8,9}, {1,4,7}, {2,5,9}, {3,6,9}, {3,5,7}, {1,5,9}};
    
        public void dropIn (View view)
        
        {
          
            ImageView counter = (ImageView) view;
            counter.getTag();
            Log.i("Tag", counter.getTag().toString());
            int tappedCounter = Integer.parseInt(counter.getTag().toString());
           
            gamestate[tappedCounter] = activeplayer;
            counter.setTranslationY(-1500);
            
            
            if(activeplayer==0) {
                counter.setImageResource(R.drawable.batmanbutton);
               // gamestate [tappedCounter] = activeplayer;
                activeplayer=1;
            }
            else
            {
                counter.setImageResource(R.drawable.supermanbutton);
               // gamestate [tappedCounter] = activeplayer;
                activeplayer=0;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(1000);
            
            for (int[] winningposition : winningPositions)
            {
                if ((gamestate[winningposition[0]] == gamestate[winningposition[1]] && gamestate[winningposition[1]] != 2))
                //&& gamestate[winingposition[1]] == gamestate[winingposition[2]] && gamestate[winingposition[1]] != 2)
                {
                    Toast.makeText(this, "someone won", Toast.LENGTH_SHORT).show();
                }
                
                
                else
                {
                    Toast.makeText(this, "keep playing", Toast.LENGTH_SHORT).show();
                }
            }
        
        }
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    }
