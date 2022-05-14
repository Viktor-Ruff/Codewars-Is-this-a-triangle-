import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TriangleTesterTest {

    private TriangleTester triangleTester;

    @BeforeEach
    public void startUp() {
        System.out.println("Test is START");
        triangleTester = new TriangleTester();
    }

    @AfterEach
    public void shutdown() {
        System.out.println("Test is END");
    }

    @Test
    void testTriangleTester1() {
        Assertions.assertEquals(true, triangleTester.isTriangle(100, 100, 100));
    }

    @DisplayName("Check Exercise8")
    @ParameterizedTest
    @MethodSource("data")
    public void paramTest8(boolean result, int a, int b, int c) {
        Assertions.assertEquals(result, triangleTester.isTriangle(a, b, c));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(true, 5, 5, 7),
                Arguments.arguments(true, 7, 5, 6),
                Arguments.arguments(true, 18, 22, 19),
                Arguments.arguments(true, 1, 1, 1),
                Arguments.arguments(true, 126, 126, 15),
                Arguments.arguments(true, 55, 51, 43),
                Arguments.arguments(false, 2, 17, 283),
                Arguments.arguments(false, 0, 2, 3),
                Arguments.arguments(false, -35, 143, 32),
                Arguments.arguments(false, 0, -15, -15),
                Arguments.arguments(false, -2, -2, -2)
        );
    }
}