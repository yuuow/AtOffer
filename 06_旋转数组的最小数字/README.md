## [旋转数组的最小数字](https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">查找</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数组</code>

#### 题目描述

> 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

-----
> 参考[牛客网评论区](https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba)
#### 思路一
* 这是一道二分查找的变形的题目，旋转之后的数组实际上可以划分成两个有序的子数组：前面子数组的大小都大于后面子数组中的元素，注意到**实际上最小的元素就是两个子数组的分界线**。
* 用两个指针 `left` , `right` 分别指向数组的第一个元素和最后一个元素。按照题目的旋转的规则，第一个元素应该是大于最后一个元素的（没有重复的元素）。但是如果不是旋转，第一个元素肯定小于最后一个元素。
* 找到数组的中间元素,缩小寻找的范围。
   * 中间元素大于第一个元素，则中间元素位于前面的递增子数组，此时**最小元素位于中间元素的后面**。让第一个指针` left` 指向中间元素。移动之后，第一个指针仍然位于前面的递增数组中。
   * 中间元素小于第一个元素，则中间元素位于后面的递增子数组，此时**最小元素位于中间元素的前面**。让第二个指针 `right` 指向中间元素。移动之后，第二个指针仍然位于后面的递增数组中。
* 第一个指针 `left` 总是指向前面递增数组的元素，第二个指针 `right` 总是指向后面递增的数组元素。最终第一个指针将指向前面数组的最后一个元素，第二个指针指向后面数组中的第一个元素。也就是说它们将指向两个相邻的元素，而**第二个指针指向的刚好是最小的元素，这就是循环的结束条件**。
* 到目前为止以上思路很耗的解决了没有重复数字的情况，这一道题目添加上了这一要求，有了重复数字...因此这一道题目比上一道题目多了些特殊情况，要单独判断特殊情况。
* 比如`{1，0，1，1，1｝` 和 `｛1，1， 1，0，1｝` 都可以看成是递增排序数组`｛0，1，1，1，1｝`的旋转。无法继续用上一道题目的解法，去解决这道题目。因为在这两个数组中，第一个数字，最后一个数字，中间数字都是1。第一种情况下，中间数字位于后面的子数组，第二种情况，中间数字位于前面的子数组。因此当两个指针指向的数字和中间数字相同的时候，我们无法确定中间数字1是属于前面的子数组还是属于后面的子数组。也就无法移动指针来缩小查找的范围。

```java
public class Solution {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        int L = 0, R = array.length - 1;
        //确保是旋转数组
        while (array[L] >= array[R]) {
            // 分界点
            if (R - L == 1)
                return array[R];
            int mid = L + (R - L) / 2;
            //｛1，0，1，1，1｝ 和 ｛1，1， 1，0，1｝ 
            // rotateArray[left] rotateArray[right] rotateArray[mid]三者相等
            // 重复元素的特殊情况 不能确定中间元素是属于前面还是后面的递增子数组
            // 只能顺序查找
            if (array[L] == array[mid] && array[mid] == array[R]) {
                for (int i = L + 1; i <= R; i++)
                    if (array[i] < array[i - 1])
                        return array[i];
            }
            //中间元素位于前面的递增子数组
            //此时最小元素位于中间元素的后面
            if (array[mid] >= array[L])
                L = mid;
            //中间元素位于后面的递增子数组
            //此时最小元素位于中间元素的前面
            else
                R = mid;
        }
        // 此时array[R] > array[L](循环退出), 返回array[L]
        return array[L];
    }
}
```

#### 思路二(采用二分法解答)
* `array[mid] > array[R]`: 类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。`L = mid + 1`
* `array[mid] == array[R]`: 类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边还是右边,这时只好一个一个试。`R = R - 1`
* `array[mid] < array[R]`: 类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左边。因为右边必然都是递增的。`R = mid`
* 注意这里有个坑：如果待查询的范围最后只剩两个数，那么`mid`一定会指向下标靠前的数字,比如 `array = [4,6]`;`array[L] = 4`;`array[mid] = 4`;`array[R] = 6`;如果`R = mid - 1`，就会产生错误， 因此`R = mid`(但`array[mid]>array[R]`中不会出错)
```java
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int L = 0 ; int R = array.length - 1;   
        while(L < R){
            int mid = L + (R - L) / 2;
            //最小数字在mid右边        
            if(array[mid] > array[R]){
                L = mid + 1;
            //重复元素的特殊情况
            }else if(array[mid] == array[R]){
                R = R - 1;
            //最小数字在mid左边
            }else{
                R = mid;
            }   
        }
        return array[L];
    }
}
```