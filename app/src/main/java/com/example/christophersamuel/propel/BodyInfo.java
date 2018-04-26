package com.example.christophersamuel.propel;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class BodyInfo extends AppCompatActivity
{
    public final static String FILENAME = "savedBodyInfo";
    private EditText height;
    private EditText weight;
    private EditText age;
    private RadioButton rb;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bodyinfo);

        height = findViewById(R.id.inHeight);
        weight = findViewById(R.id.inWeight);
        age = findViewById(R.id.inAge);
        rb = findViewById(R.id.rbMale);
        rb2 = findViewById(R.id.rbFemale);
        rb3 = findViewById(R.id.rbActive);
        rb4 = findViewById(R.id.rbPassive);

        //Tries to read info from file
        BufferedReader in;
        try
        {
            in = new BufferedReader(new FileReader(new File(this.getFilesDir(), FILENAME)));
        }
        catch(FileNotFoundException e)
        {
            Toast toast = Toast.makeText(this, "File not found", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        //Tries to set info into page
        try
        {
            height.setText(in.readLine(), TextView.BufferType.NORMAL);
            weight.setText(in.readLine(), TextView.BufferType.NORMAL);
            age.setText(in.readLine(), TextView.BufferType.NORMAL);
            String gender = in.readLine();
            if(gender.equalsIgnoreCase("male"))
                rb.setChecked(true);
            else
                rb2.setChecked(true);

            in.close();
        }
        catch(IOException e)
        {
            Toast toast = Toast.makeText(this, "IOException", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    //Next button code for body info
    //Body info
    public void biNext(View view)
    {
        boolean gender = rb.isChecked();
        boolean active = rb3.isChecked();
        Intent intent = null;

        try
        {
            saveBodyInfo(height.getText().toString(), weight.getText().toString(), age.getText().toString(), gender, active, this);
        }
        catch(IOException e)
        {
            return;
        }

        if(rb3.isChecked())//Should be active
        {
            intent = new Intent(this, NotificationOption.class);
        }
        else if(rb4.isChecked())//Should be passive
        {
            intent = new Intent(this, NotificationTime.class);
        }
        else
        {
            //Do nothing for now
        }
        startActivity(intent);
    }

    //Saves body data to internal storage
    public static void saveBodyInfo(String height, String weight, String age, boolean gender, boolean active, Context context) throws IOException //true = male, active
    {
        FileOutputStream out = null;
        String content = "" + height + "\n" + weight + "\n" + age + "\n";
        content += (gender) ? "male" : "female";

        try//Tries opening file as if it already exists
        {
            out = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            out.write(content.getBytes());
        }
        catch(FileNotFoundException e)//Creates new file if it doesn't exist
        {
            out = new FileOutputStream(FILENAME);
            out.write(content.getBytes());
            Toast toast = Toast.makeText(context, "Creating new file", Toast.LENGTH_SHORT);
            toast.show();
        }
        finally
        {
            out.close();
        }

    }




}
