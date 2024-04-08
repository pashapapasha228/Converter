package by.java.converter.repository;

import by.java.converter.model.ConvertHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvertHistoryRepository extends JpaRepository<ConvertHistory, Long> {
}
