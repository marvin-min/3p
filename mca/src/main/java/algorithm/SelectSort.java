package algorithm;

/**
 * 选择排序是一种简单直观的排序算法，无论什么数据进去都是 O(n²) 的时间复杂度。所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。
 * <p>
 * 1. 算法步骤
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
 * <p>
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * <p>
 * 重复第二步，直到所有元素均排序完毕。
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 9, 4, 6, 8, 2, 7};
        int min;
        int temp;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
              if(array[j]< array[min]){
                  min = j;
              }
            }
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;

            ArrayUtils.printArr(array);
        }
    }
}
