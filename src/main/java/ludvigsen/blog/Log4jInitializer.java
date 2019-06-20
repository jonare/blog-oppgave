

package ludvigsen.blog;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Log4jInitializer implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        PropertyConfigurator.configureAndWatch("log4j.properties");
        Logger.getLogger(Log4jInitializer.class).info("log4j initialized OK.");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // normally we should clean up the thread 'configureAndWatch' created. We skip that in the case...
    }
}
