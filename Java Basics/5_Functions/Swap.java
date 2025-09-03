public class Swap {
    public static void Swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;

        System.out.println("A: " + a);
        System.out.print("B: " + b);
    }

    public static void main(String args[]){
        Swap(1,2);
    }
}
