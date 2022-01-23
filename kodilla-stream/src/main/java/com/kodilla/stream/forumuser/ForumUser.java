package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private final String id;
    private final String username;
    private final char gender;
    private final LocalDate birthDate;
    private final int posts;

    public ForumUser(String id, String username, char gender, LocalDate birthDate, int posts) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.birthDate = birthDate;
        this.posts = posts;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", gender=" + gender +
               ", birthDate=" + birthDate +
               ", posts=" + posts +
               '}';
    }
}
