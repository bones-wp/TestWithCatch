import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author Osmolovkiy Yuriy
 * @since 24.11.2023
 */
public class Utils {
    public static void tetsWithCatch(TestRunnable runnable, Class<? extends Exception> exceptionClass) {
        try {
            runnable.run();
            fail("Должна быть выброшена ошибка " + exceptionClass);
        } catch (Exception e) {
            if (!Objects.equals(e.getClass(), exceptionClass)) {
                fail("Выброшена ошибка " + e.getClass() + " но ожидается " + exceptionClass);
            }
        }
    }

    public interface TestRunnable {
        void run() throws Exception;
    }
}
