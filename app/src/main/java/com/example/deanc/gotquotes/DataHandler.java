package com.example.deanc.gotquotes;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ezraerani on 6/3/16.
 */
public class DataHandler {

    private static DataHandler instance = new DataHandler();
    private String[] characters = {"bronn", "jaime", "cersei", "tyrion", "varys","renly", "hound",
                                    "littlefinger", "olenna", "brynden"};
    private Quote selectedQuote = null;

    private DataHandler() {
    }

    public static DataHandler getInstance() {
        return instance;
    }

    public Quote getSelectedQuote() {
        return selectedQuote;
    }

    private String setSelectedQuote(Quote selectedQuote, int random) {
        this.selectedQuote = selectedQuote;

        return setQuoteImage(random);
    }

    private String setQuoteImage(int random) {

        switch (characters[random]){
            case "bronn":
//                selectedQuote.setImageResource();
                break;
            case "jaime":
//                selectedQuote.setImageResource();
                break;
            case "cersei":
//                selectedQuote.setImageResource();
                break;
            case "tyrion":
//                selectedQuote.setImageResource();
                break;
            case "varys":
//                selectedQuote.setImageResource();
                break;
            case "renly":
//                selectedQuote.setImageResource();
                break;
            case "hound":
//                selectedQuote.setImageResource();
                break;
            case "littlefinger":
//                selectedQuote.setImageResource();
                break;
            case "olenna":
//                selectedQuote.setImageResource();
                break;
            case "brynden":
//                selectedQuote.setImageResource();
                break;
            default:
                break;
        }

        return "OK";
    }

    public String makeNetworkCall() {
        int random = (int) (Math.round(Math.random()*10) + 1);
        Log.d("RANDOM", Integer.toString(random));

        HttpURLConnection con = null;
        BufferedReader reader = null;
        final String BASE_URL = "https://got-quotes.herokuapp.com/quotes?char=";



        try {

            URL object = new URL(BASE_URL + characters[random]);
            con = (HttpURLConnection) object.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            InputStream stream = con.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));


            StringBuffer buffer = new StringBuffer();

            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            JSONArray jsonArray = new JSONArray(buffer.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            return setSelectedQuote(new Quote(jsonObject.getString("character"), jsonObject.getString("quote"))
            , random);


        } catch (Exception e) {
            Log.d("CATCH_HTTP_REQUEST", "CALLED");
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
