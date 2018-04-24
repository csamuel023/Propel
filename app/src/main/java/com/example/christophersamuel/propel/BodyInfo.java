package com.example.christophersamuel.propel;
import android.content.Context;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BodyInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bodyinfo);
    }


    public static void saveBodyInfo(String height, String weight, String age, boolean gender, boolean active, Context context) throws IOException //true = male, active
    {
        String filename = "savedBodyInfo";
        FileOutputStream out = null;
        String content = "Height: " + height + "\nWeight: " + weight + "\nAge: " + age + "\nGender: ";
        content += (gender) ? "male" : "female";

        try//Tries opening file as if it already exists
        {
            out = context.openFileOutput(filename, Context.MODE_PRIVATE);
            out.write(content.getBytes());
        }
        catch(FileNotFoundException e)//Creates new file if it doesn't exist
        {
            out = new FileOutputStream(filename);
            out.write(content.getBytes());
        }
        finally
        {
            out.close();
        }

    }




}
