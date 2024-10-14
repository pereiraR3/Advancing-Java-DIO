package Models.Notification;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "notification")
@Data
public class NotificationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "platform", nullable = false)
    private String platform;

    public NotificationModel(NotificationRequestDTO requestDTO){

        message = requestDTO.message();
        platform = requestDTO.platform();

    }

}
