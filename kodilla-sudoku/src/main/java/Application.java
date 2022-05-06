public class Application {

    public static void main(String[] args) {
        SudokuGame sudokuGame = new SudokuGame();
        while(!sudokuGame.isGameOver()){
            sudokuGame.start();
        }
    }
}
