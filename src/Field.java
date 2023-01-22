public class Field {
        public int row;
        public int column;

        Field(int row, int column){
        this.column = column;
        this.row = row;
        }

        public int getColumn() { return column; }
        public int getRow() { return row; }
        public void setColumn(int column) { this.column = column; }
        public void setRow(int row) { this.row = row; }

        @Override
        public boolean equals(Object other){
            if (other instanceof Field otherField){
                return otherField.column == this.column && otherField.row == this.row;
            }

            return false;
        }

        @Override
        public String toString() {
            return "Field(row: " + this.row + ", column: " + this.column + ")";
        }
}