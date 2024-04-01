package by.java.converter.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
