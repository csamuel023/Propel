package com.example.christophersamuel.propel;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class NotificationOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_option);
    }

    /*public void nopNext(View view)
    {
        RadioGroup rg = findViewById(R.id.radiogroup);

        if(rg.getCheckedRadioButtonId() == -1)
        {
            //Do nothing for now
        }
        else if(rg.getCheckedRadioButtonId() == 0)//Should be yes
        {
            setContentView(R.layout.notification_time);
        }
        else//Should be no
        {
            setContentView(R.layout.activity_main);
        }
    }*/
}
