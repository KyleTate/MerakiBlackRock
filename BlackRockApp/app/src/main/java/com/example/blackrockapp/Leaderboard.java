package com.example.blackrockapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.util.ArrayList;

public class Leaderboard extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private SlidrInterface slidr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);




        ArrayList<String> dummyNames = new ArrayList<>();

        ArrayList<ExampleItem> leaderboardList = new ArrayList<>();
        dummyNames.add("JORDANVINCENT");
        dummyNames.add("JOSECANTILLO");
        dummyNames.add("ETHANKIM");
        dummyNames.add("KYLETATE");
        dummyNames.add("CENGUIZGUNAY");
        dummyNames.add("DRANCA");
        dummyNames.add("LEBRONJAMES");
        dummyNames.add("MONTYPYTHON");
        dummyNames.add("HARAMBE");
        dummyNames.add("TACKSOOIM");




        ArrayList<String> dummyReturns = new ArrayList<>();
        dummyReturns.add("+$1,000");
        dummyReturns.add("+$800");
        dummyReturns.add("+$600");
        dummyReturns.add("+$300");
        dummyReturns.add("+$200");
        dummyReturns.add("+$100");
        dummyReturns.add("+$100");
        dummyReturns.add("+$100");
        dummyReturns.add("+$60");
        dummyReturns.add("+$50");




        ArrayList<String> dummyPercentReturns = new ArrayList<>();
        dummyPercentReturns.add("(100%)");
        dummyPercentReturns.add("(80%)");
        dummyPercentReturns.add("(60%)");
        dummyPercentReturns.add("(30%)");
        dummyPercentReturns.add("(20%)");
        dummyPercentReturns.add("(10%)");
        dummyPercentReturns.add("(10%)");
        dummyPercentReturns.add("(10%)");
        dummyPercentReturns.add("(6%)");
        dummyPercentReturns.add("(5%)");




        for (int i = 0; i < dummyNames.size(); i++) {
            leaderboardList.add(new ExampleItem(dummyNames.get(i), "Start: $1,000",dummyReturns.get(i),dummyPercentReturns.get(i)));
        }


        mRecyclerView = findViewById(R.id.recyclerView1);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(leaderboardList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);



       // Slidr.attach(this);




//            super.finish();
//            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }

    public void openActivity3(View view) {
        Intent intent = new Intent(this, Research.class);
        startActivity(intent);
    }
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
