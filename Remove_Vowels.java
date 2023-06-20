package Hashing;

import java.util.Scanner;
import java.util.Set;

public class Remove_Vowels {

    public String remove(String str){
        Set<Character> vowels = Set.of('a' , 'e' , 'i' , 'o' , 'u');
        StringBuilder sb = new StringBuilder();
        char [] chars = str.toLowerCase().toCharArray();
        for (Character c : chars){
            if (!vowels.contains(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Remove_Vowels rv =  new Remove_Vowels();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string");
        String str = sc.nextLine();

        System.out.println("The string after removing the vowels is " + rv.remove(str));

        System.out.println(Integer.reverse(234));
    }
}
