package by.java.converter.repository;

import by.java.converter.model.Convert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConvertRepository extends JpaRepository<Convert, Long> {

    @Query(value = "SELECT * FROM convert " +
            "WHERE currency_in = :currencyIn AND currency_out = :currencyOut", nativeQuery = true)
    List<Convert> getConvertsByCurrencies(@Param("currencyIn") String currencyIn, @Param("currencyOut") String currencyOut);
}
