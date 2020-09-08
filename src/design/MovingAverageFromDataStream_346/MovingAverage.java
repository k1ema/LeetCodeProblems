package design.MovingAverageFromDataStream_346;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 346. Moving Average from Data Stream
 * https://leetcode.com/problems/moving-average-from-data-stream/
 *
 * Given a stream of integers and a window size, calculate the moving average of all
 * integers in the sliding window.
 *
 * Example:
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverage {
    // tc O(1), sc O(size)
    private final Deque<Integer> queue;
    private final int size;
    private int currSum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new ArrayDeque<>(size);
        currSum = 0;
    }

    public double next(int val) {
        currSum += val;
        if (queue.size() == size) {
            currSum -= queue.poll();
        }
        queue.add(val);
        return currSum * 1d / queue.size();
    }
}
