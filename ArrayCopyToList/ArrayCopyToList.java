import java.util.List;
import java.util.Arrays;

public class ArrayCopyToList {

    public static void main(String argv[]) {
        String[] strArray = {"1", "2", "3"};
        List<String> strList = Arrays.asList(strArray);
        strList.add("4");
        for(String data : strList){
            System.out.print(data);
        }
    }   
}

/*
 * なんと表示されるでしょう。
 * 
 * 1. 123
 * 2. 1234
 * 3. コンパイル・エラー
 * 4. java.lang.UnsupportedOperationException が送出
 * 
 * 答え：4
 * 
 * この問題は、既存にオブジェクト配列が存在している状態で、
 * オブジェクト配列に要素を追加したい場合どのように実装するかを問う問題
 * 
 * 1. はありえない。
 * 2  は一見正しそう
 * 3. 拡張 for 文を理解していないか、コードに問題があると思う方。
 * 4. 正解
 * 
 * Arrays.asList は固定サイズのリストを作成します。
 * つまり、可変のリストを作成したい場合は、下記のようにして固定サイズ
 * のリストをコピーした新しいリストを作成します。
 * 
 * List<String> strList = new ArrayList<>(Arrays.asList(strArray));
 * 
 * public static <T> List<T> asList(T... a)
 * 指定された配列に連動する固定サイズのリストを返します。返されたリストへの変更は、
 * そのまま配列に書き込まれます。このメソッドは、Collection.toArray() と組み合わせることで、
 * 配列ベースの API とコレクションベースの API の橋渡し役として機能します。
 * また、返されるリストは直列化可能で、RandomAccess を実装します。
 * このメソッドは、次の数種類の要素を含むように初期化する固定サイズのリストを
 * 作成するための便利な方法も提供します。
 * 
 * List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
 * 
 * 教訓：
 * Arrays クラスは便利なユーティリティクラスですが、asList は固定サイズのリストを生成します。
 * もし、可変のリストを作成したい場合は、固定サイズのリストより新たな可変リストを生成します。
 */

