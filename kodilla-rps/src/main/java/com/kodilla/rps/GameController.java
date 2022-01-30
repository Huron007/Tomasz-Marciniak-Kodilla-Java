package com.kodilla.rps;

import java.lang.ref.Cleaner;
import java.util.Random;

public class GameController {

    private GameOption userChoice = GameOption.EMPTY;
    private GameOption machineChoice = GameOption.EMPTY;
    private Score totalScore = new Score();
    private String userName;
    private boolean newGame;

    public void welcomeMessage(){
        System.out.println(
                "          Welcome to Rock Paper Scissors Advanced!\n"+
                "Please enter your name: ");
    }

    public void gameSetup(){
        System.out.println("Please enter how many won rounds will determine a victor: ");
    }

    public void setBestOfRounds(int desiredRounds){
        totalScore.setBestOfNumber(desiredRounds);
    }

    public void selectDifficulty(){
        System.out.println("Game difficulty selection\n" +
                           "1) EASY\n" +
                           "2) MEDIUM\n" +
                           "3) HARD\n" +
                           "Please enter the number to select the difficulty you wish to play: ");
    }

    public void selectUserChoice(){
        System.out.println("Possible moves:\n" +
                           "1) ROCK\n" +
                           "2) PAPER\n" +
                           "3) SCISSORS\n" +
                           "4) LIZARD\n" +
                           "5) SPOCK\n" +
                           "Please select your move: ");
    }

    public void playAgain(){
        System.out.println("Would you like to play again? Press (Y/N): ");
    }

    public void endResults(Score score){
        if(score.getUserScore() == score.getBestOfNumber()){
            System.out.printf("%s have won the game!\n" +
                               "Game ended after %s rounds\n" +
                               "Ending score is: %s : %s\n", userName, score.getTotalNumberOfRounds(), score.getUserScore(), score.getMachineScore());
        } else if(score.getMachineScore() == score.getBestOfNumber()){
            System.out.printf("Machine has won the game!\n" +
                              "Game ended after %s rounds\n" +
                              "Ending score is: %s : %s\n", score.getTotalNumberOfRounds(), score.getUserScore(), score.getMachineScore());
        }
    }

    public GameOption machineChoice(GameOption userOption, GameDifficulty difficulty) {
        GameOption machineOption;
        this.userChoice = userOption;
        int randomNumberBetween1and10 = new Random().nextInt(10) + 1;
        int[] userGetsBeatenByTheseOptions = userChoice.getGetsBeatenBy();
        int[] userWinsByTheseOptions = userChoice.getBeats();
        int randomNumberBetween0and1 = new Random().nextInt(2);
        switch (difficulty) {
            case EASY:
                int randomNumberBetween1and5 = new Random().nextInt(5) + 1;
                machineOption = GameOption.valueOf(randomNumberBetween1and5);
                this.machineChoice = machineOption;
                return machineOption;
            case MEDIUM:
                if (randomNumberBetween1and10 > 6) {
                    if (randomNumberBetween0and1 == 0) {
                        machineOption = GameOption.valueOf(userGetsBeatenByTheseOptions[0]);
                    } else {
                        machineOption = GameOption.valueOf(userGetsBeatenByTheseOptions[1]);
                    }
                } else if (randomNumberBetween1and10 < 7 && randomNumberBetween1and10 > 3) {
                    machineOption = GameOption.valueOf(userChoice.getId());
                } else {
                    if (randomNumberBetween0and1 == 0) {
                        machineOption = GameOption.valueOf(userWinsByTheseOptions[0]);
                    } else {
                        machineOption = GameOption.valueOf(userWinsByTheseOptions[1]);
                    }
                }
                this.machineChoice = machineOption;
                return machineOption;
            case HARD:
                if (randomNumberBetween1and10 > 4) {
                    if (randomNumberBetween0and1 == 0) {
                        machineOption = GameOption.valueOf(userGetsBeatenByTheseOptions[0]);
                    } else {
                        machineOption = GameOption.valueOf(userGetsBeatenByTheseOptions[1]);
                    }
                } else if (randomNumberBetween1and10 < 5 && randomNumberBetween1and10 > 2) {
                    machineOption = GameOption.valueOf(userChoice.getId());
                } else {
                    if (randomNumberBetween0and1 == 0) {
                        machineOption = GameOption.valueOf(userWinsByTheseOptions[0]);
                    } else {
                        machineOption = GameOption.valueOf(userWinsByTheseOptions[1]);
                    }
                }
                this.machineChoice = machineOption;
                return machineOption;
        }
        return null;
    }

    public Player calculateResults(GameOption userChoice, GameOption machineChoice){
        int userChoiceId = userChoice.getId();
        int machineChoiceId = machineChoice.getId();
        int[] listOfUserWinConditions = machineChoice.getGetsBeatenBy();
        if(userChoiceId == machineChoiceId){
            System.out.flush();
            System.out.printf("You have selected %s and machine has selected %s, this round is a tie!\n", userChoice.name(), machineChoice.name());
            return Player.TIE;
        } else if (listOfUserWinConditions[0] == userChoiceId || listOfUserWinConditions[1] == userChoiceId){
            System.out.flush();
            System.out.printf("You have selected %s and machine has selected %s, You have won this round!\n", userChoice.name(), machineChoice.name());
            return Player.USER;
        } else {
            System.out.flush();
            System.out.printf("You have selected %s and machine has selected %s, You have lost this round!\n", userChoice.name(), machineChoice.name());
            return Player.MACHINE;
        }
    }

    public void currentScore() {
        System.out.printf("This is round #%s. The score is %s : %s\n", totalScore.getTotalNumberOfRounds(), totalScore.getUserScore(), totalScore.getMachineScore());
    }

    public void updateScore(Player player){
        if (player == Player.TIE){
            totalScore.increaseRounds();
        }
        if (player == Player.USER){
            totalScore.increaseRounds();
            totalScore.userWon();
        }
        if (player == Player.MACHINE){
            totalScore.increaseRounds();
            totalScore.machineWon();
        }
    }

    Score getScore(){
        return totalScore;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void userChoice(GameOption option){
        this.userChoice = option;
    }
}
