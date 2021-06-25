import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class MapChallengeTest {

    @ParameterizedTest
    @MethodSource("testSuccessArguments")
    public void testSuccess(List<Map<String, String>> data,
                            String agg,
                            String acc,
                            List<Map<String, String>> expectedResult) {

        List<Map<String, String>> result = MapIterativeChallenge.transform(data, agg, acc);
        assertIterableEquals(expectedResult, result);
    }

    public static Stream<Arguments> testSuccessArguments() {
        List<Map<String, String>> carInventory = List.of(
                Map.of("carBrand", "Ford",
                        "carType", "SUV",
                        "numberOfItemsAvailable", "34"),
                Map.of("carBrand", "Toyota",
                        "carType", "SUV",
                        "numberOfItemsAvailable", "12"),
                Map.of("carBrand", "Ford",
                        "carType", "Sedane",
                        "numberOfItemsAvailable", "3"),
                Map.of("carBrand", "Nissan",
                        "carType", "Sedane",
                        "numberOfItemsAvailable", "10"),
                Map.of("carBrand", "Nissan",
                        "carType", "Convertible",
                        "numberOfItemsAvailable", "8"));

        return Stream.of(
                Arguments.of(carInventory, "carBrand", "numberOfItemsAvailable", List.of(
                        Map.of("carBrand", "Ford",
                                "numberOfItemsAvailable", "37"),
                        Map.of("carBrand", "Nissan",
                                "numberOfItemsAvailable", "18"),
                        Map.of("carBrand", "Toyota",
                                "numberOfItemsAvailable", "12")
                )),
                Arguments.of(carInventory, "carType", "numberOfItemsAvailable", List.of(
                        Map.of("carType", "Convertible",
                                "numberOfItemsAvailable", "8"),
                        Map.of("carType", "SUV",
                                "numberOfItemsAvailable", "46"),
                        Map.of("carType", "Sedane",
                                "numberOfItemsAvailable", "13")
                ))
        );
    }
}