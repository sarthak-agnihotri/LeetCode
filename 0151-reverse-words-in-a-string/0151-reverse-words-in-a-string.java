class Solution {
    public String reverseWords(String s) {
        // trim + split on one or more spaces
        String[] words = s.trim().split("\\s+");

        // reverse the array
        int left = 0, right = words.length - 1;
        while (left < right) {
            String tmp = words[left];
            words[left] = words[right];
            words[right] = tmp;
            left++;
            right--;
        }

        // join with single space
        return String.join(" ", words);
    }
}