package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

//    While using Hashing Map
    /*public int [] TwoSum(int [] arr , int target){
        int [] result = new int[2];
        Map<Integer , Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            if (!map.containsKey(target - arr[i])){
                map.put(arr[i] , i);
            }
            else {
                result [0] = i;
                result [1] = map.get(target - arr[i]);
                return result;
            }
        }
        throw new IllegalArgumentException("The sum is not found in the given array");
    }*/

//    Without using Hash Map
    public int [] TwoSum(int [] arr , int target){
        Arrays.sort(arr);
        int [] result = new int[2];
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int sum = arr [left] + arr [right];
            if (sum == target){
                result [0] = left;
                result [1] = right;
                return result;
            }
            else if (sum < target) {
                left++;
            }
            else{
                right--;
            }
        }
        throw new IllegalArgumentException("Sum not found in the given array");
    }


    public static void main(String[] args) {

        Two_Sum ts = new Two_Sum();

        int [] arr = {2 , 5 , 6 , 8 , 10 ,13};
        int target = 14;
        int [] result = ts.TwoSum(arr , target);

        System.out.println("The indices of the required result are as follows:");
        System.out.println(Arrays.toString(result));
    }
}
