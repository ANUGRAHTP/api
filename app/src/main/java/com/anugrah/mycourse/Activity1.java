package com.anugrah.mycourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.PrecomputedText;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Activity1 extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5;
    Button bt;
    String s1,s2,s3,s4,s5;

    CourseModel c;

    String WebApi="https://dummyapilist.herokuapp.com/addcourse";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        c= new CourseModel();


        e1=(EditText)findViewById(R.id.ct);
        e2=(EditText)findViewById(R.id.cd);
        e3=(EditText)findViewById(R.id.cdu);
        e4=(EditText)findViewById(R.id.cv);
        e5=(EditText)findViewById(R.id.cda);

        bt=(Button)findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();

                c.getDate(s1);
                c.getDescription(s2);
                c.getDuration(s3);
                c.getTitle(s4);
                c.getVenue(s5);


                String tt=c.getTitle(s4);
                String de=c.getDescription(s2);
                String du=c.getDuration(s3);
                String ve=c.getVenue(s5);
                String tda=c.getDate(s1);


                Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),s2,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),s3,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),s4,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),s5,Toast.LENGTH_SHORT).show();


                callApi();







            }
        });



    }

    private void callApi() {



        StringRequest stringRequest=new StringRequest(Request.Method.POST, WebApi, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap<String,String>params=new HashMap<>();
                params.put("courseTitle",s4);
                params.put("courseDate",s1);
                params.put("coursedescription",s2);
                params.put("courseDuration",s3);
                params.put("coursevenue",s5);


                return params;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}
