package com.example.epoxypagingsample;

import android.arch.lifecycle.Observer;
import android.arch.paging.PagedList;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private UserDb db;
    RecyclerView recyclerView;
    UserListController userListController;
    // normal way
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(), UserDb.class, "user").build();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);

        userListController = new UserListController();
        userListController.setNumPagesToLoad(2);
        userListController.setPageSizeHint(50);
        recyclerView.setAdapter(userListController.getAdapter());

        // normal way
//        userAdapter = new UserAdapter();
//        recyclerView.setAdapter(userAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // use thread directly, just for TEST.
                new Thread() {
                    @Override
                    public void run() {
                        long seed = System.currentTimeMillis();

                        for (int i = 0; i < 50; i++) {
                            db.userDao().insertAll(new User(seed++));
                        }
                    }
                }.start();
            }
        });

        db.userDao()
                .all()
                .create(0, new PagedList.Config.Builder()
                .setPageSize(100)
                .setEnablePlaceholders(false)
                .setPrefetchDistance(50)
                .build())
                .observe(this, new Observer<PagedList<User>>() {
            @Override
            public void onChanged(@Nullable PagedList<User> users) {
                userListController.setList(users);
                // normal way
//                userAdapter.setList(users);
            }
        });

    }

}
