package by.java.converter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


/**
 * Модель сущности ConvertHistory.
 */
@Entity
@Getter
@Setter
@Table(name = "history")
@AllArgsConstructor
@NoArgsConstructor
public class ConvertHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreationTimestamp
  private LocalDateTime localDateTime;

  @OneToMany(mappedBy = "convertHistory", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonBackReference
  private Set<Convert> converts;

}
