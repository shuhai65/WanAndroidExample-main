package com.zoe.wan.android.example;

import java.util.Stack;

class Solution {
    static class Pair<T,I>{
        T first;
        I second;
        public Pair(T first, I second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public I getSecond() {
            return second;
        }
    }

    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] answer = new int[m][n];
        int[] max = new int[n];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = matrix[i][j];
                max[j] = Math.max(max[j], answer[i][j]);
                if (answer[i][j] == -1) {
                    stack.push(new Pair<>(i, j));
                }
            }
        }
        while (!stack.empty()) {
            Pair<Integer, Integer> pop = stack.pop();
            answer[pop.getFirst()][pop.getSecond()] = max[pop.getSecond()];
        }
        return answer;
    }
}