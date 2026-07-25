interface Remote {

    void turnOn();

    void turnOff();
}

class TV implements Remote {

    public void turnOn() {
        System.out.println("TV ON");
    }

    public void turnOff() {
        System.out.println("TV OFF");
    }
}

public class InterfaceDemo {

    public static void main(String[] args) {

        Remote r = new TV();

        r.turnOn();
        r.turnOff();
    }
}