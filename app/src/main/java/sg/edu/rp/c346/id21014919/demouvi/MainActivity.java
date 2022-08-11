package sg.edu.rp.c346.id21014919.demouvi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvUVI;
    AsyncHttpClient client;
    UVIAdapter aaUVI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvUVI = findViewById(R.id.lvUVI);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<UVI> alUVI = new ArrayList<UVI>();
        aaUVI = new UVIAdapter(this,
                R.layout.row, alUVI);

        lvUVI.setAdapter(aaUVI);

        client.get("https://api.data.gov.sg/v1/environment/uv-index", new JsonHttpResponseHandler() {

            int value;
            String timestamp;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray jsonArrValue = response.getJSONArray("value");
                    JSONObject firstObj = jsonArrValue.getJSONObject(0);
                    JSONArray jsonArrTimestamps = firstObj.getJSONArray("timestamp");
                    for(int i = 0; i < jsonArrTimestamps.length(); i++) {
                        JSONObject jsonArrTimestamp = jsonArrTimestamps.getJSONObject(i);
                        value = Integer.parseInt(jsonArrTimestamp.getString("value"));
                        timestamp = jsonArrTimestamp.getString("date");
                        UVI uvi = new UVI(value, timestamp);
                        alUVI.add(uvi);
                    }
                }
                catch(JSONException e) {

                }
                aaUVI.notifyDataSetChanged();
                //POINT X – Code to display List View

            }//end onSuccess
        });
    }//end onResume



}