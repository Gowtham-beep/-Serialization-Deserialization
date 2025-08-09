# Java Concepts Practice & Mini Project

This repository contains examples and a mini project covering several important **Java core concepts**:
- Serialization & Deserialization
- Custom serialization with `readObject` and `writeObject`
- InputStream / OutputStream hierarchy
- Thread pools and concurrency with `ExecutorService`
- Collections, Iterators, Generics (Custom Iterable implementation)

---

## 1. Serialization & Deserialization Basics

### What is Serialization?
Serialization is the process of converting an object into a byte stream so it can be:
- Saved to a file
- Sent over a network
- Stored in a database as bytes

**Key interface:** `java.io.Serializable` (marker interface — no methods)

### What is Deserialization?
Deserialization is the reverse — converting a byte stream back into a Java object.

**Basic Example:**
```java
import java.io.*;

class Person implements Serializable {
    int age;
    String name;
    Person(int age, String name) { this.age = age; this.name = name; }
}

public class SerializationDemo {
    public static void main(String[] args) throws Exception {
        Person p = new Person(30, "Alice");

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(p);
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person p2 = (Person) ois.readObject();
            System.out.println("Deserialized: " + p2.name + ", " + p2.age);
        }
    }
}
