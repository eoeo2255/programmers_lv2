package org.example.N42860;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("JEROEN"));  // 56
    }
}

//"JEROEN"	56
//"JAN"	23

class Solution {
    public int solution(String name) {
        return 0;
    }

    public int[] changeToIntArray(String name) {
        int[] asciiNumber = new int[name.length()];

        for (int i = 0; i < asciiNumber.length; i++) {
            asciiNumber[i] = (int) name.charAt(i);
        }

        return asciiNumber;
    }

}