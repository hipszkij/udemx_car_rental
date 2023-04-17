package eu.udemx.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ReservationDto {
    private Integer id;

    @NotEmpty(message = "Car ID is required.")
    private Integer carId;

    @NotEmpty(message = "Username is required.")
    private String userName;

    @NotEmpty(message = "User e-mail is required.")
    private String userEmail;

    @NotEmpty(message = "User phone number is required.")
    private String userMobile;

    @NotEmpty(message = "User address is required.")
    private String    userAddress;

    @NotEmpty(message = "Reservation start date is required.")
    private LocalDate startDate;

    @NotEmpty(message = "Reservation end date is required.")
    private LocalDate endDate;

    private String description;

    private LocalDateTime createdAt;
}
