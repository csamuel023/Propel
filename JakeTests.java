package com.example.christophersamuel.propel;

import org.junit.Test;


import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by Jake on 4/28/2018.
 */

public class JakeTests {


    @Test
    public void saveBodyInfo() throws Exception
    {
        BodyInfo.saveBodyInfo("6", "180", "21", true, true, BodyInfo.getContext());
        BufferedWriter out = new BufferedWriter(new FileWriter("test"));
        out.write("6");
        out.newLine();
        out.write("180");
        out.newLine();
        out.write("21");
        out.newLine();
        out.write("male");
        out.newLine();
        out.write("active");
        out.close();
        File f1 = new File(BodyInfo.getContext().getFilesDir(), BodyInfo.FILENAME);
        File f2 = new File("test");
        assertEquals("The Files don't match", f1, f2);
    }

}