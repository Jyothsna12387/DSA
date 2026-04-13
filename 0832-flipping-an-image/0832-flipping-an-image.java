class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int m = image[0].length;
        
        //step 1: Flip the image
         for(int i=0; i<n; i++){
            int left=0, right=m-1;
            while(left<right){
                int temp = image[i][left];
                image[i][left] = image[i][right];
                image[i][right] = temp;
                left++;
                right--;
            }
         }

         //step 2: Invert the image
         for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                image[i][j] = 1 - image[i][j];
            }
        }
        return image;

        }        
    }