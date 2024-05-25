class Solution {
    public String solution(String myString, String pat) {
        int lastIndex = myString.lastIndexOf(pat);
        
        return myString.substring(0, lastIndex + pat.length());
    }
}