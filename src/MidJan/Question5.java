package MidJan;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Question5 {
    private void getCountCharacters(String inputString, String refString){
        LinkedHashMap<Character, Integer> countMap = new LinkedHashMap<>();
        inputString = inputString.toLowerCase();
        refString = refString.toLowerCase();

        int refStringLength = refString.length();
        int inputStringLength = inputString.length();
        char ch;

        for(int i=0; i<refStringLength; i++){
            ch = refString.charAt(i);
            if(!countMap.containsKey(ch)){
                countMap.put(ch, 0);
            }
        }

        for(int i=0; i<inputStringLength; i++){
            ch = inputString.charAt(i);
            if(countMap.containsKey(ch)){
                countMap.put(ch, countMap.get(ch)+1);
            }
        }

        for(Character key: countMap.keySet()){
            System.out.print(key+":"+countMap.get(key)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Question5 q5 = new Question5();
        Scanner sc = new Scanner(System.in);
        String string1, string2;

        while(true){
            System.out.println("Enter string1: ");
            string1 = sc.nextLine();
            System.out.println("Enter string2: ");
            string2 = sc.nextLine();
            q5.getCountCharacters(string1, string2);
            System.out.print("press q to exit: ");
            if(sc.nextLine().equals("q")) break;
        }
    }
}
