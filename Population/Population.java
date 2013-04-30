import java.util.HashMap;
import java.util.Map;

public class Population {
    public static void main(String... args) {
        Map<String, Integer> population2011 = new HashMap<>();
        Map<String, Integer> population2012 = new HashMap<>();

        population2011.put("世田谷区", 835_819); population2012.put("世田谷区", 831_654);
        population2011.put("練馬区", 693_368); population2012.put("練馬区", 692_450);
        population2011.put("大田区", 674_920); population2012.put("大田区", 674_527);
        population2011.put("江戸川区", 654_537); population2012.put("江戸川区", 651_884);
        population2011.put("足立区", 644_448); population2012.put("足立区", 641_888);
        population2011.put("杉並区", 527_133); population2012.put("杉並区", 527_158);
        population2011.put("板橋区", 517_404); population2012.put("板橋区", 518_116);
        population2011.put("江東区", 450_950); population2012.put("江東区", 446_393);
        population2011.put("葛飾区", 435_253); population2012.put("葛󠄁飾区", 431_796);
        population2011.put("品川区", 351_350); population2012.put("品川区", 348_590);

        int min = Integer.MAX_VALUE, max = 0;
        for (String ku : population2011.keySet()) {
            int change = Math.abs(population2012.get(ku) - population2011.get(ku));
            if (change < min) min = change;
            if (max < change) max = change;
        }
        System.out.println("min = " + min + ", max = " + max);
    }
}
