
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class WrapWrapWrap<T> {
    String wrap(Collection<?> objs) {
        String result = "";
        for (Object o: objs) result += o;
        return result;
    }
    
    int wrap(List<Integer> numbers) {
        int result = 0;
        for (int num: numbers) result += num;
        return result;
    }
    
    public static void main(String... args) {
        List<String> strings = Arrays.asList("1", "2", "3");
        System.out.println(new WrapWrapWrap().wrap(strings));
    }
}

// a) 6
// b) 123
// c) Compile Error
// d) throw Exception
