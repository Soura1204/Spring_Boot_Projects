public class StrategyPatternExample {

    
    interface PaymentStrategy {
        void pay(double amount);
    }

    
    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;
        private String cardHolderName;

        public CreditCardPayment(String cardNumber, String cardHolderName) {
            this.cardNumber = cardNumber;
            this.cardHolderName = cardHolderName;
        }

        
        public void pay(double amount) {
            System.out.println("Processing credit card payment of $" + amount + " using card number: " + cardNumber);
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        private String emailAddress;

        public PayPalPayment(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        
        public void pay(double amount) {
            System.out.println("Processing PayPal payment of $" + amount + " using email: " + emailAddress);
        }
    }

    
    static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(double amount) {
            if (paymentStrategy != null) {
                paymentStrategy.pay(amount);
            } else {
                System.out.println("Payment strategy not set.");
            }
        }
    }

    
    public static void main(String[] args) {
        
        PaymentContext paymentContext = new PaymentContext();

        
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        paymentContext.setPaymentStrategy(creditCardPayment);
        System.out.println("Executing payment with Credit Card:");
        paymentContext.executePayment(150.0);

        
        PaymentStrategy payPalPayment = new PayPalPayment("sourajit.datta@example.com");
        paymentContext.setPaymentStrategy(payPalPayment);
        System.out.println("Executing payment with PayPal:");
        paymentContext.executePayment(200.0);
    }
}
