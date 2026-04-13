class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for(int i=0; i<=n-m; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(haystack.substring(i,m+i).equals(needle)){
                    return i;
                }
            }
          
         }
          return -1;
        }
    }
