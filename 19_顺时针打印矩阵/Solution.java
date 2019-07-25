import java.util.ArrayList;

public class Solution {

    private ArrayList<Integer> res;

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return null;
        res = new ArrayList<>();
        int ar = 0, ac = 0, br = matrix.length - 1, bc = matrix[0].length - 1;
        while (ar <= br && ac <= bc)
            print(ar++, ac++, br--, bc--, matrix);
        return res;
    }

    private void print(int ar, int ac, int br, int bc, int[][] matrix) {
        if (ar == br)
            for (int j = ac; j <= bc; j++)
                res.add(matrix[ar][j]);
        else if (ac == bc)
            for (int i = ar; i <= br; i++)
                res.add(matrix[i][ac]);
        else {
            for (int j = ac; j < bc; j++)
                res.add(matrix[ar][j]);
            for (int i = ar; i < br; i++)
                res.add(matrix[i][bc]);
            for (int j = bc; j > ac; j--)
                res.add(matrix[br][j]);
            for (int i = br; i > ar; i--)
                res.add(matrix[i][ac]);
        }
    }
}
