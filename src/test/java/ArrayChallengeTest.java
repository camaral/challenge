import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayChallengeTest {

    @ParameterizedTest
    @MethodSource("testSuccessArguments")
    public void testSuccess(int[] input, int[] expectedResult) {
        int[] transformResult = ArrayChallenge.transform(input);
        assertArrayEquals(expectedResult, transformResult);
    }

    public static Stream<Arguments> testSuccessArguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{120, 60, 40, 30, 24}),
                Arguments.of(new int[]{3, 2, 1}, new int[]{2, 3, 6}),
                Arguments.of(new int[]{0, 2, 3}, new int[]{6, 0, 0}),
                Arguments.of(new int[]{1, 0, 2, 0, 9}, new int[]{0, 0, 0, 0, 0}),
                Arguments.of(new int[]{-1, 2, 3}, new int[]{6, -3, -2})
        );
    }
}