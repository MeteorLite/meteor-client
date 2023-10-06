import java.io.*;
import javax.sound.sampled.*;

public class Play {
    public static void main(String[] args) {
        class MyLineListener implements LineListener {
            public void update(LineEvent le) {
                LineEvent.Type type = le.getType();
                System.out.println(type);
            }
        }

        try {

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}