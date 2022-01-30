package com.kodilla.rps;

public class Score {
    private int userScore = 0;
    private int machineScore = 0;
    private int bestOfNumber = 0;
    private int totalNumberOfRounds = 0;

    public void increaseRounds(){
        totalNumberOfRounds++;
    }

    public void userWon(){
        userScore++;
    }

    public void machineWon(){
        machineScore++;
    }

    public void resetScore(){
        this.userScore = 0;
        this.machineScore = 0;
        this.totalNumberOfRounds = 0;
    }

    public int getUserScore() {
        return userScore;
    }

    public int getMachineScore() {
        return machineScore;
    }

    public int getBestOfNumber() {
        return bestOfNumber;
    }

    public int getTotalNumberOfRounds() {
        return totalNumberOfRounds;
    }

    public void setBestOfNumber(int bestOfNumber) {
        this.bestOfNumber = bestOfNumber;
    }
}
