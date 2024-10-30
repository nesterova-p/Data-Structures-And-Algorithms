import java.util.Random;

public class Generators {

    public static Double[] createRandomData(int size) {
        assert size >= 0;

        Double[] nums = new Double[size];

        long eliteSeed = 31337;
        Random rand = new Random(eliteSeed);

        for (int i = 0; i < size; i++) {
            nums[i] = rand.nextDouble();
        }

        return nums;
    }

    public static Double[] createAscendingData(int size) {
        assert size >= 0;

        Double[] nums = new Double[size];
        double start = 100_000_000;

        for (int i = 0; i < size; i++) {
            nums[i] = start + i;
        }

        return nums;
    }

    public static Double[] createDescendingData(int size) {
        assert size >= 0;

        Double[] nums = new Double[size];
        double start = 100_000_000;

        for (int i = size - 1; i >= 0; i--) {
            nums[i] = start + i;
        }

        return nums;
    }

    public static Integer[] createRandomIntegerData(int size) {
        assert size >= 0;

        Integer[] nums = new Integer[size];
        Random rand = new Random(31337);

        for (int i = 0; i < size; i++) {
            nums[i] = rand.nextInt();
        }

        return nums;
    }

    // For Strings of specified length
    public static String[] createRandomStringData(int size, int length) {
        assert size >= 0;

        String[] strs = new String[size];
        Random rand = new Random(31337);

        for (int i = 0; i < size; i++) {
            strs[i] = rand.ints(97, 123) // ASCII range for lowercase letters
                    .limit(length)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }

        return strs;
    }


}
