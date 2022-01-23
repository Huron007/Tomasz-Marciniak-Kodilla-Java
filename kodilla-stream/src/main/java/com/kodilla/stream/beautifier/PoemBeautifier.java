package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String string, PoemDecorator poemDecorator){
        String result = poemDecorator.decorate(string);
        System.out.println(result);
    }
}
