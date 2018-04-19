package com.example.christophersamuel.propel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    private  Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btn = (Button)findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_day1 = new Intent(ThirdActivity.this, Day1Activity.class);
                openDay1();
            }
        });
    }
    public void openDay1 () {
        Intent go_to_day1 = new Intent(ThirdActivity.this, Day1Activity.class);
        startActivity(go_to_day1);
    }
}
