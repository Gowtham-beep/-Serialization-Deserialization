package Serilaize;

import java.io.*; // ✅ This brings in java.io.Serializable, ObjectOutputStream, etc.

class Person implements Serializable { // Now it finds the correct interface
    int age;
    String name;

    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Person p = new Person(30, "Alice");

        // Serialize
        FileOutputStream fos = new FileOutputStream("person.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p);
        oos.close();
        fos.close();

        // Deserialize
        FileInputStream fis = new FileInputStream("person.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person p2 = (Person) ois.readObject();
        ois.close();
        fis.close();

        System.out.println("Deserialized person: " + p2.name + ", " + p2.age);
    }
}
