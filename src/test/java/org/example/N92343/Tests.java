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
}