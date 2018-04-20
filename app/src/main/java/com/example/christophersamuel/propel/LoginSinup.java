package com.example.christophersamuel.propel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginSinup extends AppCompatActivity {
    DatabaseHelper dbHelper = new DatabaseHelper(this);
    private Button bSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sinup);

        bSignIn = (Button) findViewById(R.id.bSignIn);
        bSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //find text id
                AutoCompleteTextView email_uname = (AutoCompleteTextView) findViewById(R.id.email_uname);
                EditText pass = (EditText) findViewById(R.id.password);

                // get texts from id
                String id = email_uname.getText().toString();
                String passW = pass.getText().toString();

                //Search for valid info
                String passwordHelper = dbHelper.searchPass(id);
                if(passW.equals(passwordHelper)){
                    openThirdActivity();
                }
                else{
                    Toast error = Toast.makeText(LoginSinup.this, "Username and password don't match", Toast.LENGTH_SHORT);
                    error.show();
                }
            }
        });
    }
    public void openThirdActivity(){
        Intent intent = new Intent(LoginSinup.this,ThirdActivity.class);
        startActivity(intent);
    }
}
