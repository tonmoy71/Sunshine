package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        //
        private ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            // rootView is the root node of View hierarchy/tree. It is used to traverse through the
            // tree to get a specific element by searching its id.

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // ListView will contain these hard-coded string data.
            String[] forecastArray = {
                    "Today - Sunny - 88/63",
                    "Tomorrow - Foggy - 70/40",
                    "Weds - Cloudy 72/63",
                    "Thurs - Asteroids - 75/65",
                    "Friday - Heavy Rain - 75/56",
                    "Sat - HELP TRAPPED IN WEATHER STATION - 60/51",
                    "Sun - Sunny - 80.68"
            };

            // ArrayList for easier manipulation of String data.
            ArrayList<String> weekForecast = new ArrayList<String>(Arrays.asList(forecastArray));

            // Adapter is created with these parameters.
            mForecastAdapter = new ArrayAdapter<String>(
                    // The current context
                    getActivity(),
                    // ID of list item layout
                    R.layout.list_item_forecast,
                    // ID of the textview to populate
                    R.id.list_item_forecast_textview,
                    // forecast data
                    weekForecast
            );

            // Reference to the ListView created in the fragment_main.xml file.
            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            // Bind the adapter to the ListView.
            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
