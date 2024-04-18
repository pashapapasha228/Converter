package by.java.converter.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Модель сущности Convert.
 */
@Entity
@Getter
@Setter
@Table(name = "convert")
@AllArgsConstructor
@NoArgsConstructor
public class Convert {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String currencyIn;
  private String currencyOut;
  private Double amountIn;
  private Double amountOut;

  @ManyToOne
  @JoinColumn(name = "history_id")
  @JsonManagedReference
  private ConvertHistory convertHistory;
}
