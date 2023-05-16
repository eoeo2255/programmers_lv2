package org.example.N92343;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Tests {

    @Test
    @DisplayName("getNextNodes")
    void t01() {
        PathCalculator pathCalculator = new PathCalculator(
                new int[]{0, 0, 0},
                new int[][]{{0, 1}, {0, 2}}
        );

        assertThat(
                pathCalculator.getNextNodes(0)
        )
                .isEqualTo(
                        List.of(1, 2)
                );
    }
    @Test
    @DisplayName("getNextNodes with history")
    void t02() {
        PathCalculator pathCalculator = new PathCalculator(
                new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}}
        );

        assertThat(
                pathCalculator.getNextNodes(4, List.of(0, 1, 4))
        )
                .containsAll(
                        List.of(3, 8, 2)
                );
    }

    @Test
    @DisplayName("getNextNodes with history")
    void t03() {
        PathCalculator pathCalculator = new PathCalculator(
                new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}}
        );

        assertThat(
                pathCalculator.getNextNodes(5, List.of(0, 2, 5))
        )
                .containsAll(
                        List.of(1, 6)
                );
    }

    @Test
    @DisplayName("getNextNodes with history")
    void t04() {
        PathCalculator pathCalculator = new PathCalculator(
                new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}}
        );

        assertThat(
                pathCalculator.getNextNodes(5, List.of(0, 1, 2, 5))
        )
                .containsAll(
                        List.of(3, 4, 6)
                );
    }
}