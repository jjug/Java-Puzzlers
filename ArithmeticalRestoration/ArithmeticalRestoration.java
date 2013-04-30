public class ArithmeticalRestoration {
	public static void main(String... args) {
		int a = 1_234_567;
              //-----------------
		int c = 0_2___5_1;
		int b = 1__3___62;
		int d = 0___4___4;

		int e = a - (b + c + d);

		System.out.println(e);
	}
}

/*
 * 1) 0
 * 2) 1233000
 * 3) 1232910
 * 4) 341432
 */

