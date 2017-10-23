package com.example.epoxypagingsample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by pcqpcq on 17/10/18.
 */

@Database(entities = {User.class}, version = 1)
public abstract class UserDb extends RoomDatabase {

    abstract public UserDao userDao();
}

