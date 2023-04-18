package org.example.lv2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Tests {

    @Test
    @DisplayName("교점구하기 [[1, -1, 0], [2, -1, 0]]")
    void t01() {
        assertThat(new Solution()
                .intersection(
                        new int[]{1, -1, 0},
                        new int[]{2, -1, 0}))
                .isEqualTo(Point.of(0, 0))
        ;
    }

    @Test
    @DisplayName("교점구하기 [[1, -1, 0], [4, -1, 0]]")
    void t01_2() {
        assertThat(new Solution()
                .intersection(
                        new int[]{1, -1, 0},
                        new int[]{4, -1, 0}))
                .isEqualTo(Point.of(0, 0))
        ;
    }

    @Test
    @DisplayName("교점구하기 [[2, -1, 0], [4, -1, 0]]")
    void t01_3() {
        assertThat(new Solution()
                .intersection(
                        new int[]{2, -1, 0},
                        new int[]{4, -1, 0}))
                .isEqualTo(Point.of(0, 0))
        ;
    }

    @Test
    @DisplayName("교점구하기 [[0, 1, -1], [1, 0, -1]]")
    void t01_4() {
        assertThat(new Solution()
                .intersection(
                        new int[]{0, 1, -1},
                        new int[]{1, 0, -1}))
                .isEqualTo(Point.of(1, 1))
        ;
    }

    @Test
    @DisplayName("교점구하기 [[0, 1, -1], [1, 0, 1]]")
    void t01_5() {
        assertThat(new Solution()
                .intersection(
                        new int[]{0, 1, -1},
                        new int[]{1, 0, 1}))
                .isEqualTo(Point.of(-1, 1))
        ;
    }

    @Test
    @DisplayName("교점 전부 구하기 [[1, -1, 0], [2, -1, 0]]")
    void t02() {
        assertThat(new Solution()
                .intersections(
                        new int[][]{{0, 1, -1}, {1, 0, 1}}))
                .isEqualTo(Set.of(Point.of(-1, 1)))
        ;
    }

    @Test
    @DisplayName("교점 전부 구하기 [[0, 1, -1], [1, 0, -1], [1, 0, 1]]")
    void t02_2() {
        assertThat(new Solution()
                .intersections(
                        new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}}))
                .isEqualTo(Set.of(Point.of(1, 1), Point.of(-1, 1)))
        ;
    }

    @Test
    @DisplayName("교점 전부 구하기 [[1, -1, 0], [2, -1, 0], [4, -1, 0]]")
    void t02_3() {
        assertThat(new Solution()
                .intersections(
                        new int[][]{{1, -1, 0}, {2, -1, 0}, {4, -1, 0}}))
                .isEqualTo(Set.of(Point.of(0, 0)))
        ;
    }

    @Test
    @DisplayName("교점 전부 구하기 [[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]")
    void t02_4() {
        assertThat(new Solution()
                .intersections(
                        new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}}))
                .isEqualTo(Set.of(Point.of(4, 1), Point.of(4, -4), Point.of(-4, -4), Point.of(-4, 1), Point.of(0, 4)))
        ;
    }

    @Test
    @DisplayName("minPoint [Point.of(1, 1), Point.of(-1, 1)]")
    void t03() {
        assertThat(new Solution()
                .getMinPoint(
                        Set.of(Point.of(1, 1), Point.of(-1, 1)))
        )
                .isEqualTo(Point.of(-1, 1)
                );
    }

    @Test
    @DisplayName("minPoint [Point.of(-5, 1), Point.of(-1, -7)]")
    void t03_2() {
        assertThat(new Solution()
                .getMinPoint(
                        Set.of(Point.of(-5, 1), Point.of(-1, -7)))
        )
                .isEqualTo(Point.of(-5, -7)
                );
    }

    @Test
    @DisplayName("maxPoint [Point.of(1, 1), Point.of(-1, 1)]")
    void t04() {
        assertThat(new Solution()
                .getMaxPoint(
                        Set.of(Point.of(1, 1), Point.of(-1, 1)))
        )
                .isEqualTo(Point.of(1, 1)
                );
    }

    @Test
    @DisplayName("maxPoint [Point.of(4, 1), Point.of(-1, 6)]")
    void t04_2() {
        assertThat(new Solution()
                .getMaxPoint(
                        Set.of(Point.of(4, 1), Point.of(-1, 6)))
        )
                .isEqualTo(Point.of(4, 6)
                );
    }

    @Test
    @DisplayName("maxPoint [Point.of(4, 1), Point.of(-1, 6)]")
    void t05() {
        assertThat(new Solution()
                .emptyMatrix(
                        Set.of(Point.of(1, 1), Point.of(-1, 1)))
        )
                .isEqualTo(
                        new char[][]{{'.', '.', '.'}}
                );
    }

    @Test
    @DisplayName("emptyMatrix, [Point.of(4, -7), Point.of(-1, 6)]")
    void t05_2() {
        assertThat(new Solution()
                .emptyMatrix(Set.of(Point.of(4, -7), Point.of(-1, 6)))
        )
                .isEqualTo(
                        new char[][]{
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'}}
                );
    }

    @Test
    @DisplayName("positivePoints [Point.of(4, 1), Point.of(-1, 6)]")
    void t06() {
        assertThat(new Solution()
                .positivePoints(
                        Set.of(Point.of(1, 1), Point.of(-1, 1)))
        )
                .isEqualTo(
                        Set.of(Point.of(2, 0), Point.of(0, 0))
                );
    }

    @Test
    @DisplayName("positivePoints [Point.of(4, -7), Point.of(-1, 6)]")
    void t06_2() {
        assertThat(new Solution()
                .positivePoints(
                        Set.of(Point.of(4, -7), Point.of(-1, 6)))
        )
                .isEqualTo(
                        Set.of(Point.of(5, 0), Point.of(0, 13))
                );
    }

    @Test
    @DisplayName("transformToMatrix, [Point.of(1, 1), Point.of(-1, 1)]")
    void t07() {
        assertThat(
                new Solution().transformToMatrix(Set.of(Point.of(1, 1), Point.of(-1, 1)))
        ).isEqualTo(
                new char[][]{
                        {'*', '.', '*'}
                }
        );
    }

    @Test
    @DisplayName("transformToMatrix, [Point.of(4, -7), Point.of(-1, 6)]")
    void t07_2() {
        assertThat(
                new Solution().transformToMatrix(Set.of(Point.of(4, -7), Point.of(-1, 6)))
        ).isEqualTo(
                new char[][]{
                        {'.', '.', '.', '.', '.', '*'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'*', '.', '.', '.', '.', '.'}
                }
        );
    }

    @Test
    @DisplayName("drawOnCoordinate, 1st")
    void t08() {
        assertThat(
                new Solution().drawOnCoordinate(
                        new char[][]{
                                {'*', '.'},
                                {'.', '*'},
                        }
                )
        ).isEqualTo(
                new String[]{
                        ".*",
                        "*."
                }
        );
    }

    @Test
    @DisplayName("drawOnCoordinate, 2nd")
    void t08_2() {
        assertThat(
                new Solution().drawOnCoordinate(
                        new char[][]{
                                {'.', '.', '.', '.', '.', '*'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.'},
                                {'*', '.', '.', '.', '.', '.'}
                        }
                )
        ).isEqualTo(
                new String[]{
                        "*.....",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        "......",
                        ".....*"
                }
        );
    }
}
