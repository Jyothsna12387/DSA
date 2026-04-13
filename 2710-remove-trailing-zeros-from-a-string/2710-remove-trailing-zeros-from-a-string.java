class Solution {
    public String removeTrailingZeros(String num) {
        int i = num.length() - 1;

        // move backward while zeros
        while (i >= 0 && num.charAt(i) == '0') {
            i--;
        }

        // substring till last non-zero
        return num.substring(0, i + 1);
    }
}