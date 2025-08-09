package TransformStringDemo;

import java.util.List;
import java.util.function.Function;

class Main{
    public static void main(String[] args){
        List<String> names= List.of("alice","bob","charlie");
        Function<String,String> reverseString = str->new StringBuilder(str).reverse().toString();
        TransfromCollections<String> upperCaseNames=
                new TransfromCollections<>(names,reverseString);
//                new TransfromCollections<>(names,String::toUpperCase);
        for(String name:upperCaseNames){
            System.out.println(name);
        }
    }
}
