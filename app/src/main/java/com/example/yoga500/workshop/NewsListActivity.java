package com.example.yoga500.workshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class NewsListActivity extends AppCompatActivity {
    private ListView lvMenu;

    static String[]NameTopic = {"Topic New",
            "Topic New1",
            "Topic New2",
            "Topic New3",
            "Topic New4",
            "Topic New5",};
    static String[] DateName = {
            "31 ตุลาคม 2559",
            "31 ตุลาคม 2559",
            "31 ตุลาคม 2559",
            "31 ตุลาคม 2559",
            "31 ตุลาคม 2559",
            "31 ตุลาคม 2559"};
    int[] resId={R.drawable.and,
            R.drawable.and,
            R.drawable.and,
            R.drawable.and,
            R.drawable.and,
            R.drawable.and,
            R.drawable.and,};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        lvMenu = (ListView) findViewById(R.id.lvMenu);

        setEvent();
        cusAdapter();
    }

    private void setEvent() {
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(NewsListActivity.this,NewsDetailActivity.class);
                i.putExtra("vocabId", (int) id );
                startActivity(i);
            }
        });
    }

    private void cusAdapter() {
        lvMenu = (ListView) findViewById(R.id.lvMenu);
        lvMenu.setAdapter(new CustomAdapter(getApplicationContext(),NameTopic,resId,DateName));
    }
}