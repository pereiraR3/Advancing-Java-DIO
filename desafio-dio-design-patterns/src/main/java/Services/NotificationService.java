package Services;

import Models.Notification.NotificationModel;
import Models.Notification.NotificationRequestDTO;
import Models.Notification.NotificationResponseDTO;
import Repositories.NotificationRespository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRespository notificationRespository;

    public NotificationService(NotificationRespository notificationRespository) {
        this.notificationRespository = notificationRespository;
    }

    /**
     * Cria uma nova notificação.
     * @param body dados da notificação
     * @return NotificationResponseDTO contendo os dados da notificação criada
     */
    @Transactional
    public NotificationResponseDTO create(NotificationRequestDTO body) {

        NotificationModel notification = new NotificationModel(body);
        notificationRespository.save(notification);

        return new NotificationResponseDTO(notification);
    }

    /**
     * Busca uma notificação pelo ID.
     * @param id id da notificação
     * @return NotificationModel contendo os dados da notificação
     */
    public NotificationModel findById(Long id) {
        return notificationRespository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Notificação não encontrada"));
    }

    /**
     * Deleta uma notificação pelo ID.
     * @param id id da notificação
     */
    @Transactional
    public void deleteById(Long id) {
        NotificationModel notificationModel = findById(id);
        notificationRespository.delete(notificationModel);
    }

    /**
     * Lista todas as notificações.
     * @return lista de NotificationResponseDTO
     */
    public List<NotificationResponseDTO> listAll() {
        return notificationRespository.findAll()
                .stream()
                .map(NotificationResponseDTO::new)
                .toList();
    }
}
