package org.example.N12946;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Tests {
    @Test
    @DisplayName("n이 1개일 때")
    void t01() {
        assertThat(new Solution()
                .solution(1))
                .isEqualTo(new int[][] {{1,3}})
        ;
    }

    @Test
    @DisplayName("n이 2개일 때")
    void t02() {
        assertThat(new Solution()
                .solution(2))
                .isEqualTo(new int[][] {{1,2}, {1,3}, {2,3}})
        ;
    }

    @Test
    @DisplayName("from=(1), to=(2), n이 2개일 때")
    void t03() {
        assertThat(new Hanoi(1,2,2).toArray())
                .isEqualTo(new int[][] {{1,3}, {1,2}, {3,2}})
        ;
    }

    @Test
    @DisplayName("from=(2), to=(1), n이 2개일 때")
    void t04() {
        assertThat(new Hanoi(2,1,2).toArray())
                .isEqualTo(new int[][] {{2, 3}, {2, 1}, {3, 1}})
        ;
    }
}
