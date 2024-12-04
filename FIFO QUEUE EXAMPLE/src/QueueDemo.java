public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.print("Queue: ");
        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.print("Queue after dequeue: ");
        queue.display();

        System.out.println("Front element: " + queue.peek());
    }
}