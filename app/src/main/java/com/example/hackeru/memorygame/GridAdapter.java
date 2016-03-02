package com.example.hackeru.memorygame;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hackeru on 29/02/2016.
 */
public class GridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Card> cards;
    private ArrayList<ImageView> clickedImageView = new ArrayList<>(2);
    private ArrayList<Card> clickedCards = new ArrayList<>(2);

    public GridAdapter(Context context, ArrayList<Card> cards) {
        this.context = context;
        this.cards = cards;
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Card getItem(int position) {
        return cards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View cardLayout = layoutInflater.inflate(R.layout.card, null);
        ImageView cardImage = (ImageView) cardLayout.findViewById(R.id.imageView);

        //setting back image on all cards
        cardImage.setImageResource(R.drawable.back);

        //onclick show original image
        cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("GridAdapter", "ImageView Clicked");



                if(Card.getCurrentlyShown() < 2) {
                    clickedImageView.add((ImageView) v);
                    ((ImageView) v).setImageResource(getItem(position).getImageId());
                    clickedCards.add(getItem(position));
                    Card.addCurrentlyShown();
                    if (Card.getCurrentlyShown() == 1 && getItem(position) == clickedCards.get(0)){
                        Toast.makeText(context,"You won",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    hideAllCards();
                    Card.clearCurrentlyShown();
                    clickedImageView.clear();
                }
            }
        });



        return cardLayout;
    }

    private void hideAllCards(){
        for (ImageView imageView:clickedImageView) {
            imageView.setImageResource(R.drawable.back);
        }
    }
}
