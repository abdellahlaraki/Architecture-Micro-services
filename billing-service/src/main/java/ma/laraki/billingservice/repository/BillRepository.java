package ma.laraki.billingservice.repository;

import ma.laraki.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
