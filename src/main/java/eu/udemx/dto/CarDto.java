package eu.udemx.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@JsonSerialize
public class CarDto {
    private Integer id;

    private Boolean status;

    @NotEmpty(message = "Car name is required.")
    private String name;

    @NotEmpty(message = "Car type is required.")
    private String type;

    private String description;

    @NotEmpty(message = "Car plate is required.")
    private String plate;

    @NotEmpty(message = "Car price is required.")
    private Integer price;

    private LocalDateTime createdAt;
}

