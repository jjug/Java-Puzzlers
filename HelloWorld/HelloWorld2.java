import java.io.IOException;
import java.io.OutputStreamWriter;

public class HelloWorld2 {
    public static void main(String... args) {
        try (OutputStreamWriter sw = new OutputStreamWriter(System.out)) {
            sw.write("Hello");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("World");
        }
    }
}

/*
 * 実行するとどうなるでしょうか?
 * (1) Hello
 * (2) World
 * (3) HelloWorld
 * (4) java.io.IOExceptionが発生する
 */
