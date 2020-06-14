/*
@George Arthur
This class fetches data from the API using the volley library.
It then passes the data to an adapter in a recycle view for it to be displayed on the screen
 */



package com.example.listviewtutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity  {
    private static final String URL_DATA="https://learnappmaking.com/ex/news/articles/Apple?secret=CHWGk3OTwgObtQxGqdLvVhwji6FsYm95oe87o3ju";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter madapter;
    private List<recyclevi> listItems;
    public static final String IMAGE_URL = "image";
    public static final String TITLE = "title";
    public static final String PUBLISHER = "publisher";
    public static final String INFO= "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
         loadrecyclerviewData();
    }
    //method to load json data
    private  void loadrecyclerviewData(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("articles");
                    for (int i =0; i<jsonArray.length();i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        recyclevi recyclevi = new recyclevi();
                        recyclevi.setTitle(jsonObject1.getString("title"));
                        recyclevi.setPublisher(jsonObject1.getString("publisher"));
                        recyclevi.setInform(jsonObject1.getString("text"));
                        recyclevi.setImageUrl(jsonObject1.getString("image"));
                        listItems.add(recyclevi);

                    }


                    madapter = new MyAdapter(listItems,MainActivity.this);
                    recyclerView.setAdapter(madapter);


                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });

        RequestQueue requestQueue =  Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
