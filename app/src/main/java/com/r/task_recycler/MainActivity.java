package com.r.task_recycler;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnshow;
    LinearLayout linearLayout;
    private RecyclerView.Adapter adapter;
    private List<Student> students;
    RecyclerView recyclerView;
    private Animation animShow, animHide;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnshow = findViewById(R.id.button1);
        linearLayout = findViewById(R.id.linear);

        btnshow.setOnClickListener(this);

        animShow = AnimationUtils.loadAnimation(this, R.anim.view_show);
        animHide = AnimationUtils.loadAnimation(this, R.anim.view_hide);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        students = new ArrayList<>();

        adapter = new StudentAdapter(students);
        recyclerView.setAdapter(adapter);

        linearLayout.setOnTouchListener(new OnSwipeTouchListener(this)
        {
            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                recyclerView.startAnimation(animHide);
                recyclerView.setVisibility(View.GONE);
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();

                recyclerView.setVisibility(View.VISIBLE);
                recyclerView.startAnimation(animShow);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                for (int i = 0; i < 100; i++) {
                    Student student = new Student("Roll_" + (i + 1), "Michael");
                    students.add(student);
                }

                adapter.notifyDataSetChanged();
                break;
        }

    }

}


