package com.example.joanericacanada.trainingday4.Activity.View;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.joanericacanada.trainingday4.Activity.Controller.CountryJSONParser;
import com.example.joanericacanada.trainingday4.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String strJson =
                "{ " +
                        " \"countries\":[ " +
                            "{" +
                                "\"countryname\": \"India\","+
                                "\"flag\": "+ R.drawable.india + ","+
                                "\"language\": \"Hindi\","+
                                "\"capital\": \"New Delhi\"," +
                                "\"currency\": {" +
                                    "\"code\": \"INR\", " +
                                    "\"currencyname\": \"Rupee\" " +
                                "}" +
                            "}, " +

                            "{" +
                                "\"countryname\": \"Pakistan\","+
                                "\"flag\": "+ R.drawable.pakistan + ","+
                                "\"language\": \"Urdu\","+
                                "\"capital\": \"Islamabad\"," +
                                "\"currency\": {" +
                                    "\"code\": \"PKR\", " +
                                    "\"currencyname\": \"Pakistani Rupee\" " +
                                "}" +
                            "}," +

                            "{" +
                                "\"countryname\": \"Sri Lanka\","+
                                "\"flag\": "+ R.drawable.srilanka + ","+
                                "\"language\": \"Sinhala\","+
                                "\"capital\": \"Sri Jayawardenapura Kotte\"," +
                                "\"currency\": {" +
                                    "\"code\": \"SKR\", " +
                                    "\"currencyname\": \"Sri Lankan Rupee\" " +
                                "}" +
                            "}" +
                        "]" +
                "} ";

        ListViewLoaderTask listViewLoaderTask = new ListViewLoaderTask();
        listViewLoaderTask.execute(strJson);
    }

    private class ListViewLoaderTask extends AsyncTask<String, Void, SimpleAdapter>{
        JSONObject jObject;

        @Override
        protected SimpleAdapter doInBackground(String... strJson) {
            try{
                jObject = new JSONObject(strJson[0]);
                CountryJSONParser countryJsonParser = new CountryJSONParser();
                countryJsonParser.parse(jObject);
            }catch(Exception e){
                Log.d("JSON Exception1",e.toString());
            }

            CountryJSONParser countryJsonParser = new CountryJSONParser();
            List<HashMap<String, String>> countries = null;

            try{
                countries = countryJsonParser.parse(jObject);
            }catch(Exception e){
                Log.d("Exception",e.toString());
            }

            String[] from = { "country","flag"};
            int[] to = { R.id.tv_country,R.id.iv_flag};
            SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), countries, R.layout.listview_layout, from, to);

            return adapter;
        }

        @Override
        protected void onPostExecute(SimpleAdapter adapter) {
            ListView listView = ( ListView ) findViewById(R.id.lv_countries);
            listView.setAdapter(adapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}