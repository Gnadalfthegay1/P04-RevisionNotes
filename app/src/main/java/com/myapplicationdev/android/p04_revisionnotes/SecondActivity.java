package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
	ListView lv;
	ArrayList<Note> N;
	ArrayAdapter aa;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TODO implement the Custom ListView
		setContentView(R.layout.activity_second);
		lv = findViewById(R.id.lv);
		DBHelper db = new DBHelper(SecondActivity.this);
		N = db.getAllNotes();
		aa = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, N);
		lv.setAdapter(aa);
	}


}
