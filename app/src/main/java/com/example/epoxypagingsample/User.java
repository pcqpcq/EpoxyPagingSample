package com.example.epoxypagingsample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by pcqpcq on 17/10/18.
 */

@Entity
public class User {

    @PrimaryKey
    long uid;

    @ColumnInfo(name = "first_name")
    String firstName = "first index";

    @ColumnInfo(name = "last_name")
    String lastName= "last index";

    public User(long uid) {
        this.uid = uid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
