public class DualPersonality {
    private int count = 0;
    
    public DualPersonality() {
        Runnable task = () -> {
            System.out.print(count+ " ");
            if (count < 5) {
                run();
            }
            count++;
        };
        task.run();
    }
    
    private static void run() { System.out.println("RUN "); }
    
    public static void main(String... args) { new DualPersonality(); }
}

/*
選択肢
1) 0 1 2 3 4
2) 0 RUN
3) RUN
4) RUN RUN RUN RUN RUN
 */
