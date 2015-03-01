package org.buraktamturk.loadingview.sample;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.buraktamturk.loadingview.LoadingView;

public class MainActivity extends Activity implements View.OnClickListener {

    LoadingView parentLoadingView;
    LoadingView loginLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentLoadingView = (LoadingView)findViewById(R.id.parentLoadingView);
        loginLoadingView = (LoadingView)findViewById(R.id.loginLoadingView);

        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.setLoadingTrueParent).setOnClickListener(this);


        // call parentLoadingView.setLoading(false) after 3 seconds
        new LongOperation(parentLoadingView).execute();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                loginLoadingView.setLoading(true);

                // call loginLoadingView.setLoading(false) after 3 seconds
                new LongOperation(loginLoadingView).execute();
                break;
            case R.id.setLoadingTrueParent:
                parentLoadingView.setText(R.string.setLoadingTrue);
                parentLoadingView.setLoading(true);
                // call parentLoadingView.setLoading(false) after 3 seconds
                new LongOperation(parentLoadingView).execute();
                break;
        }
    }


    private class LongOperation extends AsyncTask<Void, Void, Void> {
        LoadingView lv;

        LongOperation(LoadingView view) {
            lv = view;
        }

        @Override
        protected Void doInBackground(Void... params) {

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            lv.setLoading(false);
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }

}
