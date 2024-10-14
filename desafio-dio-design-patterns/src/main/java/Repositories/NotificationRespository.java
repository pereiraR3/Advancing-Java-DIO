package Repositories;

import Models.Notification.NotificationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRespository extends JpaRepository<NotificationModel, Long> {

}
