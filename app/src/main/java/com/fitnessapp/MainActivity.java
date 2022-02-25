package com.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fitnessapp.Models.Workouts;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    final Calendar calendar = Calendar.getInstance();
    private ProgressBar progressBar;

    private int year = calendar.get(Calendar.YEAR);
    private int month = calendar.get(Calendar.MONTH);
    private int day = calendar.get(Calendar.DAY_OF_MONTH);

    private String userId, dayOfWeek, monthIn3s, startedDate;
    private Button startBtn;
    private RelativeLayout emptyLayout;
    private LinearLayout timerLayout;
    private TextView dayOfWeekTxt,dateText,monthTxt;
    private ImageButton startTimerBtn, pauseTimerBtn;
    private ImageView mainImage;
    private SharedPreferences sp;

    private ArrayList<Workouts> workouts;
    private ListView workoutList;
    private ListView workoutListWithTime;


    private long pauseOffset;
    private boolean running;

    private DatabaseReference reference;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        reference = database.getReference("Workouts");
        userId =  FirebaseAuth.getInstance().getCurrentUser().getUid();

        sp = getApplicationContext().getSharedPreferences("UserPref", Context.MODE_PRIVATE);
        startedDate = sp.getString("startedDate", "");


        progressBar = findViewById(R.id.progress_bar);
        startBtn = findViewById(R.id.start_btn);
        emptyLayout = findViewById(R.id.empty_work_layout);
        timerLayout = findViewById(R.id.timer_layout);
        dayOfWeekTxt = findViewById(R.id.day_text_main);
        dateText = findViewById(R.id.date_text_main);
        monthTxt = findViewById(R.id.month_text_main);
        workoutList = findViewById(R.id.main_workout_list);
        workoutListWithTime = findViewById(R.id.main_workout_list_timer);
        startTimerBtn = findViewById(R.id.start_timer_btn);
        pauseTimerBtn = findViewById(R.id.pause_timer_btn);
        mainImage = findViewById(R.id.main_image);

        progressBar.setVisibility(View.VISIBLE);

        Date date = calendar.getTime();
        dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
        monthIn3s = new SimpleDateFormat("MMM", Locale.ENGLISH).format(date.getTime());

        dayOfWeekTxt.setText(dayOfWeek);
        monthTxt.setText(monthIn3s);
        dateText.setText(String.valueOf(day));

//        reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {

//            public void onCancelled(DatabaseError error) {
//                Toast.makeText(MainActivity.this, "" + error.getMessage(), Toast.LENGTH_LONG).show();
//                progressBar.setVisibility(View.GONE);
//            }
//        });
    }








}