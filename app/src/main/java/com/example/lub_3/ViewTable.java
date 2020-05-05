package com.example.lub_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ViewTable extends AppCompatActivity {
    TextView textView;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateString = format.format( new Date());
    String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtable);

        textView = (TextView) findViewById(R.id.textView);
        TextView textview= (TextView) findViewById(R.id.textView);
        textview.setMovementMethod(new ScrollingMovementMethod());

        DbHelper db = new DbHelper(this);

        List<Student> contacts = db.getAllContacts();

        for (Student c : contacts) {
            String log = "ID: " + c.getId() +
                    "\nName: " + c.getName() +
                    "\nLName: " + c.getLName() +
                    "\nOName: " + c.getOName() +
                    "\nDATE: " + c.getDate() +
                    "\n///////////////////////////////////////////////////////////////////\n";
            text = text + log;
            System.out.println(c.getName() + c.getLName() + c.getOName());
        }

        textView.setText(text);
    }
}
