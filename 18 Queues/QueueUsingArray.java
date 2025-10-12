public class QueueUsingArray {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;

        Queue(int n){
            arr = new int[n];
            this.size = n;
            this.rear = -1;
        }

        public static boolean isEmpty(){
            return rear == -1;
        }

        public static void add(int data){
            if(rear == size -1){
                System.out.println("Queue is full.");
                return;
            }

            rear = rear +1;
            arr[rear] = data;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty, cannot remove.");
                return -1;
            }
            int front = arr[0];

            for(int i=0; i<rear; i++){
                arr[i] = arr[i+1];
            }
            rear = rear -1;

            return front;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty, cannot remove.");
                return -1;
            }
            int front = arr[0];
            return front;
        }
    }

    public static void main(String args[]){
        Queue queue = new Queue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();
        }
    }    
}
