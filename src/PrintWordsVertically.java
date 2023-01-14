import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {
    public static List<String> printVertically(String s) {
        int index=0;
        String res = "";
        boolean isNotMaxEnd;
        List<String> resList = new ArrayList<>();

        String[] strArr = s.split(" ");

        while(true){
            isNotMaxEnd = false;

            for(int i=strArr.length-1; i>=0; i--){
                if(index < strArr[i].length()){
                    res = strArr[i].charAt(index) + res;
                    isNotMaxEnd = true;
                } else{
                    if(isNotMaxEnd) res = " " + res;
                }
            }

            if(!isNotMaxEnd) break;

            resList.add(res);
            index++;
            res="";
        }

        return resList;
    }

    public static void main(String[] args) {
        String string = "TO BE OR NOT TO BE";
        System.out.println(printVertically(string));
    }
}
