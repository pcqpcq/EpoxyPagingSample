package com.example.epoxypagingsample;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserAdapter extends PagedListAdapter<User, UserAdapter.UserViewHolder> {

    public UserAdapter() {
        super(DIFF_CALLBACK);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false));
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bindTo(position);
    }

    static final DiffCallback<User> DIFF_CALLBACK = new DiffCallback<User>() {
        @Override
        public boolean areItemsTheSame(@NonNull User oldUser, @NonNull User newUser) {
            // User properties may have changed if reloaded from the DB, but ID is fixed
            return oldUser.getUid() == newUser.getUid();
        }

        @Override
        public boolean areContentsTheSame(@NonNull User oldUser, @NonNull User newUser) {
            // NOTE: if you use equals, your object must properly override Object#equals()
            // Incorrectly returning false here will result in too many animations.
            return oldUser.getFirstName().equals(newUser.getFirstName());
        }
    };

    static class UserViewHolder extends RecyclerView.ViewHolder {

        TextView index;

        public UserViewHolder(View view) {
            super(view);
            index = view.findViewById(R.id.user_index);
        }

        public void bindTo(int position) {
            index.setText("index > " + position);
        }

    }

}