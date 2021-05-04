package com.kmtstudio.insertingdataintosqlitedatabase5;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameTxt, ageTxt, genderTxt;
    private Button addBtn;

    MDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dbHelper = new MDbHelper(this);
        SQLiteDatabase liteDatabase = dbHelper.getWritableDatabase();


        nameTxt = findViewById(R.id.nameTxtID);
        ageTxt = findViewById(R.id.ageTxtID);
        genderTxt = findViewById(R.id.genderTxtID);

        addBtn = findViewById(R.id.addBtnID);


        addBtn.setOnClickListener(v -> {

            String name = nameTxt.getText().toString();
            String age = ageTxt.getText().toString();
            String gender = genderTxt.getText().toString();

            if (v.getId() == R.id.addBtnID) {

                long rowID = dbHelper.insertData(name, age, gender);

                if (rowID == -1) {

                    Toast.makeText(getApplicationContext(), "Row data insert not successful", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(getApplicationContext(), "Row " + rowID + " data insert successful", Toast.LENGTH_LONG).show();
                }
            }

        });

    }
}