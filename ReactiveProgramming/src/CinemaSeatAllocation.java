import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CinemaSeatAllocation {

    /*
        A cinema has n rows of seats, numbered from 1 to n and there are ten seats in each row, labelled from 1 to 10 as shown in the figure above.

        Given the array reservedSeats containing the numbers of seats already reserved, for example, reservedSeats[i] = [3,8] means the seat located in row 3 and labelled with 8 is already reserved.

        Return the maximum number of four-person groups you can assign on the cinema seats. A four-person group occupies four adjacent seats in one single row. Seats across an aisle (such as [3,3] and [3,4]) are not considered to be adjacent, but there is an exceptional case on which an aisle split a four-person group, in that case, the aisle split a four-person group in the middle, which means to have two people on each side.



        Example 1:



        Input: n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
        Output: 4
        Explanation: The figure above shows the optimal allocation for four groups, where seats mark with blue are already reserved and contiguous seats mark with orange are for one group.
        Example 2:

        Input: n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
        Output: 2
        Example 3:

        Input: n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
        Output: 4


        Constraints:

        1 <= n <= 10^9
        1 <= reservedSeats.length <= min(10*n, 10^4)
        reservedSeats[i].length == 2
        1 <= reservedSeats[i][0] <= n
        1 <= reservedSeats[i][1] <= 10
        All reservedSeats[i] are distinct.

     */

    public static void main(String[] args) {
        int[][] reservedSeats = {{4,3},{1,4},{4,6},{1,7}};
        System.out.println(maxNumberOfFamilies(4, reservedSeats));//Output: 4
    }
    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int max = n *2;
        HashMap<Integer, ArrayList<Integer>> listSet = new HashMap<>();

        for (int[] array: reservedSeats ) {
            if(array[1] > 1 && array[1] < 10){
                ArrayList<Integer> tmp;
                if(listSet.containsKey(array[0]-1)){
                    tmp = listSet.get(array[0]-1);
                } else {
                    tmp = new ArrayList<>();
                }
                tmp.add(array[1]-1);
                listSet.put(array[0]-1, tmp);
            }
        }

        for (Integer key : listSet.keySet()){
            ArrayList<Integer> list = listSet.get(key);
            if(list.contains(4) && list.contains(5) ||
                    list.contains(3) && list.contains(6)){
                max = max - 2;
            } else{
                int  de = 0;
                if(list.contains(1) || list.contains(2) ||
                        list.contains(3) || list.contains(4)){
                    max--;
                    de++;
                }
                if(list.contains(5) || list.contains(6) ||
                        list.contains(7) || list.contains(8)){
                    max--;
                    de++;
                }
                if(de == 2 && !list.contains(5) && !list.contains(6)
                        && !list.contains(3) && !list.contains(4)){
                    max++;
                }
            }
        }

        return max;

    }
}
