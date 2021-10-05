
package abstractClasses.Logg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;

public class Logg {

    protected static final Logger logger = LogManager.getLogger();

    public Logger getLogger() {
        return logger;
    }
}
