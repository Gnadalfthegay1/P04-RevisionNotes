package com.myapplicationdev.android.p04_revisionnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etNote;
    Button btInsert, btShow;
    ArrayList<Note> N;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNote = findViewById(R.id.editTextNote);
        btInsert = findViewById(R.id.buttonInsertNote);
        btShow = findViewById(R.id.buttonShowList);

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroupStars);
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId = rg.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);

                String note = etNote.getText().toString();
                int stars = Integer.parseInt(rb.getText().toString());

                DBHelper db = new DBHelper(MainActivity.this);
                // Insert a task
                db.insertNote(note, stars);
                db.close();
                Toast.makeText(MainActivity.this, "Inserted",
                        Toast.LENGTH_LONG).show();
                etNote.setText("");

            }
        });
        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
