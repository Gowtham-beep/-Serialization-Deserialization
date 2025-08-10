package CustomReadWriteObject;

import java.io.*;
import java.util.Base64;

class User implements Serializable{
    private static final long serrialVersionUID = 1L;

    private String username;
    private transient String password;

    public User(String username, String password){
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
//    custom Serialization
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();
        String encrypted = Base64.getEncoder().encodeToString(password.getBytes());
        out.writeObject(encrypted);
    }
//    custom deserialization
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        String encrypted = (String) in.readObject();
        password = new String(Base64.getDecoder().decode(encrypted));
    }
    @Override
    public String toString(){
        return "User{username="+ username+", password="+password+"}";
    }
}

public class CustomSerializationDemo {
    public static void main(String[] args) throws Exception{
        User user = new User("Alice","Mysecret123");

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.ser"))){
            out.writeObject(user);
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.ser"))){
            User restoredUser = (User) in.readObject();
            System.out.println("Restored: "+ restoredUser);
        }
    }
}
