package com.example.myapp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText user_name_field, user_bio_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_name_field = findViewById(R.id.user_name_field);
        user_bio_field = findViewById(R.id.user_bio_field);
    }

    public void saveData(View view) {
        String userName = user_name_field.getText().toString();
        ContactActivity.contactNames.add(userName);

        String userBio = user_bio_field.getText().toString();
        ContactActivity.contactBio.add(userBio);

        try {
            FileOutputStream fileOutputStream = openFileOutput("user_data.txt", MODE_PRIVATE);
            fileOutputStream.write((userName + " " + userBio).getBytes());
            fileOutputStream.close();

            user_name_field.setText("");
            user_bio_field.setText("");

            Toast.makeText(this, "Текст сохранен", Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            Toast.makeText(this, "Не удается обработать текст", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getData(View view) {
        try {
            FileInputStream fileInputStream = openFileInput("user_data.txt");
            InputStreamReader reader = new InputStreamReader(fileInputStream);
            BufferedReader f = new BufferedReader(reader);

            String lines;
            StringBuilder result = new StringBuilder();

            while ((lines = f.readLine()) != null) {
                result.append(lines).append("\n");
            }

            Toast.makeText(this, result, Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goContacts(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }

    public void goWeb(View view) {
        Intent intent = new Intent(this, WebActivity.class);
        startActivity(intent);
    }

}