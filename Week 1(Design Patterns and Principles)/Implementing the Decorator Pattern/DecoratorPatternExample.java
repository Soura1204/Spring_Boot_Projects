public class DecoratorPatternExample {

    
    interface Notifier {
        void send(String message);
    }

    
    static class EmailNotifier implements Notifier {
        
        public void send(String message) {
            System.out.println("Sending Email: " + message);
        }
    }

    
    abstract static class NotifierDecorator implements Notifier {
        protected Notifier notifier;

        public NotifierDecorator(Notifier notifier) {
            this.notifier = notifier;
        }

        
        public void send(String message) {
            notifier.send(message);
        }
    }

    static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        
        public void send(String message) {
            super.send(message); 
            sendSMS(message);   
        }

        private void sendSMS(String message) {
            System.out.println("Sending SMS: " + message);
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        
        public void send(String message) {
            super.send(message); 
            sendSlackMessage(message); 
        }

        private void sendSlackMessage(String message) {
            System.out.println("Sending Slack message: " + message);
        }
    }

    
    public static void main(String[] args) {
        
        Notifier emailNotifier = new EmailNotifier();

        
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        
        
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        
        slackNotifier.send("This is a test notification.");

    }
}
