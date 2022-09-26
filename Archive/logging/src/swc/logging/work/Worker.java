/**
 * 
 */
package swc.logging.work;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * @author christoph.denzler
 *
 */
public class Worker {
  
  private static Logger logger = LogManager.getLogger(Worker.class);
  
  public void work() {
    int i = 0;
    logger.log(Level.TRACE, "entering Worker.work");
    System.out.println("working...");
    logger.log(Level.TRACE, "exiting Worker.work");
    i++;
  }

}
