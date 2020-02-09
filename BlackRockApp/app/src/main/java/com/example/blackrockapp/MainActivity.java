package com.example.blackrockapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.r0adkll.slidr.Slidr;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

import androidx.recyclerview.widget.LinearLayoutManager;


import static com.example.blackrockapp.R.anim.slide_in_right;
import static com.example.blackrockapp.R.anim.slide_out_left;

public class MainActivity extends AppCompatActivity {

//   float x1, x2, y1, y2;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




//        Toolbar tool_bar = findViewById(R.id.toolbar);
//        setActionBar(tool_bar);
//        tool_bar.setLogo(R.drawable.blackrocklogo);

        /// Jordan main activity code
        Portfolio myPortfolio = new Portfolio(10000);
        myPortfolio.purchaseStock("AAPL", 10);
        myPortfolio.purchaseStock("TSLA", 1);
        myPortfolio.purchaseStock("MGMT", 10);
        myPortfolio.purchaseStock("OGG", 10);
        myPortfolio.purchaseStock("OFWGKTA", 10);
        myPortfolio.purchaseStock("BRL", 10);
        myPortfolio.purchaseStock("BRIG", 10);
        myPortfolio.purchaseStock("FJK", 10);


        ArrayList<ExampleItem> exampleList = new ArrayList<>();

        ArrayList<Stock> myStocks = myPortfolio.getStocksOwned();
        for (Stock stock : myStocks) {
            exampleList.add(new ExampleItem(stock.getstockName(), stock.getQuantityOwned()+"", stock));
        }

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);






        // Slidr.attach(this);

        LineChartView lineChartView = findViewById(R.id.chart);
        lineChartView.setBackgroundColor(Color.argb(50, 96, 105, 117));

        String[] axisData = {"Mon", "Tue", "Wed", "Thur", "Fri"};

        int[] yAxisData = {500, 550, 675, 400, 450};

        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();
        Line line = new Line(yAxisValues);

        for(int i = 0; i < axisData.length; i++){
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++){
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }

        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);
        lineChartView.setLineChartData(data);

        Axis axis = new Axis();
        axis.setValues(axisValues);
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        data.setAxisYLeft(yAxis);

        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 1000;
//        lineChartView.setMaximumViewport(viewport);
       lineChartView.setCurrentViewport(viewport);

       // Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));



       Spinner spinner = findViewById(R.id.stocksDropdown);

        //dropdown
        ArrayAdapter<CharSequence> qual_adapter = ArrayAdapter.createFromResource(this, R.array.availableStocks,R.layout.spinner_text);

        qual_adapter.setDropDownViewResource(R.layout.dropdown);

        spinner.setAdapter(qual_adapter);


//
//        Toolbar myToolbar = findViewById(R.id.toolbar);
//        setActionBar(myToolbar);

    }





    //overflow menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.research:
                Intent intent = new Intent(this, Research.class);
        startActivity(intent);
                // Red item was selected
                return true;
            case R.id.leaderboard:
                Intent intent2 = new Intent(this, Leaderboard.class);
                startActivity(intent2);
                // Green item was selected
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }






//    public boolean onTouchEvent(MotionEvent touchEvent){
//        switch(touchEvent.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                x1 = touchEvent.getX();
//                y1 = touchEvent.getY();
//                break;
//            case MotionEvent.ACTION_UP:
//                x2 = touchEvent.getX();
//                y2 = touchEvent.getY();
//                if(x1 <  x2){
//                Intent i = new Intent(MainActivity.this, Leaderboard.class);
//                startActivity(i);
//            }else if(x1 >  x2){
//                Intent i = new Intent(MainActivity.this, Research.class);
//                startActivity(i);
//            }
//            break;
//        }
//        return false;
//    }

//    public void openLeaderboardActivity(View view) {
//        Intent intent = new Intent(this, Leaderboard.class);
//        startActivity(intent);
//        overridePendingTransition(slide_in_right, slide_out_left);
//    }
//
//    public void openResearchActivity(View view) {
//        Intent intent = new Intent(this, Research.class);
//        startActivity(intent);
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//    }
//
//    public void openActivity2(View view) {
//    }
}
