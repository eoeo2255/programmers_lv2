package org.example.N42583;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Tests {

    @Test
    @DisplayName("100, 100, {10} -> 101")
    void test001() {
        assertThat(new Solution().solution(100, 100, new int[]{10}))
                .isEqualTo(101);
    }

    @Test
    @DisplayName("100, 100, {10, 10} -> 102")
    void test002() {
        assertThat(new Solution().solution(100, 100, new int[]{10, 10}))
                .isEqualTo(102);
    }

    @Test
    @DisplayName("2, 10, {7,4,5,6} -> 8")
    void test003() {
        assertThat(new Solution().solution(2, 10, new int[]{7,4,5,6}))
                .isEqualTo(8);
    }

    @Test
    @DisplayName("2, 10, {7,4,5,6} → 8")
    void t04() {
        assertThat(
                new Solution().solution(2, 10, new int[]{7, 4, 5, 6})
        ).isEqualTo(
                8
        );
    }

    @Test
    @DisplayName("Solution2 : 100, 100, {10} → 101")
    void t05_1() {
        assertThat(
                new Solution2().solution(100, 100, new int[]{10})
        ).isEqualTo(
                101
        );
    }

    @Test
    @DisplayName("Solution2 : 100, 100, {10, 10} → 102")
    void t05_2() {
        assertThat(
                new Solution2().solution(100, 100, new int[]{10, 10})
        ).isEqualTo(
                102
        );
    }

    @Test
    @DisplayName("Solution2 : 100, 100, {10,10,10,10,10,10,10,10,10,10} → 110")
    void t05_3() {
        assertThat(
                new Solution2().solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10})
        ).isEqualTo(
                110
        );
    }

    @Test
    @DisplayName("Solution2 : 2, 10, {7,4,5,6} → 8")
    void t05_4() {
        assertThat(
                new Solution2().solution(2, 10, new int[]{7, 4, 5, 6})
        ).isEqualTo(
                8
        );
    }

}
