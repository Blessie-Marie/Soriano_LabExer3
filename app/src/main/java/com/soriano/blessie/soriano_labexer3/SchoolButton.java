package com.soriano.blessie.soriano_labexer3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SchoolButton extends AppCompatActivity {

   // EditText button1, button2, button3,button4,button5,button6,button7,button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_button);

        FileInputStream reader = null;
        String msg = "";

        try {
            int token;
            StringBuffer sb = new StringBuffer();
            reader = openFileInput("data1.txt");
            while((token = reader.read()) != -1){
                msg = msg + (char)token;
            }
            reader.close();
            try {
                String list[] = msg.split(",");
                ((Button) (findViewById(R.id.b1))).setText(list[0]);
                ((Button) (findViewById(R.id.b2))).setText(list[1]);
                ((Button) (findViewById(R.id.b3))).setText(list[2]);
                ((Button) (findViewById(R.id.b4))).setText(list[3]);
                ((Button) (findViewById(R.id.b5))).setText(list[4]);
                ((Button) (findViewById(R.id.b6))).setText(list[5]);
                ((Button) (findViewById(R.id.b7))).setText(list[6]);
                ((Button) (findViewById(R.id.b8))).setText(list[7]);
            } catch(Exception e) {

            }
        } catch (FileNotFoundException e) {
            Log.d("Error", "File not found...");
        } catch (IOException e) {
            Log.d("Error", "IO Error.");
        }
    }

    public void goBack(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}