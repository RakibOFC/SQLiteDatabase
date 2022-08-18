package com.rakibofc.sqlitedatabase;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText ename, ecollege;
    Button binsert, bexit, bdisplay;
    String nam, coll;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ename = findViewById(R.id.ename);
        ecollege = findViewById(R.id.ecollege);
        binsert = findViewById(R.id.binsert);
        bdisplay = findViewById(R.id.bdisplay);
        bexit = findViewById(R.id.bexit);

        db = openOrCreateDatabase("Mydb", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(name VARCHAR,college VARCHAR); ");

        binsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nam = ename.getText().toString();
                coll = ecollege.getText().toString();
                db.execSQL("INSERT INTO student VALUES('" + nam + "’,’" + coll + "');");
                Toast.makeText(getApplicationContext(), "Row Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        bdisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PreviewActivity.class);

                startActivity(intent);
                finish();

            }
        });

        bexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}