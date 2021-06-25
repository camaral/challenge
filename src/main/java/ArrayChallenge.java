import java.util.Arrays;

public class ArrayChallenge {

    public static int[] transform(int[] input) {
        int zeroIndex = -1;
        int acc = 1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 0) {
                if (zeroIndex != -1) {
                    // break: more than one zero = result is always zero
                    return new int[input.length];
                }
                zeroIndex = i;
            } else {
                acc *= input[i];
            }
        }
        if (zeroIndex != -1) {
            // break: all numbers are zero, but the zero index
            int[] zeroes = new int[input.length];
            zeroes[zeroIndex] = acc;
            return zeroes;
        }
        final int accFin = acc;
        return Arrays.stream(input).map((item) -> accFin / item).toArray();
    }
}
