public class HelloWorld {
    public static void main(String... args) {
        System.out.print("Hello");
        System.out.close();
        System.out.println("World");
    }
}

/*
 * 実行するとどうなるでしょうか?
 * (1) Hello
 * (2) HelloWorld
 * (3) java.lang.SecurityExceptionが発生する
 * (4) java.io.IOExceptionが発生する
 */
