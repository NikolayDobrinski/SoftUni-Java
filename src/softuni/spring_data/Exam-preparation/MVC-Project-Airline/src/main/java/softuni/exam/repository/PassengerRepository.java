package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Passenger;

import java.util.List;

@Repository
public interface PassengerRepository  extends JpaRepository<Passenger, Long> {

    Passenger findPassengerByEmail(String email);

    List<Passenger> findAll();
    
}
