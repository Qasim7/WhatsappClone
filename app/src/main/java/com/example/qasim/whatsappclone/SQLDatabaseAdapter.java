package com.example.qasim.whatsappclone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.qasim.whatsappclone.model.Person;

import java.util.ArrayList;

public class SQLDatabaseAdapter {
    private static SQLHelper helper;
    private Context context;

    public SQLDatabaseAdapter(Context context) {
        this.context = context;
    }

    public SQLHelper getHelper() {
        if (helper==null)
            helper=new SQLHelper(context,SQLHelper.DB_NAME,null, SQLHelper.VERSION);
        return helper;
    }
    private SQLiteDatabase getDatabase() {
        return getHelper().getWritableDatabase();
    }
    public long insertPerson(Person person) {
        ContentValues contentValues=new ContentValues();
        contentValues.put(SQLHelper.COLUMN_NAME,person.getName());
        contentValues.put(SQLHelper.COLUMN_NUMBER,person.getNumber());
        contentValues.put(SQLHelper.COLUMN_EMAIL,person.getEmail());
        contentValues.put(SQLHelper.COLUMN_ZIPCODE,person.getZipcode());

        return getDatabase().insert(SQLHelper.TABLE_NAME,null,contentValues);
    }

    public ArrayList<Person> getAllPersons(){
        String[] columns=new String[]{
                SQLHelper.COLUMN_ID,
                SQLHelper.COLUMN_NAME,
                SQLHelper.COLUMN_NUMBER,
                SQLHelper.COLUMN_EMAIL,
                SQLHelper.COLUMN_ZIPCODE
        };

        Cursor cursor=getDatabase().query(SQLHelper.TABLE_NAME,columns,
                null,null,null,null,null);
        ArrayList<Person>list=new ArrayList<>();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            int number=cursor.getInt(2);
            String email=cursor.getString(3);
            String zipcode=cursor.getString(4);
            Person person=new Person(id,name,number,email,zipcode);
            list.add(person);

        }
        return list;
    }
    public Person getPersonWithId(int personId){
        String[] columns=new String[]{
                SQLHelper.COLUMN_ID,
                SQLHelper.COLUMN_NAME,
                SQLHelper.COLUMN_NUMBER,
                SQLHelper.COLUMN_EMAIL,
                SQLHelper.COLUMN_ZIPCODE
        };
        String[] selectionArgs = new String[]{""+personId};

        Cursor cursor=getDatabase().query(SQLHelper.TABLE_NAME,columns,
                SQLHelper.COLUMN_ID+" = ? ",selectionArgs,null,null,null);
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            int number=cursor.getInt(2);
            String email=cursor.getString(3);
            String zipcode=cursor.getString(4);
            Person person=new Person(id,name,number,email,zipcode);
            return person;
        }
        return null;
    }

    private static class SQLHelper extends SQLiteOpenHelper {
        public static final int VERSION = 1;
        public static final String DB_NAME = "database";
        public static final String TABLE_NAME = "task";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_NUMBER = "number";
        public static final String COLUMN_EMAIL = "emil";
        public static final String COLUMN_ZIPCODE = "zipcode";

        public SQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DB_NAME, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(
                    "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                            COLUMN_NAME+" VARCHAR(255), "+
                            COLUMN_NUMBER+" INTEGER, "+
                            COLUMN_EMAIL+" VARCHAR(255), "+
                            COLUMN_ZIPCODE+" VARCHAR(255)"+ ");"
            );

        }







        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}