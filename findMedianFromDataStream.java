import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((a,b)-> (-1 * a.compareTo(b)));
        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(this.minHeap.size() == 0 || this.minHeap.size() <= this.maxHeap.size()){
            this.minHeap.add(num);
        } else{
            this.maxHeap.add(num);
        }
        rebalance();
    }

    private void rebalance(){
        if(this.minHeap.size() - this.maxHeap.size() > 1){
            this.maxHeap.add(this.minHeap.poll());
        } else if (this.maxHeap.size() - this.minHeap.size() > 1){
            this.minHeap.add(this.maxHeap.poll());
        }
    }

    public double findMedian() {
        if(this.maxHeap.size() > this.minHeap.size()){
            return this.maxHeap.peek();
        } else if (this.maxHeap.size() < this.minHeap.size()){
            return this.minHeap.peek();
        } else {
            return ((double)this.minHeap.peek() + this.maxHeap.peek())/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */