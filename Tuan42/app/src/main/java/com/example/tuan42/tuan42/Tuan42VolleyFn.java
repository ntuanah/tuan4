package com.example.tuan42.tuan42;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Tuan42VolleyFn {
    String strJSON = "";
    public void getJsonArrayOfObject (Context context, TextView textview)
    {
        //1. Tao request
        RequestQueue queue = Volley.newRequestQueue(context);
        //2.Url
        String url = "https://batdongsanabc.000webhostapp.com/thanglong/array_json_new.json";
        //3. Goi
        //JsonArrayRequest(url, thanhCong, thatBai)
        JsonArrayRequest request = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //chuyen mang sang cac doi tuong
                        for(int i = 0; i<response.length(); i++)
                        {
                            try {
                                JSONObject person = response.getJSONObject(i);//lay tung doi tuong
                                String id = person.getString("id");//lay ve id
                                String name = person.getString("name");//lay name
                                String email = person.getString("email");//lay email
                                //
                                strJSON += "Id: " +id+ "/n";
                                strJSON += "name: " +name+ "/n";
                                strJSON += "email: " +email+ "/n";
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                            textview.setText(strJSON);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textview.setText(error.getMessage());
            }
        });
        //4. thuc thi request
        queue.add(request);
    }
}
