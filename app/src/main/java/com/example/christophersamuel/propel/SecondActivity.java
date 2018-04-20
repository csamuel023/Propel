package com.example.christophersamuel.propel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    DatabaseHelper dbHelper = new DatabaseHelper(this);
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // ***************START OF CODE*******************

        //Button button = (Button) findViewById(R.id.
        btn = (Button)findViewById(R.id.bRegister);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText uname = (EditText) findViewById(R.id.uname);
                EditText email = (EditText) findViewById(R.id.email);
                EditText pass1 = (EditText) findViewById(R.id.pass1);
                EditText pass2 = (EditText) findViewById(R.id.pass2);

                String unameStr = uname.getText().toString();
                String emailStr = email.getText().toString();
                String pass1Str = pass1.getText().toString();
                String pass2Str = pass2.getText().toString();

                if(!pass1Str.equals(pass2Str) || !emailStr.contains("@") ){
                    //pop up message
                    if(!pass1Str.equals(pass2Str)) {
                        Toast wrongPass = Toast.makeText(SecondActivity.this, " Password don't match!", Toast.LENGTH_SHORT);
                        wrongPass.show();
                    }
                    if(!emailStr.contains("@")) {
                        Toast errorEmail = Toast.makeText(SecondActivity.this, "Invalid email!", Toast.LENGTH_SHORT);
                        errorEmail.show();
                    }
                }
                else {
                    //insert data into contact
                    Contact contact = new Contact();
                    contact.setUname(unameStr);
                    contact.setEmail(emailStr);
                    contact.setPassword(pass1Str);

                    // save data into database
                    dbHelper.insertContact(contact);
                    openLoginActivity();
                }
            }
        });

        // ****************END OF CODE********************
    }
    public void openLoginActivity(){
        Intent intent = new Intent(this,LoginSinup.class);
        startActivity(intent);
    }
}
