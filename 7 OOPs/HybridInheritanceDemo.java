interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class AllInOnePrinter implements Printer, Scanner {
    public void print() {
        System.out.println("Printing...");
    }

    public void scan() {
        System.out.println("Scanning...");
    }
}

public class HybridInheritanceDemo {
    public static void main(String[] args) {

        AllInOnePrinter obj = new AllInOnePrinter();

        obj.print();
        obj.scan();
    }
}