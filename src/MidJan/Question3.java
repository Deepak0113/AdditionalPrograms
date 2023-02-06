package MidJan;

import java.util.ArrayList;
import java.util.HashMap;

public class Question3 {
    private int val(String[] arr1, String arr2[]){
        int count = 0;
        HashMap<String, Boolean> hashMap1 = new HashMap<>();
//        HashMap<String, Boolean> hashMap2;

        for(String s1: arr1){
//            hashMap2 = new HashMap<>();
            boolean flag = true;
            if(hashMap1.containsKey(s1)){
                count++;
            } else{
                for(String s2: arr2){
                    if(!checkSuperString(s1,s2)){
                        flag = false;
                        break;
                    }
                }

                if(flag) count++;
                hashMap1.put(s1, flag);
            }
        }

        return count;
    }

    private boolean checkSuperString(String string1, String string2){
        ArrayList<Character> arrayList = new ArrayList<>();
        char ch;

        for(int i=0; i<string1.length(); i++){
            ch = string1.charAt(i);
            if(!arrayList.contains(ch)){
                arrayList.add(ch);
            }
        }

        for(int i=0; i<string2.length(); i++){
            ch = string2.charAt(i);
            if(!arrayList.contains(ch)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Question3 q3 = new Question3();
        String[] x = {"ceo","alco","caaeio","ceai","acoeaaco"};
        String[] y={"ec","oc","ceo"};
        System.out.println(q3.val(x,y));
    }
}
