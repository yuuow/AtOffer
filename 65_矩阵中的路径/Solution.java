public class Solution {

    final int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    private boolean vist[];
    private int r, c;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        r = rows;
        c = cols;
        vist = new boolean[r * c];
        for (int i = 0; i < matrix.length; i++) {
            int x = i / c;
            int y = i % c;
            if (dfs(matrix, str, 0, x, y))
                return true;
        }
        return false;
    }

    private boolean dfs(char[] matrix, char[] str, int cur, int x, int y) {
        if (cur == str.length - 1 && matrix[x * c + y] == str[cur])
            return true;
        if (vist[x * c + y] || matrix[x * c + y] != str[cur])
            return false;
        vist[x * c + y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !vist[nx * c + ny] && (dfs(matrix, str, cur + 1, nx, ny)))
                return true;
        }
        vist[x * c + y] = false;
        return false;
    }
}
