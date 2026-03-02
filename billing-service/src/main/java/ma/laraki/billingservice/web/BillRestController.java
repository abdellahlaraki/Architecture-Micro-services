package ma.laraki.billingservice.web;

import ma.laraki.billingservice.entities.Bill;
import ma.laraki.billingservice.feign.CustomerServiceRestClient;
import ma.laraki.billingservice.feign.InventoryServiceRestClient;
import ma.laraki.billingservice.model.Customer;
import ma.laraki.billingservice.model.Product;
import ma.laraki.billingservice.repository.BillRepository;
import ma.laraki.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceRestClient customerServiceRestClient;
    @Autowired
    private InventoryServiceRestClient inventoryServiceRestClient;

    @GetMapping("/bills/{id}")
     public Bill getBillById(@PathVariable Long id){
        Bill bill=billRepository.findById(id).get();
        //récuperer Customer en utilisant openFeign
        Customer customer=customerServiceRestClient.getCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(p->{
            Product product=inventoryServiceRestClient.getProductById(p.getProductId());
            p.setProduct(product);
        });
        return bill;
    }

    @GetMapping("/bills")
    public List<Bill> getAllBills(){
        List<Bill> bills=billRepository.findAll();
        for (Bill bill:bills){
            Customer customer=customerServiceRestClient.getCustomerById(bill.getCustomerId());
            bill.setCustomer(customer);
            bill.getProductItems().forEach(productItem->{
                Product product=inventoryServiceRestClient.getProductById(productItem.getProductId());
                productItem.setProduct(product);
            });
        }
        return bills;
    }

}
