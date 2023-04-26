import java.util.Arrays;

public class arrayrotate {
    public static void main(String[] args) {

        System.out.println("java".toUpperCase());
        int[] arr = {1, 2, 3, 4, 5, 6, 7,8,9,10,11,12,13,14,25,34};
        int[] arr1=new int[arr.length];
        int d = 2;
        int n = arr.length;
        int last1 = arr[arr.length-2];
        int last2 = arr[arr.length-1];
        int i=2;
        for (int j = arr.length-1; j>2; j--)
        {
                arr1[i] = arr[j];
                i+=1;
                }
        arr1[0]=last1;
        arr1[1]=last2;
        System.out.println(Arrays.toString(arr1));

    }

}
