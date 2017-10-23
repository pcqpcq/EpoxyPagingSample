package com.example.epoxypagingsample;

import android.arch.paging.LivePagedListProvider;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

/**
 * Created by pcqpcq on 17/10/18.
 */

@Dao
public abstract class UserDao {

    @Query("SELECT * FROM user")
    public abstract LivePagedListProvider<Integer, User> all();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertAll(User... users);
}
