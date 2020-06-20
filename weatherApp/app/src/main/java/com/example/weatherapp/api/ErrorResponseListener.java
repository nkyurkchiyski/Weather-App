package com.example.weatherapp.api;

import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.weatherapp.views.BaseActivity;

public class ErrorResponseListener implements Response.ErrorListener{
    private final BaseActivity activity;

    public ErrorResponseListener(final BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onErrorResponse(final VolleyError error) {
        Toast.makeText(activity, "Weather service is not responding", Toast.LENGTH_LONG).show();
    }
}
