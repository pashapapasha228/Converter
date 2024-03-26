package by.java.converter.repository;

import by.java.converter.model.ConvertHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ConvertHistoryRepository extends JpaRepository<ConvertHistory, Long> {
}
