package com.kodilla.testing.forum.statistics.stub;

import com.kodilla.testing.forum.statistics.Statistics;

import java.util.ArrayList;
import java.util.List;

public class StatisticsStub implements Statistics {

    @Override
    public List<String> usersNames() {
        List<String> stubResult = new ArrayList<>();

        stubResult.add("User1");

        return stubResult;
    }

    @Override
    public int postsCount() {
        return 0;
    }

    @Override
    public int commentsCount() {
        return 0;
    }
}
