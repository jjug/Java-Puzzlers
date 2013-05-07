
public class Test {

    public static void main(String[] argv) {
        System.out.println(12_345_678 + 87_654_32l);
        System.out.println(01_234_567 + 76_543_210);
    }
}

/*
 * 実行すると何が表示される？
 * (1) 99999999 76885601
 * (2) 99999999 77777777
 * (3) 21111110 76885601
 * (4) 21111110 77777777
 * (5) コンパイルエラー
 */