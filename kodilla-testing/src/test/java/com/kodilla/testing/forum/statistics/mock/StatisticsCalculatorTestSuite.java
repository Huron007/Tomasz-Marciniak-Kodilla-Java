package com.kodilla.testing.forum.statistics.mock;

import com.kodilla.testing.forum.statistics.Statistics;
import com.kodilla.testing.forum.statistics.StatisticsCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsCalculatorTestSuite {

    @Mock
    private Statistics statisticsMock;

    @BeforeEach
    void initializingMock(){
        when(statisticsMock.postsCount()).thenReturn(getPostsCount(1));
        when(statisticsMock.commentsCount()).thenReturn(getCommentsCount(1));
        when(statisticsMock.usersNames()).thenReturn(getUserNames(1));
    }

    public static int getCommentsCount(int n) {
        return n;
    }

    public static int getPostsCount(int n) {
        return n;
    }

    public static List<String> getUserNames(int n) {
        List<String> userList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            userList.add("User0"+n);
        }
        return userList;
    }

    @Test
    void postCountZeroTestSuite(){
        //Given
        when(statisticsMock.postsCount()).thenReturn(getPostsCount(0));
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        double averagePostsPerUser = statisticsCalculator.getAveragePostPerUser();
        double averageCommentsPerUser = statisticsCalculator.getAverageCommentPerUser();
        double averageCommentsPerPost = statisticsCalculator.getAverageCommentPerPost();
        //Then
        Assertions.assertEquals(0.0, averagePostsPerUser, 0.1);
        Assertions.assertEquals(1.0, averageCommentsPerUser, 0.1);
        Assertions.assertEquals(0.0, averageCommentsPerPost, 0.1);
    }
    @Test
    void postCountThousandTestSuite(){
        //Given
        when(statisticsMock.postsCount()).thenReturn(getPostsCount(1000));
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        double averagePostsPerUser = statisticsCalculator.getAveragePostPerUser();
        double averageCommentsPerUser = statisticsCalculator.getAverageCommentPerUser();
        double averageCommentsPerPost = statisticsCalculator.getAverageCommentPerPost();
        //Then
        Assertions.assertEquals(1000.0, averagePostsPerUser, 0.1);
        Assertions.assertEquals(1.0, averageCommentsPerUser, 0.1);
        Assertions.assertEquals(0.001, averageCommentsPerPost, 0.1);
    }
    @Test
    void commentCountZeroTestSuite(){
        //Given
        when(statisticsMock.commentsCount()).thenReturn(getCommentsCount(0));
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        double averagePostsPerUser = statisticsCalculator.getAveragePostPerUser();
        double averageCommentsPerUser = statisticsCalculator.getAverageCommentPerUser();
        double averageCommentsPerPost = statisticsCalculator.getAverageCommentPerPost();
        //Then
        Assertions.assertEquals(1, averagePostsPerUser, 0.1);
        Assertions.assertEquals(0, averageCommentsPerUser, 0.1);
        Assertions.assertEquals(0, averageCommentsPerPost, 0.1);
    }
    @Test
    void commentCountLowerThanPostCountTestSuite(){
        //Given
        when(statisticsMock.postsCount()).thenReturn(getPostsCount(10));
        when(statisticsMock.commentsCount()).thenReturn(getCommentsCount(5));
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        double averagePostsPerUser = statisticsCalculator.getAveragePostPerUser();
        double averageCommentsPerUser = statisticsCalculator.getAverageCommentPerUser();
        double averageCommentsPerPost = statisticsCalculator.getAverageCommentPerPost();
        //Then
        Assertions.assertEquals(10, averagePostsPerUser, 0.1);
        Assertions.assertEquals(5, averageCommentsPerUser, 0.1);
        Assertions.assertEquals(0.5, averageCommentsPerPost, 0.1);
    }
    @Test
    void commentCountBiggerThanPostCountTestSuite(){
        //Given
        when(statisticsMock.postsCount()).thenReturn(getPostsCount(5));
        when(statisticsMock.commentsCount()).thenReturn(getCommentsCount(10));
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        double averagePostsPerUser = statisticsCalculator.getAveragePostPerUser();
        double averageCommentsPerUser = statisticsCalculator.getAverageCommentPerUser();
        double averageCommentsPerPost = statisticsCalculator.getAverageCommentPerPost();
        //Then
        Assertions.assertEquals(5, averagePostsPerUser, 0.1);
        Assertions.assertEquals(10, averageCommentsPerUser, 0.1);
        Assertions.assertEquals(2, averageCommentsPerPost, 0.1);
    }
    @Test
    void userCountZeroTestSuite(){
        //Given
        when(statisticsMock.usersNames()).thenReturn(getUserNames(0));
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        double averagePostsPerUser = statisticsCalculator.getAveragePostPerUser();
        double averageCommentsPerUser = statisticsCalculator.getAverageCommentPerUser();
        double averageCommentsPerPost = statisticsCalculator.getAverageCommentPerPost();
        //Then
        Assertions.assertEquals(0, averagePostsPerUser, 0.1);
        Assertions.assertEquals(0, averageCommentsPerUser, 0.1);
        Assertions.assertEquals(1, averageCommentsPerPost, 0.1);
    }
    @Test
    void userCountHundredTestSuite(){
        //Given
        when(statisticsMock.usersNames()).thenReturn(getUserNames(100));
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(statisticsMock);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);
        //When
        double averagePostsPerUser = statisticsCalculator.getAveragePostPerUser();
        double averageCommentsPerUser = statisticsCalculator.getAverageCommentPerUser();
        double averageCommentsPerPost = statisticsCalculator.getAverageCommentPerPost();
        //Then
        Assertions.assertEquals(0.01, averagePostsPerUser, 0.1);
        Assertions.assertEquals(0.01, averageCommentsPerUser, 0.1);
        Assertions.assertEquals(1, averageCommentsPerPost, 0.1);
    }
}
