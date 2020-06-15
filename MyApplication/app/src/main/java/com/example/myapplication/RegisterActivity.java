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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText name, email, password, cPassword;
    private Button btnRegister;
    private TextView txtLinkLogin;
    private ProgressBar bar;
    private static String URL_REGISTER = "http://192.168.43.132/AndroidTest/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.editName);
        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);
        cPassword = findViewById(R.id.editCPassword);

        bar = findViewById(R.id.progressBar);

        btnRegister = findViewById(R.id.btnRegister);

        txtLinkLogin = findViewById(R.id.txtLinkLogin);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameStr = name.getText().toString().trim();
                String passwordStr = password.getText().toString().trim();
                String emailStr = email.getText().toString().trim();
                Register(nameStr, passwordStr, emailStr);
            }
        });

        txtLinkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }

    private void Register(final String name, final String password, final String email)
    {
        bar.setVisibility(View.VISIBLE);
        btnRegister.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if(success.equals("1"))
                            {
                                Toast.makeText(RegisterActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                                bar.setVisibility(View.GONE);
                                btnRegister.setVisibility(View.VISIBLE);
                            }

                        } catch (JSONException e) {
                            Toast.makeText(RegisterActivity.this, "Failed to register" + e.toString(), Toast.LENGTH_SHORT).show();
                            bar.setVisibility(View.GONE);
                            btnRegister.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegisterActivity.this, "Failed to register" + error.toString(), Toast.LENGTH_SHORT).show();
                        bar.setVisibility(View.GONE);
                        btnRegister.setVisibility(View.VISIBLE);
                    }
                })
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
        requestQueue.add(stringRequest);

    }

}
