package com.example.myapp5;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
//    private String[] namesArr = new String[]{"Max", "Nick", "John", "Tom", "Alex"};
    public static List<String> contactNames = new ArrayList<>();


    private ListView listView;
    private GestureDetector gd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

//        contactNames.addAll(Arrays.asList("Max", "Nick", "John", "Tom", "Alex"));

        listView = findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.item_samsung, R.id.user_name ,contactNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ContactActivity.this, (String)listView.getItemAtPosition(position), Toast.LENGTH_LONG).show();
            }
        });
        gd = new GestureDetector(this, this);
        gd.setIsLongpressEnabled(true);
    }

    public boolean onTouchEvent(MotionEvent event) {
        gd.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public void goMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goWeb(View view) {
        Intent intent = new Intent(this, WebActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

}