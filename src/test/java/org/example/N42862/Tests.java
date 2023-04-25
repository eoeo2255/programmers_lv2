package org.example.N42862;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
