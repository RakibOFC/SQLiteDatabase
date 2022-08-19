package com.rakibofc.sqlitedatabase;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText ename, ecollege, eroll;
    Button binsert, bexit, bdisplay;
    String nam, coll, roll;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ename = findViewById(R.id.ename);
        ecollege = findViewById(R.id.ecollege);
        eroll = findViewById(R.id.eroll);
        binsert = findViewById(R.id.binsert);
        bdisplay = findViewById(R.id.bdisplay);
        bexit = findViewById(R.id.bexit);

        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(name VARCHAR, college VARCHAR, roll VARCHAR); ");

        binsert.setOnClickListener(v -> {
            nam = ename.getText().toString();
            coll = ecollege.getText().toString();
            roll = eroll.getText().toString();
            db.execSQL("INSERT INTO student VALUES('" + nam + "','" + coll + "','" + roll + "');");
            Toast.makeText(getApplicationContext(), "Row Inserted", Toast.LENGTH_SHORT).show();
        });

        bdisplay.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), PreviewActivity.class);
            startActivity(intent);
            finish();
        });

        bexit.setOnClickListener(v -> System.exit(0));
    }
}