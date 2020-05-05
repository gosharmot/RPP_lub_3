package com.example.lub_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateString = format.format( new Date());
    DbHelper db = new DbHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

        db.delete();
        db.addStudent(new Student("Osadchuk Georgii Miroslavovich", dateString.toString()));
        db.addStudent(new Student("Gorelkin Alexander Sergeevich", dateString.toString()));
        db.addStudent(new Student("Nefedov Andrey Andreevich", dateString.toString()));
        db.addStudent(new Student("Reznikov Pavel Sergeevich", dateString.toString()));
        db.addStudent(new Student("Krasnov Sergeyi Alexandrovich", dateString.toString()));
    }

    private void addListenerOnButton() {
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewTable.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNote.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = db.getStudentCount();
                db.updateStudent(new Student((int) id, "Ivanov Ivan Ivanovich", dateString.toString()));
            }
        });
    }
}
