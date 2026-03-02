package ma.laraki.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.laraki.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

   //on utilise FeignClient pour récuperer des données sur customer
@FeignClient(name = "customer-service") // FeignClient avec le nom service
   //Open Feign est un framwork déclarative
public interface CustomerServiceRestClient {
    // déclarer les méthodes
    @GetMapping(value = "/customers/{id}")
    @CircuitBreaker(name = "customer-service",fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable long id);

    // Si le customer service a  échoué
    default Customer getDefaultCustomer(long id,Exception e) {
        e.printStackTrace();
        System.out.println("Customer service is down! Using fallback...");
        Customer customer=new Customer();
        customer.setId(id);
        customer.setName("Default Customer");
        customer.setEmail("default@email.com");
        return customer;
    }
}
