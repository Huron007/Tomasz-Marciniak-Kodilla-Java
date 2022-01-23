package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {

    public static void main(String[] args) {

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
        });

    }
}