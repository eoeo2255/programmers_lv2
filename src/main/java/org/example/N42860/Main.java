package org.example.N42860;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

            int diff = Math.min(c-'A', 'Z' - c +1);     // 앞으로 갔을 때와 (전자 식), 뒤로 갔을 때의 (후자 식) 값을 비교해 방향 결정, 최소 횟수를 구해야 하기 때문에 Math.min 사용
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

    public int directionCheck(String name) {        // 'A'가 연속한 부분이 있음, 앞으로만 이동했을 경우 이동 횟수
        int move = 0;

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                move = i;
            }
        }

        return move;
    }

    public int directionCheck2(String name) {       // 'A'가 연속한 부분이 있음, 뒤로만 이동했을 경우 이동 횟수
        int move = 0;

        for (int i = name.length()-1; i > 1; i--) {
            if (name.charAt(i) != 'A') {
                move = name.length() - i;
            }
        }
        return move;
    }


}

class Ut{       // 'A'가 연속하는 구간이 있을 경우, 해당 구간의 시작 인덱스번호와 길이를 반환 (feat. chatGPT)

    public static class longestContinuumLengthAndIndex {
        int index;
        int length;

        public longestContinuumLengthAndIndex(int index, int length) {
            this.index = index;
            this.length = length;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof longestContinuumLengthAndIndex that)) return false;

            if (index != that.index) return false;
            return length == that.length;
        }

        @Override
        public String toString() {
            return "LongestCharContinuumIndexAndLength{" +
                    "index=" + index +
                    ", length=" + length +
                    '}';
        }
    }

        public static longestContinuumLengthAndIndex getLongestContinuumLengthAndIndex(String str, char c) {
            String regex = c + "+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);

            int maxLength = 0;
            int maxIndex = -1;

            while (matcher.find()) {
                int startIndex = matcher.start();
                int length = matcher.end() - startIndex;

                if (length > maxLength) {
                    maxLength = length;
                    maxIndex = startIndex;
                }
            }

            return new longestContinuumLengthAndIndex(maxIndex, maxLength);
        }
}