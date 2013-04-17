class Foo<T> {
    public void foo() { System.out.println("Foo"); }
}

public class WhosFoo {
    public static void bar1(Foo foo) { foo.foo(); }
    public static void bar2(Foo<?> foo) { foo.foo(); }
    public static void bar3(Foo<String> foo) { foo.foo(); }

    public static void main(String[] args) {
        bar1(new Foo<>());
        bar2(new Foo<>());
        bar3(new Foo<>());
    }
}

/*
 選択肢
 1) Foo Foo Foo
 2) Foo
 3) Warning:Test.javaの操作は、未チェックまたは安全ではありません。
 4) Compile Error
 */
