public class DependencyInjectionExample {

    
    interface CustomerRepository {
        String findCustomerById(String id);
    }

    
    static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public String findCustomerById(String id) {
            
            if (id.equals("123")) {
                return "Customer [ID=123, Name=Sourajit Datta]";
            } else {
                return "Customer not found.";
            }
        }
    }

    
    static class CustomerService {
        private final CustomerRepository customerRepository;

        
        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public String getCustomerDetails(String id) {
            return customerRepository.findCustomerById(id);
        }
    }

    
    public static void main(String[] args) {
        
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);
        String customerDetails = customerService.getCustomerDetails("123");
        System.out.println(customerDetails);
        customerDetails = customerService.getCustomerDetails("999");
        System.out.println(customerDetails);
    }
}
