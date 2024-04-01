package by.java.converter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

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

    @OneToMany(mappedBy = "convertHistory")
    @JsonBackReference
    private Set<Convert> converts;

}
