package com.whl.handytabbar.sample;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {


    private ListView mListView;
    private CheckBox drawIndicator;
    private CheckBox drawUnderLine;
    private CheckBox drawDivider;

    private String[] layoutItems={"Default","Simple","Custom"};

    private boolean isTop=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        initViews();
    }

    private void initToolbar(){
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("HandyTabBar Sample");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
    }

    private void initViews() {
        drawIndicator= (CheckBox) findViewById(R.id.drawIndicator);
        drawUnderLine= (CheckBox) findViewById(R.id.drawUnderLine);
        drawDivider= (CheckBox) findViewById(R.id.drawDivider);
        mListView= (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,layoutItems);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,SampleActivity.class);
                intent.putExtra("top",isTop);
                intent.putExtra("drawIndicator",drawIndicator.isChecked());
                intent.putExtra("drawUnderLine",drawUnderLine.isChecked());
                intent.putExtra("drawDivider",drawDivider.isChecked());
                intent.putExtra("type",position);
                intent.putExtra("title",layoutItems[position]);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.top) {
            isTop=true;
            return true;
        }else if (id==R.id.bottom){
            isTop=false;
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
