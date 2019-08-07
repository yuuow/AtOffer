## [机器人的运动范围](https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数组</code>

#### 题目描述

> 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？


----

#### 思路(BFS)
* [图的遍历(BFS和DFS)](https://www.jianshu.com/p/70952b51f0c8)
```java
import java.util.*;

public class Solution {

    class State{
        int x,y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    final int[][] dir = {{-1, 0},{0, 1},{1, 0},{0, -1}};

    //不能进入行坐标和列坐标的 数位之和 大于threshold的格子
    public int movingCount(int threshold, int rows, int cols){
        Queue<State>queue = new LinkedList<>();
        boolean[][] vis = new boolean[rows][cols];
        queue.add(new State(0, 0));
        vis[0][0] = true;
        int res = threshold < 0 ? 0 : 1; //注意threshold < 0的时候连(0,0)都不能加入
        while(!queue.isEmpty()){
            State cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];
                int d1 = digitSum(nx);
                int d2 = digitSum(ny);
                if(d1 + d2 > threshold) 
                    continue;
                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && !vis[nx][ny]){
                    res++;
                    vis[nx][ny] = true;
                    queue.add(new State(nx, ny));
                }
            }
        }
        return res;
    }

    //计算数位之和
    private int digitSum(int n){
        int cnt = 0;
        while(n > 0){
            cnt += n % 10;
            n /= 10;
        }
        return cnt;
    }
}
```