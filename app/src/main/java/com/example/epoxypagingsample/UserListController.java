package com.example.epoxypagingsample;

import java.util.List;

public class UserListController extends PagingEpoxyController<User> {
        @Override
        protected void buildModels(List<User> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                User user = list.get(i);
                new PagingViewModel_()
                        .id(user.getUid())
                        .index("index > " + i)
                        .addTo(this);
            }
        }

    }