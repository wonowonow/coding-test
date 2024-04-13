class Solution {
    public int solution(String myString, String pat) {

        return myString.contains(pat.replace("A", "C").replace("B", "A").replace("C", "B")) ? 1 : 0;
    }
}