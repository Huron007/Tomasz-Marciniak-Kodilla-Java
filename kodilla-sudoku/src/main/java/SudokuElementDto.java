import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SudokuElementDto {
    private int row;
    private int col;
    private int value;
}
