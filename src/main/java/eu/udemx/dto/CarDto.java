package eu.udemx.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@JsonSerialize
public class CarDto {
    private Long id;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getPlate() {
        return plate;
    }

    public Integer getPrice() {
        return price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

