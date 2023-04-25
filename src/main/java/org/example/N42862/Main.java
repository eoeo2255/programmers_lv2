package org.example.N42862;

import java.util.HashSet;
import java.util.Set;

public class Main {
}

class Solution {

    private int borrowCount;
    private Set<Integer> borrowClothes = new HashSet<>();
    private Set<Integer> extraClothes = new HashSet<>();

    public int solution(int n, int[] lost, int[] reserve) {
        borrowSuccess(lost, reserve);
        return (n - lost.length) + borrowCount;
    }

    public int borrowSuccess(int[] lost, int[] reserve) {

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (canIReserve(lost[i], reserve[j])) {
                    duplication(lost[i], reserve[j]);
                }
            }
        }
        return borrowCount;
    }

    public boolean canIReserve(int lost, int reserve) {
        if (lost > reserve-2 && lost < reserve+2) {
            return true;
        }
        return false;
    }

    public int duplication(int lost, int reserve) {
        borrowClothes.add(lost);
        extraClothes.add(reserve);

        if (borrowClothes.size() == extraClothes.size()) {
            borrowCount = extraClothes.size();
        } else if (borrowClothes.size() < extraClothes.size()) {
            borrowCount = borrowClothes.size();
        } else if (borrowClothes.size() > extraClothes.size()) {
            borrowCount = extraClothes.size();
        }

        return borrowCount;
    }

}

