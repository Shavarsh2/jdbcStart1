package am.hitech.jdbc.interfaces;

import am.hitech.jdbc.model.PhoneCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneCodesRepo extends JpaRepository<PhoneCodes,Integer> {

}
