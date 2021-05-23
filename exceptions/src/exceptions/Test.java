package exceptions;

import java.io.IOException;
import java.io.StringReader;

public class Test {
    public static void main(String[] args) {
        Object o = null;
       // o.equals(new Object());
        StringReader reader = new StringReader("");
         
        try{
            reader.read();  
        } catch (IOException ioException){
            ioException.getMessage();
        }

    }
}