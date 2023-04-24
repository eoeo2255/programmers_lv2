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

            int diff = Math.min(c-'A', 'Z' - c +1);     // 앞으로 갈지 (전자 식), 뒤로 갈지 (후자 식) 결정
            // Math.min()은 두 값이 같을 경우, 같은 값을 반환 (여기서는 정 가운데인 N(=13)의 값이 해당 됨)

            nameCount += diff;       // 총 nameCost 를 구하기 위해 더함
        }

        return nameCount;
    }

    public int moveCount(String name) {
        int moveCount = 0;   // 위치 바꾸는데 필요한 횟수, 좌/우

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            int diff = Math.min(c-'A', 'Z' - c +1);

            if (diff > 0) {         // 'A'가 아닌 경우, 해당 값까지의 이동 횟수 ('A'인 경우 해당 값까지 갈 필요가 없음)
                moveCount = i;
            }
        }
        return moveCount;
    }
}