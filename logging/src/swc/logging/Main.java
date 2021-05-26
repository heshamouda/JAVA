/**
 * 
 */
package swc.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import swc.logging.work.Worker;

/**
 * @author christoph.denzler
 *
 */
public class Main {
  
  private static Logger mainlogger = LogManager.getLogger(Main.class);
  private static Logger specialLogger = LogManager.getLogger("SpecialLogger");
  
  private static Level determineLevel(String[] args) {
    char option;
    if (args.length > 0) {
      option = Character.toUpperCase(args[0].charAt(0));
    } else {
      option = 'D';
    }
    switch (option) {
    case 'T': return Level.TRACE;
    case 'D': return Level.DEBUG;
    case 'I': return Level.INFO;
    case 'W': return Level.WARN;
    case 'E': return Level.ERROR;
    case 'F': return Level.FATAL;
    default: return Level.DEBUG;
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    Level loglevel = determineLevel(args);
    
    mainlogger.log(loglevel, "creating worker");
    Worker w = new Worker();
    
    mainlogger.log(loglevel, "Let the worker work");
    w.work();
    
    specialLogger.info(() -> "working in progress" + 1);
  }

}
