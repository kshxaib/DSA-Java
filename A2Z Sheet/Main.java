interface A{
    void show();
}

interface B extends A{

}

interface C extends A{

}

class D implements B, C{
    public void show(){
        System.out.println("Method Implemented in D");
    }
}

public class Main{
    public static void main(String[] args){
        D obj = new D();
        obj.show();
    }
}

