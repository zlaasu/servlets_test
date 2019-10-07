package pl.coderslab.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GenerateRandom {

    public static Map<Integer, Integer> checkRand(int amount, int interval) {
        Map<Integer, Integer> result = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            int key = random.nextInt(10);
            int value = result.get(key) == null ? 0 : result.get(key);
            result.put(key, ++value);
        }

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.printf("%d : %d", entry.getKey(), entry.getValue());
            System.out.println();
        }

        return result;
    }

}
