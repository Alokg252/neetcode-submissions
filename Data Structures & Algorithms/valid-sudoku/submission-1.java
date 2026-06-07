class Solution {

    /*
    using a HashSet() with unique prefix identifiers for each rows, columns and box
    that way on repetation add on Set will return false and program will also.

    to identify box, using formula (row/3)*3 + (col/3)  
    */

    public int getBox(int r, int c) {
        return (r/3) * 3 + (c/3);
    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int r=0; r<9; r++) {
            for (int c=0; c<9; c++) {
                
                char n = board[r][c];
                if (n == '.') continue;

                boolean unique = 
                    set.add("r" + r + "_" + n) &&
                    set.add("c" + c + "_" + n) &&
                    set.add("b" + getBox(r,c) + "_" + n);

                if (!unique) return false;
            }
        }
        return true;
    }
}
