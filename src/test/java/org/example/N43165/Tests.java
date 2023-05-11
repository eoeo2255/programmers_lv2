package org.example.N43165;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Tests {
    @Test
    @DisplayName("{1, 1, 1, 1, 1}, 3 → 5")
    void t01() {
        assertThat(
                new Solution().solution(new int[]{1, 1, 1, 1, 1}, 3)
        ).isEqualTo(
                5
        );
    }
}