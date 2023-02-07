package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerTest {
    Logger logger = LogManager.getLogger(LoggerTest.class);
    Logger loggerFile = LogManager.getLogger("File");

    @Test
    public void loggerTest() {
        logger.trace("Trace message.......");
        logger.debug("Debug message.......");
        logger.info("Info message.......");
        logger.warn("Warning message.......");
        logger.error("Error message.......");
        logger.fatal("Fatal message.......");

        loggerFile.error("Error message.......");
        loggerFile.fatal("Fatal message.......");

    }
}
