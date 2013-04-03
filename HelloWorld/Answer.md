# 解答

(1) Hello

# 解説

System.out.close() によりPrintWriterが閉じられ以降の出力が発生しなくなります。System.out.println(“World”)の出力は内部的にはIOExceptionが発生しています。System.outはPrintWriterクラスですが、PrintWriterのメソッドは例外をスローしません。
IOExceptionはチェック例外なので、もしPrintWriterがIOExceptionをスローしてしまうと、プログラム中の様々な場所で

	try { System.out.println(“Hello”); } catch (IOException e) { } 

と書かなくてはならなくなってしまいますね。もし例外が発生していたか調べたい場合には PrintWriter#checkError() を使ってください。