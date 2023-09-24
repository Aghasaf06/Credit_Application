package buta.creditapplication.Repository;

import buta.creditapplication.Entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditRepository extends JpaRepository<Credit, Integer> {

}
