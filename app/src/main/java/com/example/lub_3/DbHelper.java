package com.example.lub_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "StudentManager";
    private static final String TABLE_STUDENT = "student";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LNAME = "lname";
    private static final String KEY_ONAME = "oname";
    private static final String KEY_DATE = "date";

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String script = "CREATE TABLE " + TABLE_STUDENT + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_LNAME + " TEXT,"
                + KEY_ONAME + " TEXT,"
                + KEY_DATE + " TEXT" + ")";
        db.execSQL(script);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(db);
    }

    void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getName());
        values.put(KEY_LNAME, student.getLName());
        values.put(KEY_ONAME, student.getOName());
        values.put(KEY_DATE, student.getDate());

        db.insert(TABLE_STUDENT, null, values);
        db.close();
    }

    public List<Student> getAllContacts() {
        List<Student> contactList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_STUDENT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setName(cursor.getString(1));
                student.setLName(cursor.getString(2));
                student.setOName(cursor.getString(3));
                student.setDate(cursor.getString(4));

                contactList.add(student);

            } while (cursor.moveToNext());
        }
        return contactList;
    }

    public int updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getName());
        values.put(KEY_LNAME, student.getLName());
        values.put(KEY_ONAME, student.getOName());
        values.put(KEY_DATE, student.getDate());

        return db.update(TABLE_STUDENT, values, KEY_ID + "=?",
                new String[]{String.valueOf(student.getId())});
    }

    public int getStudentCount() {
        String countQuery = "SELECT * FROM " + TABLE_STUDENT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int studentCount = cursor.getCount();
        cursor.close();

        return studentCount;
    }

    public void delete() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_STUDENT);
        db.close();
    }
    //    Student getStudent(int id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_STUDENT, new String[]{KEY_ID, KEY_NAME, KEY_DATE}, KEY_ID + "=?",
//                new String[]{String.valueOf(id)}, null, null, null, null);
//        if (cursor != null) {
//            cursor.moveToFirst();
//        }
//
//        Student student = new Student(Integer.parseInt(cursor.getString(0)),
//                cursor.getString(1),
//                cursor.getString(2));
//        return  student;
//    }
//
//    public void deleteStudent(Student student) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_STUDENT, KEY_ID + "=?",
//                new String[]{String.valueOf(student.getId())});
//        db.close();
//    }
}


