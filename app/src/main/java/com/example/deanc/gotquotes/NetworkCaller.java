package com.example.deanc.gotquotes;

import android.os.AsyncTask;

/**
 * Created by ezraerani on 6/3/16.
 */
public class NetworkCaller {

    MyActivity myActivity;
    DataHandler dataHandler;

    public NetworkCaller(MyActivity myActivity) {
        this.myActivity = myActivity;
        dataHandler = DataHandler.getInstance();
    }

    public void getMeAQuote() {
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
    }

    class MyAsyncTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            return dataHandler.makeNetworkCall();
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            myActivity.showMeTheQuote();
        }
    }
}
