package com.example.epoxypagingsample;

import com.airbnb.epoxy.paging.PagingEpoxyController;

import java.util.List;

public class UserListController extends PagingEpoxyController<User> {
        @Override
        protected void buildModels(List<User> list) {
            for (User user : list) {
                new PagingViewModel_()
                        .id(user.getUid())
                        .index("uid > " + user.getUid())
                        .addTo(this);
            }
        }

    }