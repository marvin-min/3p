package algorithm;

/*
    https://www.runoob.com/w3cnote/bubble-sort.html
    相邻两个比较
    复杂度O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 9, 4, 6, 8, 2, 7};

        for(int i=0;i< array.length-1;i++){
            for(int j=0;j< array.length -1 - i;j++){
                if(array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
            printArr(array);
        }


    }
    static void printArr(int[] array){
//        System.out.println("--------------------------------------------");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");
        }
        System.out.println("");
    }
}
