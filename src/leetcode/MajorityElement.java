package leetcode;

public class MajorityElement {
    static public int majorityElement(int[] nums) {
        int count = 0;
        int element = 0;

        for (int num : nums) {
            if (count == 0) {
                element = num;
            }
            if (num == element) {
                count++;
            } else {
                count--;
            }
        }

        return element;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
    }
}
