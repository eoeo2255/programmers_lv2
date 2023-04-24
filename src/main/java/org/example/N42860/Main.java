package org.example.N42860;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("JEROEN"));  // 56
    }
}


class Solution {
    public int solution(String name) {
        return nameCount(name) + moveCount(name);
    }

    public int nameCount(String name) {
        int nameCount = 0;   // 문자 바꾸는데 필요한 횟수, 위/아래

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            int diff = c - 'A';     // 'A'와 얼마나 차이가 나는지 계산, 'A'가 되려면 몇번 움직여야하는지 해당 칸의 nameCost 를 구함

            nameCount += diff;       // 총 nameCost 를 구하기 위해 더함
        }

        return nameCount;
    }

    public int moveCount(String name) {
        int moveCount = 0;   // 위치 바꾸는데 드는 비용, 좌/우

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            int diff = c - 'A';     // 'A'와 얼마나 차이가 나는지 계산, 'A'가 되려면 몇번 움직여야하는지 해당 칸의 nameCost 를 구함

            if (diff > 0) {         // 만약 'A'와 차이가 없을 경우 ('A'인 경우)
                moveCount = i;
            }
        }

        return moveCount;
    }
}