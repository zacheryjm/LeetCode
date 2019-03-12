class MovingAverage {

    double total;
    Queue<Integer> queue;
    int maxSize;
    int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.total = 0.0;
        this.size = 0;
        this.maxSize = size;
        this.queue = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if(size < maxSize) {
            queue.add(val);
            total += val;
            size++;
        }
        else {
            int valToRemove = queue.poll();
            total -= valToRemove;
            
            queue.add(val);
            total += val;
        }
        
        return total / size;
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */