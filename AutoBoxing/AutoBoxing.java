
public class AutoBoxing {
    public static void main(String argv[]){
        Integer a1 = 10;
        int b1 = 10;
        Integer c1 = 10;
        System.out.print("a1 == b1 : " + (a1==b1));
        System.out.println("\ta1 == c1 : " + (a1==c1));

        Integer a2 = 129;
        int b2 = 129;
        Integer c2 = 129;
        System.out.print("a2 == b2 : " + (a2==b2));
        System.out.println("\ta2 == c2 : " + (a2==c2));
    }

    // なんと表示されるでしょう。
    // 1. a1 == b1 : true	a1 == c1 : true
    //    a2 == b2 : true	a2 == c2 : true (全部 true と思う人)

    // 2. a1 == b1 : false	a1 == c1 : true (オブジェクト参照の比較をしている人)
    //    a2 == b2 : false	a2 == c2 : true

    // 3. a1 == b1 : true	a1 == c1 : false (AutoBoxing は理解している人)
    //    a2 == b2 : true	a2 == c2 : false
    
    // 4. a1 == b1 : true	a1 == c1 : true (正解)
    //    a2 == b2 : true	a2 == c2 : false

    // http://docs.oracle.com/javase/specs/jls/se7/html/jls-5.html#jls-5.1.7
    // http://hg.openjdk.java.net/jdk7/jdk7/jdk/diff/4c3f752993a5/src/share/classes/java/lang/Integer.java
    
    // プリミティブとオブジェクトの比較は、プリミティブで計算し比較
    // オブジェクトとオブジェクトの比較は、オブジェクトの参照で比較
    // この場合 3 の答えが正しいように思える。
    // しかし、Java.lang.Integer は-128 から 127 の値の範囲で、
    // オートボキシングするオブジェクト IDの値をキャッシュしており、
    // その比較を実施している。その為、答えは 4
    
    // 教訓
    // オートボクシングを使えるようになって便利にはなっているが、
    // 比較においては、primitive と Object で比較をするのは良く無い。
    // どちらかの型に変換して比較してください。

    private String removeWhiteSpaceCRLF(String value){
        return value.replaceAll(System.lineSeparator(),"").replaceAll(" ","");
        //return value.replaceAll("\\s+", "");  <-- こちらの方がベター 
        // Unix 系 OS を上で作られたファイルを Windows 環境で読み込んだ場合 
        // System.lineSeparator は \n となり、Unix で作成されら文字列の \r が取れない。
        // また、replaceAll の第一引数は、対象の文字列を指定するのではなく、正規表現である。
    }
    // 質問：
    // 1. 改行と空白が全て取れる
    // 2. 空白が全て取れる
    // 3. コンパイルエラー
    // 4. 上記以外 <---答え（環境依存）

}
