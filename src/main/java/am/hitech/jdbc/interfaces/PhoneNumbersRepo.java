package am.hitech.jdbc.interfaces;

import am.hitech.jdbc.model.PhoneNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumbersRepo extends JpaRepository<PhoneNumbers,Integer> {

}
