package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private Button btnLogin;
    private ProgressBar bar;
    private TextView txtLinkRegister;
    private static String URL_LOGIN = "http://192.168.43.132/AndroidTest/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);
        bar = findViewById(R.id.progressBar);
        txtLinkRegister = findViewById(R.id.txtLinkRegister);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEmail = email.getText().toString().trim();
                String strPassword = password.getText().toString().trim();

                if(!strEmail.isEmpty() || !strPassword.isEmpty())
                {
                    doLogin(strEmail, strPassword);
                }else
                {
                    email.setError("Please input email");
                    password.setError("Please input password");
                }

            }
        });

    }

    private void doLogin(final String email, final String password)
    {
        bar.setVisibility(View.VISIBLE);
        btnLogin.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if(success.equals("1"))
                            {
                                for(int i = 0; i < jsonArray.length(); i++)
                                {
                                    JSONObject loginObject = jsonArray.getJSONObject(i);

                                    String loginName = loginObject.getString("name").trim();
                                    String loginEmail = loginObject.getString("email").trim();

                                    UserPreferences.setLoggedInEmail(getApplicationContext(), loginEmail);
                                    UserPreferences.setLoggedInName(getApplicationContext(), loginName);

                                    btnLogin.setVisibility(View.VISIBLE);
                                    bar.setVisibility(View.GONE);

                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));


                                }
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this, "Failed to login" + e.toString(), Toast.LENGTH_SHORT).show();
                            btnLogin.setVisibility(View.VISIBLE);
                            bar.setVisibility(View.GONE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "Failed to login" + error.toString(), Toast.LENGTH_SHORT).show();
                        btnLogin.setVisibility(View.VISIBLE);
                        bar.setVisibility(View.GONE);
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(stringRequest);

    }
}
