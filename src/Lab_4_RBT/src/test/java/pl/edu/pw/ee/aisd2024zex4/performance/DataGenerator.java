package pl.edu.pw.ee.aisd2024zex4.performance;

import java.util.Random;
import java.util.stream.IntStream;

public class DataGenerator {

    private static final Random RANDOM = new Random();

    private static String generateRandomString(int length) {
        return RANDOM.ints('a', 'z' + 1)
                .limit(length)
                .mapToObj(c -> String.valueOf((char) c))
                .reduce("", (s1, s2) -> s1 + s2);
    }

    public String[] generateRandData(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> generateRandomString(8))
                .toArray(String[]::new);
    }

    public static String[] generateAscData(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> String.format("Item%08d", i))
                .toArray(String[]::new);
    }


    public static String[] generateDescData(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> String.format("Item%08d", size - i - 1))
                .toArray(String[]::new);
    }

}
