# 概况

<img width="70%" src="./images/00_s1.jpg">

* 稳定型：保证排序前后两个相等的数的相对顺序不变
    * 稳定：如果a原本在b前面，且a=b，排序之后a仍然在b的前面
    * 不稳定：如果a原本在b的前面，且a=b，排序之后a可能会出现在b的后面
* 排序方式
    * 内部排序：待排序记录存放在计算机随机存储器中（说简单点，就是内存）进行的排序过程
    * 外部排序：待排序记录的数量很大，以致于内存不能一次容纳全部记录，所以在排序过程中需要对外存进行访问的排序过程
    
`Swap` 函数
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
//通过与相邻元素的比较和交换来把小的数交换到最前面（动图相反过程）
public static void bubbleSort(int[] arr) {
    if (arr == null || arr.length == 0)
        return;
    for (int i = 0; i < arr.length - 1; i++)
        for (int j = arr.length - 1; j > i; j--)
            if (arr[j] < arr[j - 1])
                swap(arr, j - 1, j);
}

```
