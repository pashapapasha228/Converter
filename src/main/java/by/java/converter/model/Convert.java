package by.java.converter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "converts")
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

}
