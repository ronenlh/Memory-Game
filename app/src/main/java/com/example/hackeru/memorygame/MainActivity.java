package com.example.hackeru.memorygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Card> cardArray = new ArrayList<>();
    private ArrayList<Card> cards = new ArrayList<>();
    private int[] images = {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initCardArray();
        initCards();
        GridAdapter gridAdapter = new GridAdapter(this,cards);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(gridAdapter);


    }

    private void initCardArray() {
        for (int image : images) {
            cardArray.add(new Card(image));
        }
    }

    private void initCards(){
        for (Card card : cardArray) {
            cards.add(card);
            cards.add(card);
        }
    }

}
