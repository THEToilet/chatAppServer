package jp.ac.shibaura.it.ie.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogUtils {
    private final static Logger logger = LoggerFactory.getLogger(LogUtils.class);
    public void info(String msg) {
        logger.info(msg);
    }
    public void warn(String msg) {
        logger.warn(msg);
    }
    public void error(String msg) {
        logger.error(msg);
    }
    public void debug(String msg) {
        logger.debug(msg);
    }
    public void trace(String msg) {
        logger.trace(msg);
    }
}

