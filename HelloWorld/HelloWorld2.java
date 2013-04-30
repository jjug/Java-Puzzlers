import java.io.IOException;
import java.io.OutputStreamWriter;

public class HelloWorld2 {
    public static void main(String... args) {
        try (OutputStreamWriter sw = new OutputStreamWriter(System.out)) {
            sw.write("Hello");
            sw.close();
            sw.write("Duke");
        } catch (IOException e) {
            System.out.println("Java");
        } finally {
            System.out.println("World");
        }
    }
}

/*
 * 実行するとどうなるでしょうか?
 * (1) Hello
 * (2) JavaWorld
 * (3) HellWorld
 * (4) HelloJavaWorld
 */
