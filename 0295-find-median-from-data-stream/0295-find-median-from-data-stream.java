class MedianFinder {
   private PriorityQueue<Integer> maxheap;
   private PriorityQueue<Integer> minheap;
    public MedianFinder() {
         maxheap=new PriorityQueue<>(Collections.reverseOrder());
        minheap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxheap.isEmpty()||num<=maxheap.peek()){
            maxheap.offer(num);
        }
        else {
            minheap.offer(num);
        }
        if(maxheap.size()>minheap.size()+1){
            minheap.offer(maxheap.poll());
        }
        else if(minheap.size()>maxheap.size()){
            maxheap.offer(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size()==minheap.size()){ return (maxheap.peek() + minheap.peek())/2.0; } 
        else{ return maxheap.peek(); }
       
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */