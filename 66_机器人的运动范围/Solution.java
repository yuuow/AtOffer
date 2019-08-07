import java.util.*;

public class Solution {

    class State {
        int x, y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    final int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    //不能进入行坐标和列坐标的 数位之和 大于threshold的格子
    public int movingCount(int threshold, int rows, int cols) {
        Queue<State> queue = new LinkedList<>();
        boolean[][] vis = new boolean[rows][cols];
        queue.add(new State(0, 0));
        vis[0][0] = true;
        int res = threshold < 0 ? 0 : 1; //注意threshold < 0的时候连(0,0)都不能加入
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];
                int d1 = digitSum(nx);
                int d2 = digitSum(ny);
                if (d1 + d2 > threshold)
                    continue;
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !vis[nx][ny]) {
                    res++;
                    vis[nx][ny] = true;
                    queue.add(new State(nx, ny));
                }
            }
        }
        return res;
    }

    private int digitSum(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n % 10;
            n /= 10;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(5, 10, 10));
    }
}