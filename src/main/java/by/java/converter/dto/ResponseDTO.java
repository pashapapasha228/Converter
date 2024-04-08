package by.java.converter.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ResponseDTO {

    private List<ConvertDTO> converts;

}
