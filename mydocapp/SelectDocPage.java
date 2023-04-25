package com.example.mydocapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SelectDocPage extends AppCompatActivity{

    Spinner spinnerdoc;
    Spinner spinnercity;
    Button searchbutton;

    String[] DoctorList = {"Allergists","Anesthesiologists","Cardiac surgeons",
            "Cardiologists","Dermatologists","Endocrinologists","Family practice physician",
            "Gastroenterologists","General surgeons","Geriatric medicine doctors",
            "Infectious disease doctors","Nephrologists","Neurologists",
            "Obstetrician/gynecologists","Oncologists","Ophthalmologists",
            "Orthopedic surgeons","Otolaryngologists","Pediatricians","Psychiatrists",
            "Pulmonologists","Radiologists", "Urologists" };

    String[] CityList = {"Angers","Bordeaux","Dijon",
            "Grenoble","Le Havre","Lille","Lyon",
            "Marseille","Montpellier","Nantes",
            "Nice","Paris","Reims",
            "Rennes","Saint-Denis","Saint-Étienne",
            "Strasbourg","Toulon","Toulouse","Villeurbanne"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_doc_page);

        setTitle("Select the doctor");

        spinnerdoc = findViewById(R.id.spinnerdoc);
        searchbutton = findViewById(R.id.searchbutton);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,DoctorList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerdoc.setAdapter(aa);
        spinnerdoc.getSelectedItemPosition();

        spinnercity = findViewById(R.id.spinnercity);

        ArrayAdapter bb = new ArrayAdapter(this,android.R.layout.simple_spinner_item,CityList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercity.setAdapter(bb);
        spinnercity.getSelectedItemPosition();

        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SelectDocPage.this,
                        DocAvailable.class);
                startActivity(intent);

            }});
    }
}