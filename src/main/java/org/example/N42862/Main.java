package org.example.N42862;

public class Main {
}

class Solution {

    private int borrow;

    public int solution(int n, int[] lost, int[] reserve) {
        canIReserve(lost, reserve);
        return (n - lost.length) + borrow;
    }

    public int canIReserve(int[] lost, int[] reserve) {
        borrow = 0;

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {

                if (lost[i] > reserve[j]-2 && lost[i] < reserve[j]+2)
                    borrow++;
                }
            }
        return borrow;
    }

}

