package com.example.deanc.gotquotes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ezraerani on 6/3/16.
 */
public class QuoteView extends Fragment {

    View view;
    DataHandler dataHandler;
    Quote quote;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.quote_view, container);
        dataHandler = DataHandler.getInstance();
        quote = dataHandler.getSelectedQuote();

        ImageView imageView = (ImageView) view.findViewById(R.id.characterFace);
        imageView.setImageResource(quote.getImageResource());

        TextView charName = (TextView) view.findViewById(R.id.characterName);
        charName.setText(quote.getSayer());

        TextView theQuote = (TextView) view.findViewById(R.id.chosenQuote);
        theQuote.setText(quote.getSaid());


        return view;
    }
}
