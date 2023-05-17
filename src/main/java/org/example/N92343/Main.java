package org.example.N92343;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
}

class Solution {
    public int solution(int[] info, int[][] edges) {
        return 3;
    }
}

class PathCalculator {
    private final int[] info;
    private final int[][] edges;
    private final boolean[][] tree;

    public PathCalculator(int[] info, int[][] edges) {
        this.info = info;
        this.edges = edges;

        tree = new boolean[info.length][info.length];

        for (int[] edge : edges) {
            tree[edge[0]][edge[1]] = true;
            tree[edge[1]][edge[0]] = true;
        }
    }

    public List<Integer> getNextNodes(int currentNode) {       // 특정 노드에서, 이동할 수 있는 인접 노드들의 번호를 리턴
        List<Integer> nextNodes = new ArrayList<>();

        for (int i = 0; i < tree[currentNode].length; i++) {
            if (tree[currentNode][i]) {
                nextNodes.add(i);
            }
        }

        return nextNodes;
    }

    public List<Integer> getNextNodes(int currentNode, List<Integer> history) {
        return getNextNodes(currentNode, history, new ArrayList<>());
    }

    public List<Integer> getNextNodes(int currentNode, List<Integer> history, List<Integer> prevent) {          // 이미 방문한 곳은 지나친다.
        prevent.add(currentNode);                       //  이미 방문한 노드

        List<Integer> nextNodes = new ArrayList<>();        // 최종 데이터를 담을 List

        List<Integer> _nextNodes = getNextNodes(currentNode);   // 현재 노드 기준으로 이동할 수 있는 노드들을 구한다.

        for (int nextNode : _nextNodes) {
            if (prevent.contains(nextNode)) {                  // 이미 탐색한 곳이면 패스
                continue;
            }

            if (history.contains(nextNode)) {
                nextNodes.addAll(getNextNodes(nextNode, history, prevent));   // 이미 방문한 곳이면 그곳을 기준으로 새로 탐색
            } else {
                nextNodes.add(nextNode);           // 방문할 리스트에 추가
            }
        }

        return nextNodes;
    }


    public Path wholePath() {
        Path path = new Path(null, 0);

        for (int nextNode : getNextNodes(0)) {
            findPath(path, nextNode);
        }

        return path;
    }

    private void findPath(Path parentPath, int node) {
        Path path = parentPath.addChildPath(node);

        for (int nextNode : getNextNodes(node, path.history())) {
            findPath(path, nextNode);
        }
    }
}

class Path {
    private final int depth;
    private final int node;
    private final Path parentPath;
    private final List<Path> childPaths;


    Path(Path parentPath, int node) {
        this.parentPath = parentPath;
        this.depth = parentPath == null ? 0 : parentPath.depth + 1;
        this.node = node;
        this.childPaths = new ArrayList<>();
    }

    public Path addChildPath(int nextNode) {
        Path path = new Path(this, nextNode);
        childPaths.add(path);

        return path;
    }

    public List<Integer> history() {
        List<Integer> history = new ArrayList<>();

        Path path = this;

        while (path != null) {
            history.add(path.node);
            path = path.parentPath;
        }

        return history;
    }

    @Override
    public String toString() {
        return " ".repeat(depth) +  node + "\n" + childPaths.stream().map(Path::toString).collect(Collectors.joining("\n"));
    }
}