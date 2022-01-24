package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.kodilla.stream.forumuser.Forum.TWENTY_YEARS_IN_DAYS;


public class StreamMain {

    public static void main(String[] args) {

       /*   ZADANIE 7.1
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("sample text", (string) -> "ABC "+string+" ABC");
        poemBeautifier.beautify("sample text", (string) -> string.toUpperCase());
        poemBeautifier.beautify("sample text", (string) -> String.format("%h", string));
        poemBeautifier.beautify("sample text", (string) -> {
            String result = "";
            char [] ch = string.toCharArray();
            for(int i = string.length()-1; i >= 0; i--){
                result += ch[i];
            }
            return result;
        });  */

        List<ForumUser> forumUserList = new ArrayList<>();
        Forum forum = new Forum(forumUserList);
        forum.createUserList();

        Map<String, ForumUser> par = forum.getForumUserList().stream()
                .filter(forumUser -> forumUser.getGender() == 'M')
                .filter(forumUser -> LocalDate.now().toEpochDay() - forumUser.getBirthDate().toEpochDay() > TWENTY_YEARS_IN_DAYS)
                .filter(forumUser -> forumUser.getPosts() > 1)
                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));

        par.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}