import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GameTest {



    public static Stream<Arguments> getParameters(){
        return Stream.of(
                arguments(new String("rock"), new String ("rock"), "Draw!"),
                arguments(new String("paper"), new String ("paper"), "Draw!"),
                arguments(new String("scissors"), new String ("scissors"), "Draw!"),
                arguments(new String("paper"), new String ("scissors"), "Player 2 win!"),
                arguments(new String("paper"), new String ("rock"), "Player 1 win!"),
                arguments(new String("rock"), new String ("scissors"), "Player 1 win!"),
                arguments(new String("rock"), new String ("paper"), "Player 2 win!"),
                arguments(new String("scissors"), new String ("paper"), "Player 1 win!"),
                arguments(new String("scissors"), new String ("rock"), "Player 2 win!")
        );
    }
    @ParameterizedTest
    @MethodSource("getParameters")
    public void GameDecisionTest(String inputA, String inputB, String expected)
    {
        Game Game1 = new Game();
        assertEquals(expected, Game1.Gamedecision(inputA, inputB));
    }

    @Test()
    public void InputTestThrow()
    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Game Game2 = new Game();
                Game2.Inputvalidation("rrr");
            }
        });
    }
    @Test()
    public void InputTestNotThrow()
    {
        assertDoesNotThrow(()->{
            Game Game3 = new Game();
            Game3.Inputvalidation("paper");
        });
    }

}