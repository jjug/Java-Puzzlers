public class WaltzRhythm {
    public static void main(String... args) {
        int count = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i += 3) {
            count++;
        }

        System.out.println(count);
    }
}

// a) 715827882 (= Integer.MAX_VALUE/3)
// b) 715827883 (= Integer.MAX_VALUE/3 + 1)
// c) 無限ループ
// d) それ以外