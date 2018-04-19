package com.example.christophersamuel.propel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
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
                openLoginActivity();
            }
        });

        // ****************END OF CODE********************
    }
    public void openLoginActivity(){
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }
}
