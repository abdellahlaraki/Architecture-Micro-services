package ma.laraki.customerservice.repository;

import ma.laraki.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource // permet d'acceder à tout les méthode qui se trouve dans CustomerRepository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
