package org.example.N42583;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Bridge bridge = new Bridge(bridge_length, weight);
        List<Truck> trucks = makeTrucks(bridge, truck_weights);

        // 모든 트럭이 통과할 때까지 반복
        while (!trucks.stream().allMatch(Truck::isPassed)) {
            bridge.increaseSeconds();               // 초 증가
            trucks.forEach(Truck::tick);        // 모든 트럭이 초 증가에 따른 행동을 하도록
        }

        return bridge.getSeconds();
    }

    private List<Truck> makeTrucks(Bridge bridge, int[] truck_weights) {
        List<Truck> trucks = new ArrayList<>();

        Truck oldTruck = null;

        for (int truck_weight : truck_weights) {
            Truck truck = new Truck(bridge, truck_weight, oldTruck);
            trucks.add(truck);
            oldTruck = truck;
        }

        return trucks;
    }

}

class Bridge {
    private final int length;
    private final int allowableWeight;      // 다리가 버틸 수 있는 최대 무게
    private int truckWeight = 0;            //  트럭들의 무게
    private int seconds = 0;

    public Bridge(int length, int allowableWeight) {
        this.length = length;
        this.allowableWeight = allowableWeight;
    }

    public void increaseSeconds() {
        seconds++;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getLength() {
        return length;
    }

    public void increaseTruckWeight(int weight) {           //  다리에 올라온 트럭의 무게 더하기
        truckWeight += weight;
    }

    public void decreaseTruckWeight(int weight) {       //  다리를 통과한 트럭의 무게 빼주기
        truckWeight -= weight;
    }

    public int getAllowableWeight() {
        return allowableWeight;
    }

    public int getTruckWeight() {
        return truckWeight;
    }
}

class Truck {
    private final int weight;       //  이 트럭의 무게
    private final Bridge bridge;
    private int seconds = 0;                // 트럭이 다리에 올라오고 나서 경과한 시간
    private boolean started = false;            //  트럭이 다리에 올라갔는지 여부
    private final Truck prev;                   //  내 앞의 트럭

    public Truck(Bridge bridge, int weight, Truck prev) {
        this.bridge = bridge;
        this.weight = weight;
        this.prev = prev;
    }

    public boolean isPassed() {
        if (!started) return false;
        return seconds == bridge.getLength() + 1;
    }

    public void tick() {            //  매 초마다 수행해야 하는 일을 처리
        if (isPassed()) return;

        if (isTurnToStart()) {              //  다리에 올라갈 차례인지 확인
            started = true;
            bridge.increaseTruckWeight(weight);
        }

        if (started) {                          //  다리에 올라갔다면 시간이 증가
            seconds++;

            if (seconds == bridge.getLength() + 1) {            //  다리를 통과했다면 즉 패스처리
                bridge.decreaseTruckWeight(weight);         //  통과한 트럭의 무게 빼기
            }
        }
    }

    private boolean isTurnToStart() {
        if (isWaitingNumberZero() && canIIn()) {
            return true;
        }

        return false;
    }

    private boolean canIIn() {
        return bridge.getAllowableWeight() >= bridge.getTruckWeight() + weight;     //  다리가 버틸 수 있는 최대 무게에 트럭의 무게만큼 여유가 있으면 올라감
    }

    private boolean isWaitingNumberZero() {             //  기다리는 트럭이 없을 경우
        if (started) return false;
        return prev == null || (prev.started && prev.seconds > 1);
    }
}