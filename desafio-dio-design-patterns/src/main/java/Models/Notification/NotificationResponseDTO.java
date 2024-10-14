package Models.Notification;

public record NotificationResponseDTO (

        Long id,

        String message,

        String platform

        ){

    public NotificationResponseDTO(NotificationModel notificationModel){


        this(
                notificationModel.getId(),
                notificationModel.getMessage(),
                notificationModel.getPlatform()
        );

    }

}
