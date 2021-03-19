package exception;

import java.util.logging.*;

public class TestLogging {
    public static void main(String[] args) {
        //* Java 内置的 Logger 类
        Logger logger = Logger.getGlobal();

        logger.info("Start main method.");
        logger.warning("Warning message sample.");
        logger.fine("Ignored message sample.");
        logger.severe("Extremely dangerous situation.");
    }
}