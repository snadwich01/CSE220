//YOU NEED TO ONLY WRITE THE FOLLOWING METHODS
// enqueueCall()
// dequeueCall()
// displayQueue()
// Inside of these methods you need to utilize the objects of LinkedListQueue class
// vipQueue and regularQueue objects are already created for you
class CallQueue {

    private LinkedListQueue vipQueue;
    // VIP queue
    private LinkedListQueue regularQueue;
    // Regular queue

    //DO NOT CHANGE THIS CONSTRUCTOR
    public CallQueue() {
        this.vipQueue = new LinkedListQueue();
        this.regularQueue = new LinkedListQueue();
    }

    // Adds a customer to the correct queue
    public void enqueueCall(int customerId, boolean isVip) {
        if (isVip) {
            vipQueue.enqueue(customerId);  // Add to VIP queue
        } else {
            regularQueue.enqueue(customerId);  // Add to Regular queue
        }
    }

    // Processes the next call (VIPs first, then regulars)
    public void dequeueCall() {
        if (!vipQueue.isEmpty()) {
            int served = vipQueue.dequeue();
            System.out.println("Serving VIP Customer: " + served);
        } else if (!regularQueue.isEmpty()) {
            int served = regularQueue.dequeue();
            System.out.println("Serving Regular Customer: " + served);
        } else {
            System.out.println("No customers in queue.");
        }
    }

    // Displays the current queue order (VIPs first, then regulars)
    public void displayQueue() {
        System.out.print("Current Queue (VIPs first): ");
        vipQueue.display();
        regularQueue.display();
    }

}
