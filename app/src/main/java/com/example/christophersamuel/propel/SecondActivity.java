package com.example.christophersamuel.propel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity {

    DatabaseHelper dbHelper = new DatabaseHelper(this);
    private Button btn;
    private final Pattern hasUppercase = Pattern.compile("[A-Z]");
    private final Pattern hasLowercase = Pattern.compile("[a-z]");
    private final Pattern hasNumber = Pattern.compile("\\d");
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

                if(!pass1Str.equals(pass2Str) || !emailStr.contains("@") || pass1Str.length() <= 6 || unameStr.length() <= 5 ||
                        !hasUppercase.matcher(pass1Str).find() && !hasLowercase.matcher(pass1Str).find() || !hasNumber.matcher(pass1Str).find())
                {
                    //pop up message
                    if(unameStr.length() <= 5){
                        Toast shortUN = Toast.makeText(SecondActivity.this, " Username should be more than 5 characters", Toast.LENGTH_SHORT);
                        uname.setText("");
                        shortUN.show();
                    }
                    if(!emailStr.contains("@")) {
                        Toast errorEmail = Toast.makeText(SecondActivity.this, "Invalid email!", Toast.LENGTH_SHORT);
                        email.setText("");
                        errorEmail.show();
                    }
                    if(pass1Str.length() <= 6){
                        Toast shortPass = Toast.makeText(SecondActivity.this, " Password should be more than 6 characters", Toast.LENGTH_SHORT);
                        pass1.setText("");
                        shortPass.show();
                    }
                    if(!pass1Str.equals(pass2Str)) {
                        Toast wrongPass = Toast.makeText(SecondActivity.this, " Password don't match!", Toast.LENGTH_SHORT);
                        pass2.setText("");
                        wrongPass.show();
                    }
                    if(!hasUppercase.matcher(pass1Str).find()){
                        Toast errorPass = Toast.makeText(SecondActivity.this, "Password must contains at least 1 capital letter", Toast.LENGTH_SHORT);
                        pass1.setText("");
                        errorPass.show();
                    }
                    if(!hasLowercase.matcher(pass1Str).find()){
                        Toast errorPass = Toast.makeText(SecondActivity.this, "Password must contains lower letter", Toast.LENGTH_SHORT);
                        pass1.setText("");
                        errorPass.show();
                    }
                    if(!hasNumber.matcher(pass1Str).find()){
                        Toast errorPass = Toast.makeText(SecondActivity.this, "Password must contains at least 1 number", Toast.LENGTH_SHORT);
                        pass1.setText("");
                        errorPass.show();
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
