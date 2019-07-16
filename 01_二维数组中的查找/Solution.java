import javax.lang.model.util.ElementScanner6;

public class Solution {
    public boolean Find1(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target)
                    return true;
            }
        }
        return false;
    }

    public boolean Find2(int target, int[][] array) {
        int row = 0, col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (array[row][col] > target)
                col--;
            else if (array[row][col] < target)
                row++;
            else
                return true;
        }
        return false;
    }
}