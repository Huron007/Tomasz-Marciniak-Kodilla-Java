import lombok.Getter;

import java.util.Scanner;

@Getter
public class SudokuGame {

    public static int EMPTY = -1;
    public static int MIN_VALUE = 1;
    public static int MAX_VALUE = 9;
    private boolean gameOver = false;
    private boolean sudokuCall = false;
    Scanner scanner = new Scanner(System.in);
    SudokuBoard gameBoard = new SudokuBoard();

    public void start(){
        System.out.println(
                "Welcome to Sudoku Solver\n" +
                "Insert a number by typing Row, Column, Number format. Example: 1, 3, 5 means inserting 5 into 1st row 3rd column.\n" +
                "Type SUDOKU once you would like to auto complete the rest of the board.\n" +
                "Press Enter to continue..."
        );
        try{
            System.in.read();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        setup();
        insertNumber();
    }

    public void setup(){
        gameBoard.fill();
        System.out.println(gameBoard);
    }

    public void insertNumber() {
        String userAnswer;
        while (!sudokuCall) {
            System.out.print("Please enter number you would like to insert in a proper format: ");
            userAnswer = scanner.nextLine();
            if(userAnswer.equals("SUDOKU")){
                gameBoard.completeBoard();
                System.out.println(gameBoard);
                sudokuCall = true;
                reset();
            } else {
                try {
                    String[] userAnswerArray = userAnswer.split(", ");
                    int r = Integer.parseInt(userAnswerArray[0]) - 1;
                    int c = Integer.parseInt(userAnswerArray[1]) - 1;
                    int number = Integer.parseInt(userAnswerArray[2]);
                    SudokuElementDto sudokuElementDto = new SudokuElementDto(r, c, number);
                    gameBoard.numberInserter(sudokuElementDto);
                } catch (NumberFormatException e) {
                    System.out.println("Wrong number format!");
                }
            }
            System.out.println(gameBoard);
        }
    }

    public void reset(){
        System.out.print("Would you like to play again (Y/N)? ");
        sudokuCall = false;
        String userAnswer;
        userAnswer = scanner.nextLine();
        if(!(userAnswer.toUpperCase().equals("Y") || userAnswer.toUpperCase().equals("N"))){
            System.out.println("Please enter either Y for yes or N for no.");
            reset();
        } else {
            if(userAnswer.toUpperCase().equals("Y")){
                start();
            } else {
                scanner.close();
                System.exit(0);
            }
        }
    }
}
