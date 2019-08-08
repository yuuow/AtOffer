# 概况

<img  src="./images/00_s1.jpg">

> * 稳定型：保证排序前后两个相等的数的相对顺序不变
>    * 稳定：如果a原本在b前面，且a=b，排序之后a仍然在b的前面
>    * 不稳定：如果a原本在b的前面，且a=b，排序之后a可能会出现在b的后面
>* 排序方式
>    * 内部排序：待排序记录存放在计算机随机存储器中（说简单点，就是内存）进行的排序过程
 >   * 外部排序：待排序记录的数量很大，以致于内存不能一次容纳全部记录，所以在排序过程中需要对外存进行访问的排序过程
    
`Swap` 函数（交换数组中某两个位置的值）
```java
static void swap(int[] arr,int i,int j) { 
    int temp = arr[i];
    arr[i] = arr[j]; 
    arr[j] = temp;
}
```
或者
```java
static void swap(int[] arr,int i,int j) {
    arr[i] = arr[i] ^ arr[j];
    arr[j] = arr[i] ^ arr[j];
    arr[i] = arr[i] ^ arr[j];
}
```
## 一、冒泡排序
> 两个数比较大小，较大的数下沉，较小的数冒起来。

<img src="./images/00_s2.gif">

```java
public static void bubbleSort(int[] arr) {
    if (arr == null || arr.length == 0)
        return;
    //通过与相邻元素的比较和交换来把小的数交换到最前面（动图相反过程）
    //for (int i = 0; i < arr.length - 1; i++) 
        // for (int j = arr.length - 1; j > i; j--)
        //     if (arr[j] < arr[j - 1])
        //         swap(arr, j, j - 1);
    for (int i = 0; i < arr.length; i++) 
        for (int j = 0; j < arr.length - i - 1; j++)
            if (arr[j + 1] < arr[j])
                swap(arr, j, j + 1);
}

```
* 优化方案
    * **问题**：数据的顺序排好之后，冒泡算法仍然会继续进行下一轮的比较，直到 `arr.length-1` 次，后面的比较没有意义的。
    * **方案**：设置标志位 `flag`，如果发生了交换 `flag` 设置为 `true`；如果没有交换就设置为 `false`。这样当一轮比较结束后如果 `flag` 仍为 `false`，即：这一轮没有发生交换，说明数据的顺序已经排好，没有必要继续进行下去
```java
public static void bubbleSort(int[] arr) {
    if (arr == null || arr.length == 0)
        return;
    boolean flag;
    //通过与相邻元素的比较和交换来把小的数交换到最前面（动图相反过程）
    for (int i = 0; i < arr.length - 1; i++) {
        flag = false;
        for (int j = arr.length - 1; j > i; j--) {
            if (arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                flag = true;
            }
        }
        if (!flag)
            break;
    }
}
```


