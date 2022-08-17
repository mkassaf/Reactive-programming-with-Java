import java.util.stream.IntStream;

public class Challenges {


    public static void main(String[] args) {
        int[] array = {-2,-1,-3,4,8,0};
        System.out.println(getMaxProduct(array));//32
        int[] array2 = {-20,-10,3,9,-8};
        System.out.println(getMaxProduct(array2));//200
    }


    //Maximum product of two numbers
    public static int getMaxProduct(int [] number){
        if (number.length < 2){
            return Integer.MIN_VALUE;
        }
        int max = number[0];
        int secMax = Integer.MIN_VALUE;
        int min = number[0];
        int secMin = Integer.MAX_VALUE;
        for (int i=1; i<number.length; i++){
            if (number[i] > max){
                secMax =max;
                max =number[i];
            } else if (secMax < number[i]){
                secMax =number[i];
            }
            if(min > number[i]){
                secMin = min;
                min = number[i];
            } else if (secMin > number[i]){
                secMin = number[i];
            }
        }
        return Math.max((max * secMax), (min * secMin));
    }




}
