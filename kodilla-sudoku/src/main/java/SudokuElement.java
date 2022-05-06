import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class SudokuElement {

    private int row;
    private int col;
    private int value;
    private List<Integer> possibleValues = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public SudokuElement(int row, int col) {
        this.row = row;
        this.col = col;
        value = SudokuGame.EMPTY;
    }

    public void removeElement(int element){
        for(int i = 0; i < possibleValues.size();){
            if(Objects.equals(element, possibleValues.get(i))){
                possibleValues.remove(i);
            } else {
                i++;
            }
        }
    }
}
