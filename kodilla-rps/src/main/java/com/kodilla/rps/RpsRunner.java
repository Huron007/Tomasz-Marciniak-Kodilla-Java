package com.kodilla.rps;


import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {

        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        gameController.welcomeMessage();
        String userName = scanner.nextLine();
        gameController.setUserName(userName);
        String playAgain;
        do {
            playAgain = "";
            gameController.gameSetup();
            int howManyWins = scanner.nextInt();
            gameController.setBestOfRounds(howManyWins);
            gameController.selectDifficulty();
            Score score = new Score();
            int userChoiceId;
            boolean userMoveSelectionComplete;
            int difficultyId = scanner.nextInt();
            boolean diffSelectionComplete = false;
            do {
                if (difficultyId != 1 && difficultyId != 2 && difficultyId != 3) {
                    System.out.println("This is not a valid number, please enter a number between 1 and 3: ");
                    difficultyId = scanner.nextInt();
                } else {
                    diffSelectionComplete = true;
                }
            }
            while(!diffSelectionComplete);
            GameDifficulty difficulty = GameDifficulty.valueOf(difficultyId);
            do {
                gameController.selectUserChoice();
                userChoiceId = scanner.nextInt();
                userMoveSelectionComplete = false;
                do {
                    if (userChoiceId < 1 || userChoiceId > 5) {
                        System.out.println("This is not a valid move, please enter a number between 1 and 5: ");
                        userChoiceId = scanner.nextInt();
                    } else {
                        userMoveSelectionComplete = true;
                    }
                }
                while (!userMoveSelectionComplete);
                GameOption userChoice = GameOption.valueOf(userChoiceId);
                GameOption machineChoice = gameController.machineChoice(userChoice, difficulty);
                Player winnerOfRound = gameController.calculateResults(userChoice, machineChoice);
                gameController.updateScore(winnerOfRound);
                score = gameController.getScore();
                gameController.currentScore();
            }
            while (score.getUserScore() < score.getBestOfNumber() && score.getMachineScore() < score.getBestOfNumber());
            gameController.endResults(score);
            score.resetScore();
            gameController.playAgain();
            playAgain = scanner.nextLine();
            boolean validAnswer = false;
            do{
                if(!"Y".equals(playAgain.toUpperCase()) && !"N".equals(playAgain.toUpperCase())){
                    System.out.println("This is not a valid answer, please enter either Y for new game or N for exit:");
                    playAgain = scanner.nextLine();
                } else {
                    validAnswer = true;
                }
            }
            while(!validAnswer);
        }
        while("Y".equals(playAgain.toUpperCase()));
    }
}
