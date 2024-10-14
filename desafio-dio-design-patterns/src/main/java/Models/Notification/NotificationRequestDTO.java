package Models.Notification;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NotificationRequestDTO(

        @NotBlank
        @Size(max = 255)
        String message,

        @NotBlank
        @Size(max = 30)
        String platform

) {
}
