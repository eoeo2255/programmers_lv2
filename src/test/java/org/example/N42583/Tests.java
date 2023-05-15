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

}
