package com.example.mydocapp;

import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.view.View;

public class UserDetails extends AppCompatActivity {

    RecyclerView usersrecyclerview;
    UserDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdatarecyclerview);
        Singleton.getInstance().setContext(UserDetails.this);
        usersrecyclerview = findViewById(R.id.doctorRecyclerView);

        setTitle("Admin Page");

        adapter = new UserDataAdapter();
        usersrecyclerview.setAdapter(adapter);
        usersrecyclerview.setLayoutManager(
                new LinearLayoutManager(UserDetails.this)
        );
        usersrecyclerview.addItemDecoration(
                new DividerItemDecoration(UserDetails.this,
                        DividerItemDecoration.VERTICAL)
        );

        adapter.setClickListener(new UserDataAdapter.ClickListener() {
            @Override
            public void onItemLongClick(int position, View view) {
                Singleton.getInstance().getUsers().remove(position);
                adapter.notifyItemRemoved(position);
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.notifyItemInserted(
                Singleton.getInstance().getUsers().size()-1);

    }
}
