class Student {
    private int age;
    private String name;

    // Setter Methods
    public void setAge(int age) {
        if(age > 0) {
            this.age = age;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter Methods
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {

        Student s = new Student();

        s.setName("Khan Shoaib");
        s.setAge(20);

        System.out.println("Name : " + s.getName());
        System.out.println("Age : " + s.getAge());

        // s.age = 25; ❌ Not Allowed
    }
}