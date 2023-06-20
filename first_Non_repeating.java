package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class first_Non_repeating {

    public int firstNonRepeating(String str){
        Map<Character , Integer> map = new HashMap<>();
        char [] chars = str.toCharArray();
        for(char c : chars){
            map.put(c , map.getOrDefault(c , 0)+1);
        }

        for (int i = 0; i < chars.length; i++){
            char c = chars[i];
            if (map.get(c) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        first_Non_repeating fnp = new first_Non_repeating();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string");
        String str = sc.nextLine();

        if (fnp.firstNonRepeating(str) == -1){
            System.out.printf("The string '%s' has no non-repeating characters" , str);
            System.out.println();
        }
        else {
            System.out.printf("The non-repeating character in string '%s' is '%s' " , str , str.charAt(fnp.firstNonRepeating(str)));
        }
    }
}
