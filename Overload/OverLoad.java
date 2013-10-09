
import java.util.ArrayList;
import java.util.List;


public class OverLoad {

    public static void main(String argv[]){
        List<String> listStr = new ArrayList<>();
        List<Integer> listInt = new ArrayList<>();
        System.out.println(foo(listStr));
        System.out.println(foo(listInt));
    }

    static int foo(List<String> list) {
        return 0;
    }

    static long foo(List<Integer> list) {
        return 1;
    }

}
/*
 * 何が表示されますか？
 * 
 * 1. 0 , 1
 * 2. 1 , 0
 * 3. コンパイルエラー
 * 4. ランタイムエラー
 * 
 * この問題の趣旨：
 * Java SE 6 と Java SE 7 の非互換性リストより取り出した問題で
 * JDK 5, JDK 6 ではコンパイルが通りました。
 * しかし、JDK 7 ではコンパイルエラーとするように変更しました。
 * 
 * Javaのジェネリクスはコンパイル時に解決され、classファイルになった時には
 * ジェネリクスの型情報は残されていません。
 * そのためイレイジャ（型消去：type erasure）方式と呼ばれます。
 * 
 * ジェネリクスの型情報が消去される同一の型（ここでは List）を引数に持つ
 * メソッドは仮に、返り値の型が異なっていても定義できなくなりました。
 * これは、Java SE 7 対応の JLS(Java 言語仕様)の 8.4.8.3 の記載内容に従います。
 * 
 * JDK 6 までは、同じ erased のシグネチャを持つ、異なる返り値を持つメソッドの定義が可能でしたが、
 * この振る舞いは間違いで、JDK 7 で修正されました。
 * 
 * 教訓
 * Java SE 7 以降は、型が消去される(erasure)メソッド引数を持つメソッドを
 * たとえ返り値が異なっても定義できなくなりました。
 * 
 */
