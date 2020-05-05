package com.example.lub_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNote extends AppCompatActivity {
    DbHelper db = new DbHelper(this);
    EditText editName, editDate;
    Button addNote;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateString = format.format( new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        editName = (EditText)findViewById(R.id.editTextName);
        addNote = (Button)findViewById(R.id.AddButton);
        addData();
    }

    public void addData() {
        addNote.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.addStudent(new Student(editName.getText().toString(), dateString.toString()));
                        finish();
                    }
                }
        );
    }
}
