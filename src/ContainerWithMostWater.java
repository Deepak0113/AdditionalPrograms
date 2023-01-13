public class ContainerWithMostWater {
    static int maxArea(int[] height) {
        int volume = 0;
        int left = 0, right = height.length-1;

        while(left<right){
            int diff = (right-left)*Math.min(height[left],height[right]);
            if(volume<diff) volume = diff;
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }

        System.out.println(volume);

        return volume;
    }

    public static void main(String[] args) {
        int[] testInput = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(testInput));
    }
}
