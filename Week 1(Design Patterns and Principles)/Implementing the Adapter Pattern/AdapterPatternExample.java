public class AdapterPatternExample {

    
    interface PaymentProcessor {
        void processPayment(double amount);
    }

    
    static class PayPalGateway {
        void makePayment(double amount) {
            System.out.println("Processing payment of $" + amount + " using PayPal.");
        }
    }

    static class StripeGateway {
        void charge(double amount) {
            System.out.println("Charging $" + amount + " with Stripe.");
        }
    }

    static class SquareGateway {
        void submitPayment(double amount) {
            System.out.println("Submitting payment of $" + amount + " through Square.");
        }
    }

    
    static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway payPalGateway;

        public PayPalAdapter(PayPalGateway payPalGateway) {
            this.payPalGateway = payPalGateway;
        }

        
        public void processPayment(double amount) {
            payPalGateway.makePayment(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripeGateway;

        public StripeAdapter(StripeGateway stripeGateway) {
            this.stripeGateway = stripeGateway;
        }

        
        public void processPayment(double amount) {
            stripeGateway.charge(amount);
        }
    }

    static class SquareAdapter implements PaymentProcessor {
        private SquareGateway squareGateway;

        public SquareAdapter(SquareGateway squareGateway) {
            this.squareGateway = squareGateway;
        }

        
        public void processPayment(double amount) {
            squareGateway.submitPayment(amount);
        }
    }

    
    public static void main(String[] args) {
        
        PayPalGateway payPal = new PayPalGateway();
        StripeGateway stripe = new StripeGateway();
        SquareGateway square = new SquareGateway();

        
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);
        PaymentProcessor squareProcessor = new SquareAdapter(square);

        
        payPalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(200.0);
        squareProcessor.processPayment(300.0);
    }
}
