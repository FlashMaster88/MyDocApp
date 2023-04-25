package com.example.mydocapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class DocAvailable extends AppCompatActivity {

    RecyclerView doctorRecyclerView;
    DoctorsAdapter adapter;
    RequestQueue requestQueue;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_available);

        Singleton.getInstance().setContext(DocAvailable.this);
        doctorRecyclerView = findViewById(R.id.doctorRecyclerView);

        setTitle("Doctors Available");

        adapter = new DoctorsAdapter();
        doctorRecyclerView.setAdapter(adapter);
        doctorRecyclerView.setLayoutManager(
                new LinearLayoutManager(DocAvailable.this)
        );
        doctorRecyclerView.addItemDecoration(
                new DividerItemDecoration(DocAvailable.this,
                        DividerItemDecoration.VERTICAL)
        );

        for(int i = 0; i<= 9; i++) {
            int hh = random.nextInt((6 - 1) + 1) + 1;;

                requestQueue = Volley.newRequestQueue(DocAvailable.this);
                StringRequest stringRequest = new StringRequest(
                        Request.Method.GET, "https://api.namefake.com/",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                String name = "";
                                String address = "";
                                try {
                                    JSONObject jObject = new JSONObject(response);
                                    address = jObject.getString("address");
                                    name = jObject.getString("name");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                SingletonDoc.getInstance().doctorLists.add(new DoctorList("Dr. " + name, address, "Online at " + hh + ":" + "00 pm"));
                                adapter.notifyItemInserted(
                                        SingletonDoc.getInstance().doctorLists.size() - 1);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
                );
                requestQueue.add(stringRequest);

        }

        adapter.setClickListener(new DoctorsAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View view) {

                Intent intent = new Intent(DocAvailable.this,
                        ScheduleAppointment.class);
                DoctorList c = SingletonDoc.getInstance().doctorLists.get(position);

                intent.putExtra("docname",c.getDoctorname());
                intent.putExtra("docaddress",c.getdoctoraddress());
                intent.putExtra("doctime",c.gettime());

                startActivity(intent);

            }
        });
    }
}