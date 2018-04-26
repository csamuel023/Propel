package com.example.christophersamuel.propel;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class NotificationOption extends AppCompatActivity {

    private RadioButton yes;
    private RadioButton no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_option);

        yes = findViewById(R.id.notOpYes);
        no = findViewById(R.id.notOpNo);
    }


    //NotificationOption
    public void nopNext(View view)
    {
        Intent intent = null;
        if(yes.isChecked())
        {
            intent = new Intent(this, NotificationTime.class);
        }
        else if(no.isChecked())
        {
            intent = new Intent(this, ThirdActivity.class);
        }
        else
        {
            //Do nothing for now
        }

        startActivity(intent);
    }
}
