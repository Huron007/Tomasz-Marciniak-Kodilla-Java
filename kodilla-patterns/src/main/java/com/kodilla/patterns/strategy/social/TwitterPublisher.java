package com.kodilla.patterns.strategy.social;

public class TwitterPublisher implements SocialPublisher{

    @Override
    public String share(){
        return "Sharing something on twitter...";
    }
}
