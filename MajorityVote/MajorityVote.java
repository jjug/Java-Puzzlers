
import java.util.Random;

public class MajorityVote {
    public static void main(String... args) {
        Random[] randoms = new Random[10];
        for (int i = 0; i < 10; i++)
            randoms[i] = new Random(System.currentTimeMillis());

        int count = 0;
        boolean option = randoms[0].nextBoolean();
        for (int i = 1; i < 10; i++)
            if (option == randoms[i].nextBoolean()) count++;

        System.out.println((count > 5)? "YES": "NO");
    }
}

// a) YES
// b) NO
// c) 場合による
// d) throw Exception