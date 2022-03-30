package com.kodilla.patterns.strategy.social;

public class FacebookPublisher implements SocialPublisher{

    @Override
    public String share(){
        return "Sharing something on facebook...";
    }
}
