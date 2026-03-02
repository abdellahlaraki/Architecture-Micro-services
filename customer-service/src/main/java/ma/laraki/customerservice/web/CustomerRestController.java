package ma.laraki.customerservice.web;

import ma.laraki.customerservice.entities.Customer;
import ma.laraki.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/customers/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerById(@PathVariable Long id){
        Customer customer=customerRepository.findById(id).get();
        return customer;
    }
}
