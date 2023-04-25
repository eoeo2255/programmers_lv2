package org.example.N42862;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Tests {

    @Test
    @DisplayName("n-> 5 / lost-> [2] / reserve-> [2] = 5")
    void t01() {
        assertThat(
                new Solution().solution(5,new int[]{2},new int[]{2})
        ).isEqualTo(
                5
        );
    }

    @Test
    @DisplayName("n-> 5 / lost-> [2, 4] / reserve-> [2] = 4")
    void t02() {
        assertThat(
                new Solution().solution(5,new int[]{2,4},new int[]{2})
        ).isEqualTo(
                4
        );
    }

    @Test
    @DisplayName("n-> 7 / lost-> [2, 3, 5] / reserve-> [1] = 5")
    void t02_2() {
        assertThat(
                new Solution().solution(7,new int[]{2,3,5},new int[]{1})
        ).isEqualTo(
                5
        );
    }

    @Test
    @DisplayName("n-> 5 / lost-> [1, 2, 3, 4, 5] / reserve-> [1, 2, 3, 4, 5] = 5")
    void t03() {
        assertThat(
                new Solution().solution(5,new int[]{1, 2, 3, 4, 5},new int[]{1, 2, 3, 4, 5})
        ).isEqualTo(
                5
        );
    }

    @Test
    @DisplayName("n-> 5 / lost-> [1, 2, 3, 4, 5] / reserve-> [1] = 1")
    void t04() {
        assertThat(
                new Solution().solution(5,new int[]{1, 2, 3, 4, 5},new int[]{1})
        ).isEqualTo(
                1
        );
    }

    @Test
    @DisplayName("n-> 5 / lost-> [1, 2, 3] / reserve-> [5] = 2")
    void t05() {
        assertThat(
                new Solution().solution(5,new int[]{1, 2, 3},new int[]{5})
        ).isEqualTo(
                2
        );
    }

    @Test
    @DisplayName("n-> 5 / lost-> [1, 2] / reserve-> [3, 4, 5] = 4")
    void t06() {
        assertThat(
                new Solution().solution(5,new int[]{1, 2},new int[]{3, 4, 5})
        ).isEqualTo(
                4
        );
    }

    @Test
    @DisplayName("n-> 5 / lost-> [1] / reserve-> [3, 4, 5] = 4")
    void t07() {
        assertThat(
                new Solution().solution(5,new int[]{1},new int[]{3, 4, 5})
        ).isEqualTo(
                4
        );
    }

    @Test
    @DisplayName("n-> 5 / lost-> [1] / reserve-> [1, 2, 3, 4, 5] = 5")
    void t08() {
        assertThat(
                new Solution().solution(5,new int[]{1},new int[]{1, 2, 3, 4, 5})
        ).isEqualTo(
                5
        );
    }

    @Test
    @DisplayName("n-> 5 / lost-> [1, 3, 17] / reserve-> [3] = 3")
    void t09() {
        assertThat(
                new Solution().solution(5,new int[]{1, 3, 17},new int[]{3})
        ).isEqualTo(
                3
        );
    }

    @Test
    @DisplayName("n-> 7 / lost-> [2, 3] / reserve-> [3, 4] = 6")
    void t010() {
        assertThat(
                new Solution().solution(7,new int[]{2, 3},new int[]{3, 4})
        ).isEqualTo(
                6
        );
    }
}
