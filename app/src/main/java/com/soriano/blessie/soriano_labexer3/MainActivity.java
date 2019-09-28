package com.soriano.blessie.soriano_labexer3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3, et4, et5, et6, et7, et8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.u1);
        et2 = findViewById(R.id.u2);
        et3 = findViewById(R.id.u3);
        et4 = findViewById(R.id.u4);
        et5 = findViewById(R.id.u5);
        et6 = findViewById(R.id.u6);
        et7 = findViewById(R.id.u7);
        et8 = findViewById(R.id.u8);
    }

    public void saveData(View v){
        String school1 = et1.getText().toString() + ",";
        String school2 = et2.getText().toString() + ",";
        String school3 = et3.getText().toString() + ",";
        String school4 = et4.getText().toString() + ",";
        String school5 = et5.getText().toString() + ",";
        String school6 = et6.getText().toString() + ",";
        String school7 = et7.getText().toString() + ",";
        String school8 = et8.getText().toString() + ",";
        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer.write(school1.getBytes());
            writer.write(school2.getBytes());
            writer.write(school3.getBytes());
            writer.write(school4.getBytes());
            writer.write(school5.getBytes());
            writer.write(school6.getBytes());
            writer.write(school7.getBytes());
            writer.write(school8.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("error", "File not found...");
            //   e.printStackTrace();
        } catch (IOException e) {
            //   e.printStackTrace();
            Log.d("error", "IO error");
        }finally{
            try {
                writer.close();
            } catch (IOException e) {
                //  e.printStackTrace();
                Log.d("error", "File not found...");
            }
        }
        Toast.makeText(this, "Data saved in internal storage..", Toast.LENGTH_LONG).show();
    }


    public void next(View v){
        Intent i = new Intent(this, SchoolButton.class);
        startActivity(i);
    }
}
