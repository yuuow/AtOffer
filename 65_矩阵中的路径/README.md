## [矩阵中的路径](https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数组</code>

#### 题目描述

> 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。


----

#### 思路
* 递归不断地寻找周围四个格子是否符合条件，只要有一个格子符合条件，就继续再找这个符合条件的格子的四周是否存在符合条件的格子，直到 `cur` 到达末尾或者不满足递归条件就停止
```java
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

```