import java.util.ArrayList;
import java.util.List;

public class Game {
    private int columns;
    private int rows;
    private int[][] fields;

    public Game(int rows, int columns) {
        this.columns = columns;
        this.rows = rows;

        fields = new int[rows][columns];

        for (int row = 0; row < rows; row++)
            for (int col = 0; col < rows; col++)
                fields[row][col] = 0;
    }

    public void addAliveField(Field field) {
        if(field.row >= rows || field.column >= columns)
            throw new IllegalArgumentException();
        else
            fields[field.row][field.column] = 1;
    }

    public List<Field> getAliveFields() {
        List<Field> retValue = new ArrayList<>();

        for (int row = 0; row < rows; row++)
            for (int col = 0; col < columns; col++)
                if(fields[row][col] == 1)
                    retValue.add(new Field(row, col));

        return retValue;
    }

    @Override
    public String toString() {
        StringBuilder retValue = new StringBuilder();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (fields[row][col] == 1)
                    retValue.append("▮");
                else
                    retValue.append("▯");

                if(col != columns - 1)
                    retValue.append(" ");
            }

            if(row != rows - 1)
                retValue.append("\n");
        }

        return retValue.toString();
    }

    public List<Field> step() {
        int[][] tempFields = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int number = numberOfAliveFieldsAroundField(row, col);

                if (number < 2)
                    tempFields[row][col] = 0;
                else if (number == 3)
                    tempFields[row][col] = 1;
                else if (number > 3)
                    tempFields[row][col] = 0;
                else
                    tempFields[row][col] = fields[row][col];
            }
        }

        fields = tempFields;

        return getAliveFields();
    }

    private int isAliveField(int row, int col) {
        if(row < 0 || col < 0 || row >= rows || col >= columns)
            return 0;
        else
            return fields[row][col];
    }

    private int numberOfAliveFieldsAroundField(int row, int col) {
        return isAliveField(row - 1, col - 1) +
                isAliveField(row - 1, col) +
                isAliveField(row - 1, col + 1) +
                isAliveField(row, col - 1) +
                isAliveField(row, col + 1) +
                isAliveField(row + 1, col- 1) +
                isAliveField(row + 1, col) +
                isAliveField(row + 1, col + 1);
    }
}
