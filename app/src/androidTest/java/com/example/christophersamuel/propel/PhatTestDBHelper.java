package com.example.christophersamuel.propel;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import android.util.Log;

public class PhatTestDBHelper extends AndroidTestCase {


    public static final String LOG_TAG = PhatTestDBHelper.class.getSimpleName();

    public void testCreateDB() throws Throwable {
        mContext.deleteDatabase("contacts");
        SQLiteDatabase db = new DatabaseHelper(this.mContext).getWritableDatabase();
        assertEquals(true, db.isOpen());
        db.close();
    }
    public void testInsertContact() {
        int id = 0;
        String uname = "PhatDang", email = "dangminhphat1@gmail.com", pass = "phat1";
        DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
        mContext.openOrCreateDatabase("contacts",0,null,null);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from " + databaseHelper.TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        values.put(databaseHelper.COLUMN_ID, id);
        values.put(databaseHelper.COLUMN_UNAME, uname);
        values.put(databaseHelper.COLUMN_EMAIL, email);
        values.put(databaseHelper.COLUMN_PASS, pass);



        long check = db.insert(databaseHelper.TABLE_NAME, null, values);
        assertTrue(check != -1);
        Log.d(LOG_TAG, "new row id " + check);

        String[] columns = {databaseHelper.COLUMN_ID, databaseHelper.COLUMN_UNAME, databaseHelper.COLUMN_EMAIL, databaseHelper.COLUMN_PASS};
        cursor = db.query(databaseHelper.TABLE_NAME, columns, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int iD = cursor.getColumnIndex("ID");
            String iDs = cursor.getString(iD);
            int uName = cursor.getColumnIndex("uname");
            String uNames = cursor.getString(uName);
            int eMail = cursor.getColumnIndex("email");
            String EMAIL = cursor.getString(eMail);
            int pAss = cursor.getColumnIndex("password");
            String Pass = cursor.getString(pAss);
            assertEquals(id, iD);
            assertEquals(uname, uNames);
            assertEquals(email, EMAIL);
            assertEquals(pass, Pass);
        } else {
            fail("No values return");
        }
    }
    public void testSearchPass(){
        DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String query = "select uname, password from " + databaseHelper.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String uname = "PhatDang";
        String uName, passW = "Not Found!";
        String pass = "phat1";
        if (cursor.moveToNext())
            do {
                uName = cursor.getString(0);
                if (uName.equalsIgnoreCase(uname)) {
                    passW = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        cursor.close();
        assertEquals(pass,passW);
    }
}