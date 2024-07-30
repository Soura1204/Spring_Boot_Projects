public class SingletonPatternExample {

    
    public static class Logger {
        
        private static Logger instance;

        
        private Logger() {
            
        }

        
        public static Logger getInstance() {
            
            if (instance == null) {
                synchronized (Logger.class) {
                    if (instance == null) {
                        instance = new Logger();
                    }
                }
            }
            return instance;
        }

        
        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }

    
    public static void main(String[] args) {
        
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        
        System.out.println("Logger1 instance hash code: " + logger1.hashCode());
        System.out.println("Logger2 instance hash code: " + logger2.hashCode());

        
        logger1.log("This is a test log message.");
        logger2.log("This message is logged by the same instance.");
        
        
        if (logger1 == logger2) {
            System.out.println("Logger1 and Logger2 are the same instance.");
        } else {
            System.out.println("Logger1 and Logger2 are different instances.");
        }
    }
}
