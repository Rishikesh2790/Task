package com.example.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    RecyclerView recyclerView;
    private ArrayList<Dataa> allContacts;
    AdapterB adapterB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allContacts = new ArrayList<>();

        recyclerView = findViewById(R.id.programmingList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

       OpenHelperMethod openHelperMethod = new OpenHelperMethod(getApplicationContext());

        allContacts = openHelperMethod.listContacts();

        adapterB =new AdapterB(this,allContacts);

        recyclerView.setAdapter(adapterB);

        int sidepadding = getResources().getDimensionPixelOffset(R.dimen.sidepadding);
        int toppadding = getResources().getDimensionPixelOffset(R.dimen.toppadding);

        recyclerView.addItemDecoration(new RecyclerDecoration(sidepadding,toppadding));

        button = findViewById(R.id.addButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapterB.notifyDataSetChanged();
    }
}
