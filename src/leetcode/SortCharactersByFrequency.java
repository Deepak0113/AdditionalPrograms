package leetcode;

public class SortCharactersByFrequency {
    private String frequencySort(String s) {
        int[][] map = new int[62][2];
        String res = "";

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                map[ch-'a'+36][0]++;
                map[ch-'a'+36][1] = ch;
            } else if(ch>='A' && ch<='Z'){
                map[ch-'A'+10][0]++;
                map[ch-'A'+10][1] = ch;
            } else{
                map[ch-'0'][0]++;
                map[ch-'0'][1] = ch;
            }
        }

        sort(map);

        for(int i=0; i<62; i++){
            if(map[i][0]==0) break;
            res += (""+(char)map[i][1]).repeat(map[i][0]);
        }

        return res;
    }

    private void sort(int[][] arr){
        for(int i=0; i<62; i++){
            int min = i;
            for(int j=i+1; j<62; j++){
                if(arr[j][0] > arr[min][0]){
                    min = j;
                }
            }
            int[] temp = arr[i];
            arr[i] = arr[min];
            arr[min]=temp;
        }
    }

    public static void main(String[] args) {
        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
        System.out.print(sortCharactersByFrequency.frequencySort("tree"));
    }
}
