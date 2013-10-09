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
 * フィールドはオーバライドせずに、親クラスの情報を引き継ぎます
 * 
 * 教訓：
 * フィールドは隠蔽し直接アクセスできないようにしてください。
 * 特に、親子で同一名のフィールド名を持つ場合は注意
*/
