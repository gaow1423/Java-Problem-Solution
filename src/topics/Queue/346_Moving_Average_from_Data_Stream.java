/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/

class MovingAverage {
    private double prevsum = 0.0;
    private int maxsize;
    private Queue <Integer> currentwindow;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        currentwindow = new LinkedList <Integer> ();
        maxsize = size;
    }
    public double next(int val) {
        if(currentwindow.size() == maxsize){
            prevsum -= currentwindow.remove();
        }
        prevsum += val;
        currentwindow.add(val);
        return prevsum/currentwindow.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */