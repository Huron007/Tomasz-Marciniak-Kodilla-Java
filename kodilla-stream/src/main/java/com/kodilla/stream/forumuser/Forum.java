package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    public static final int TWENTY_YEARS_IN_DAYS = 7300;
    private List<ForumUser> forumUserList = new ArrayList<>();

    public Forum(List<ForumUser> forumUserList) {
        this.forumUserList = forumUserList;
    }

    public void createUserList(){
        for(int i = 0; i < 11; i++) {
            char a = 'M';
            if(i % 2 == 0){
                a = 'F';
            } else a = 'M';
            forumUserList.add(new ForumUser("000"+i, "User"+i, a, LocalDate.of(1995+i, 01+i,01+i), (i + 1) * 2));
        }
    }

    public List<ForumUser> getForumUserList(){
        return new ArrayList<>(forumUserList);
    }
}
