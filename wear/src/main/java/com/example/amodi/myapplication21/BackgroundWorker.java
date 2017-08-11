package com.example.amodi.myapplication21;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by amodi on 8/5/2017.
 */

public class BackgroundWorker extends AsyncTask<String,Void,Void> {
    Context context;
    BackgroundWorker (Context ctx){
        context= ctx;
    }

    @Override
    protected Void doInBackground(String... params) {
        return null;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }
    @Override
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
    }
    @Override
    protected void onProgressUpdate(Void... values){
        super.onProgressUpdate(values);
    }
}
