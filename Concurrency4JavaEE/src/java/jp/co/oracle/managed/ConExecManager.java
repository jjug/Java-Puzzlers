package jp.co.oracle.managed;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "conExecManager")
@RequestScoped
public class ConExecManager {
    @Resource(mappedName = "hogehoge")
    ManagedExecutorService execService;

    public String executeButton()  {
        Runnable task = new Runnable() {
            public void run() {
                for (int i = 0; i < 60; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ;
                    }
                    System.out.println("COUNTER : " + i);
                }
            }
        };
        execService.execute(task);
        execService.shutdown();
        return "";
    }
}

/*
 * 
 * 上記のコードを実行するとどのような結果になるでしょう？

**************************************************************
1. javax.naming.NamingException: Lookup failed が発生 
    (@Resource の指定が無い事に気づく人)
2. 60 秒間 "COUNTER : + i"が出力された後タスクは終了する。
    （<--Concurrent を分かっていない人の回答）
3. タスクを実行した直後に、タスク全体が終了する。
    (<-- Java SE の Concurrentは知っている人)
4. ランタイムエラーが発生
**************************************************************

答え：4
タスクは継続しますが、execService.shutdown() の実行の所で、
java.lang.IllegalStateException: Lifecycle operation not supported
が発生します。
Java SE の環境では、shutdown() 等を呼び出す事ができますが、
Java EE の環境では、shtdown(), shutdownNow() 等のライフサイクルを
管理するメソッドの実行は禁止されています。

1 の、@Resource に JNDI 名の指定がありませんが、Java EE 7 からデフォルトの
リソースがサーバ側で設定されていますので、デフォルトを使用する場合、JNDI
名を
指定しなくてもいい事になっています。

2. execService.execute(task) でタスクが実行された後、すぐに処理は
execService.shutdown()
に移動しますので、2 番はありえません。

3. shutdown が実行されるかどうかですが、shutdown は実行されず、例外が発
生しますので、
3 番でもありません。

教訓：Java EE 環境で並列処理を実装する際には、shutdown, shutdownNow 等の
ライフサイクルのメソッドは実行しないでください。
 * 
 */