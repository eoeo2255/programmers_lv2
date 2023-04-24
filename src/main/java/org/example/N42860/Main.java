package org.example.N42860;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("JEROEN"));  // 56
    }
}


class Solution {
    public int solution(String name) {
        char c = name.charAt(0);

        return c - 'A';
    }

}