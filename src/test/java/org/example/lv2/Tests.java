package org.example.lv2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests {

    @Test
    @DisplayName("교점구하기 [[1, -1, 0], [2, -1, 0]]")
    void t1() {
        assertThat(new Solution()
                .intersection(
                        new int[]{1, -1, 0},
                        new int[]{2, -1, 0}))
                .isEqualTo(new int[] {0,0})
        ;
    }

}
