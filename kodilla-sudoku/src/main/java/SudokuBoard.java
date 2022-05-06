import lombok.Getter;

@Getter
public class SudokuBoard {

    public static final int SIZE = 9;
    private final SudokuElement[][] board;

    public SudokuBoard() {
        board = new SudokuElement[SIZE][SIZE];
    }

    public void fill() {
        for (int i = 0; i < SIZE; i++) {
            for (int n = 0; n < SIZE; n++) {
                board[i][n] = new SudokuElement(i, n);
            }
        }
    }

    public void numberInserter(SudokuElementDto sudokuElementDto){
        if(!(sudokuElementDto.getValue() > SudokuGame.MAX_VALUE || sudokuElementDto.getRow() > SIZE - 1 || sudokuElementDto.getCol() > SIZE - 1
           || sudokuElementDto.getValue() < SudokuGame.MIN_VALUE || sudokuElementDto.getRow() < 0 || sudokuElementDto.getCol() < 0)){
            if(isNumberValid(sudokuElementDto)){
                board[sudokuElementDto.getRow()][sudokuElementDto.getCol()].setValue(sudokuElementDto.getValue());
                setPossibleValues(sudokuElementDto);
            } else {
                System.out.println("Number already exist either in row, column or box!");
            }
        } else {
            System.out.println("You can only enter numbers from 1 to 9 and you can't enter coordinates that exceeds board's size.");
        }
    }

    public boolean isNumberInRow(SudokuElementDto sudokuElementDto){
        for(int i = 0; i < SIZE; i++){
            if(board[sudokuElementDto.getRow()][i].getValue() == sudokuElementDto.getValue()){
                return true;
            }
        }
        return false;
    }

    public boolean isNumberInCol(SudokuElementDto sudokuElementDto){
        for(int i = 0; i < SIZE; i++){
            if(board[i][sudokuElementDto.getCol()].getValue() == sudokuElementDto.getValue()){
                return true;
            }
        }
        return false;
    }

    public boolean isNumberInBox(SudokuElementDto sudokuElementDto){
        int boxRow = sudokuElementDto.getRow() - sudokuElementDto.getRow() % 3;
        int boxCol = sudokuElementDto.getCol() - sudokuElementDto.getCol() % 3;
        for(int i = boxRow; i < boxRow + 3; i++){
            for (int n = boxCol; n < boxCol + 3; n++){
                if(board[i][n].getValue() == sudokuElementDto.getValue()){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isNumberValid(SudokuElementDto sudokuElementDto){
        return !isNumberInRow(sudokuElementDto) &&
               !isNumberInCol(sudokuElementDto) &&
               !isNumberInBox(sudokuElementDto);
    }

    public void setPossibleValuesInRow(SudokuElementDto sudokuElementDto){
        for(int i = 0; i < SIZE; i++){
            board[sudokuElementDto.getRow()][i].removeElement(sudokuElementDto.getValue());
        }
    }

    public void setPossibleValuesInCol(SudokuElementDto sudokuElementDto){
        for(int i = 0; i < SIZE; i++){
            board[i][sudokuElementDto.getCol()].removeElement(sudokuElementDto.getValue());
        }
    }

    public void setPossibleValuesInBox(SudokuElementDto sudokuElementDto){
        int boxRow = sudokuElementDto.getRow() - sudokuElementDto.getRow() % 3;
        int boxCol = sudokuElementDto.getCol() - sudokuElementDto.getCol() % 3;
        for(int i = boxRow; i < boxRow + 3; i++){
            for (int n = boxCol; n < boxCol + 3; n++){
                board[i][n].removeElement(sudokuElementDto.getValue());
            }
        }
    }

    public void setPossibleValues(SudokuElementDto sudokuElementDto){
        setPossibleValuesInRow(sudokuElementDto);
        setPossibleValuesInCol(sudokuElementDto);
        setPossibleValuesInBox(sudokuElementDto);
    }

    public boolean completeBoard(){
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if(board[row][col].getValue() == SudokuGame.EMPTY){
                    for(int i = 0; i < board[row][col].getPossibleValues().size(); i++){
                        int numberToTry = board[row][col].getPossibleValues().get(i);
                        SudokuElementDto sudokuElementDto = new SudokuElementDto(row, col, numberToTry);
                        if(isNumberValid(sudokuElementDto)){
                            board[row][col].setValue(numberToTry);
                            if(completeBoard()){
                                setPossibleValues(sudokuElementDto);
                                return true;
                            }
                            else {
                                board[row][col].setValue(SudokuGame.EMPTY);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        int rowCounter = 0;
        int colCounter = 0;
        for(int n = 0; n <= SIZE; n++) {
            if (rowCounter % 3 == 0) {
                for (int i = 0; i < SIZE; i++) {
                    result += "_____";
                }
            } else {
                for (int i = 0; i < SIZE; i++) {
                    result += "-----";
                }
            }
            result += "\n";
            if(rowCounter < SIZE){
                result += "  ";
                for(int k = 0; k < SIZE; k++){
                    if(colCounter % 3 == 0){
                        result += "||";
                    } else{
                        result += "|";
                    }
                    if(board[n][k].getValue() == SudokuGame.EMPTY){
                        result += "   ";
                    } else {
                        result += " " + board[n][k].getValue() + " ";
                    }
                    colCounter++;
                    if(colCounter == SIZE){
                        result += "||";
                    }
                }
            }
            colCounter = 0;
            result += "\n";
            rowCounter++;
        }
        return result;
    }
}
