package by.java.converter.repository;

import by.java.converter.model.Convert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvertRepository extends JpaRepository<Convert, Long> {
}
