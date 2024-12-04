public class ArrayQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = rear = size = 0;
    }

    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue is full.");
            return;
        }
        queue[rear] = value;
        rear = (rear + 1) % capacity;  // Wrap around using modulo
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int value = queue[front];
        front = (front + 1) % capacity;  // Wrap around using modulo
        size--;
        return value;
    }


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue()); // 10
        queue.enqueue(40);
        System.out.println("Dequeued: " + queue.dequeue()); // 20
    }

    public static class ArrayExample {
        public static void main(String[] args) {

            int[] array = {10, 20, 30, 40, 50};

            System.out.println( array[2]);
        }
    }
}
