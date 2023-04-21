package org.example.N42860;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests {

    @Test
    @DisplayName("문자열을 int[]로 바꾸기")
    void t01() {
        assertThat(new Solution()
                .changeToIntArray("ABC")
                .equals(new int[]{0,1,2}));
    }



}
