package am.hitech.jdbc.interfaces;

import am.hitech.jdbc.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    List<User> findAllByAge(int age);
    User getByEmailAndAge(String email,int age);
    @Query("select u from User u where u.email = ?1 and u.age = ?2")
    User getByUsernameAndAge(String username,int age);

    @Query(nativeQuery = true,value = "select * from user where email = ?1 and age = ?2")
    User getByUsernameAndAge1(String username,int age);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update user u set u.age = ?1 where id = ?2")
    void updateAge(int age,int id);

    @Query("select u from User u")
    Page<User> getAll(Pageable pageable);

}
