class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0;
        int left = 0; int right = height.length-1;
        while(left<right){
            int width = right-left;
            int minheight = Math.min(height[left], height[right]);
            int area = width*minheight;

            maxarea = Math.max(area, maxarea);

            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxarea;
    }
}