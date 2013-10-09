class Foo {
    String name = "親";
    String getSomething(){return "親の作業";}
}
class Bar extends Foo {
    String name = "子";
    @Override
    String getSomething(){return "子の作業";}
}
public class OverRide {
    public static void main(String argv[]){
        Foo instance = new Bar(); 
        System.out.println(instance.name + ":"+ instance.getSomething());
    }
}

/** 
 * 何が表示されるでしょう？
 * 
 * 1. 親：親の作業
 * 2. 子：子の作業
 * 3. 親：子の作業
 * 4. 子：親の作業
 * 
 * 答え：3 
 * フィールドはコンパイル時に値を解決し親クラスの情報を引き継ぎます。
 * メソッドは実行時に値を解決し上書きされたメソッドを呼び出します。
 * 仮にどうしても、子フィールドを参照したい場合は下記のように記述
 * する事もできますが、フィールドの参照は注意が必要です。
 * System.out.println(((Bar)instance).name + ":"+ instance.getSomething());
 * 
 * 教訓：
 * フィールドは隠蔽し直接アクセスできないようにしてください。
 * 特に、親子で同一名のフィールド名を持つ場合は注意
*/
