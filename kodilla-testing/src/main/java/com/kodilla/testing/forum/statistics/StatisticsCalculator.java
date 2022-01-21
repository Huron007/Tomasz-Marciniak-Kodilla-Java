package com.kodilla.testing.forum.statistics;

import java.util.List;

public class StatisticsCalculator {

    private Statistics statistics;
    private double averagePostPerUser;
    private double averageCommentPerUser;
    private double averageCommentPerPost;
    private int posts;
    private int comments;
    private int usersCount;

    public StatisticsCalculator(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics){
        posts = statistics.postsCount();
        comments = statistics.commentsCount();
        usersCount = statistics.usersNames().size();
        if(usersCount != 0.0) {
            averagePostPerUser = (double) posts / (double) usersCount;
            averageCommentPerUser = (double) comments / (double) usersCount;
        } else {
            averagePostPerUser = 0.0;
            averageCommentPerUser = 0.0;
        }
        if(posts != 0.0) {
            averageCommentPerPost = (double) comments / (double) posts;
        } else {
            averageCommentPerPost = 0.0;
        }
    }

    void showStatistics(){
        System.out.println("Liczba użytkowników: " + usersCount + "\nLiczba postów: " + posts + "\nLiczba komentarzy: " + comments +
                           "\nŚrednia liczba postów na użytkownika: " + averagePostPerUser + "\nŚrednia liczba komentarzy na użytkownika "
                           + averageCommentPerUser + "\nŚrednia liczba komentarzy na post: " + averageCommentPerPost
        );
    }

    public double getAveragePostPerUser() {
        return averagePostPerUser;
    }

    public double getAverageCommentPerUser() {
        return averageCommentPerUser;
    }

    public double getAverageCommentPerPost() {
        return averageCommentPerPost;
    }

    public int getPosts() {
        return posts;
    }

    public int getComments() {
        return comments;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }
}
