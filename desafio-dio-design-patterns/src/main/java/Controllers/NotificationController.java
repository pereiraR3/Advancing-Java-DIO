package Controllers;

import Models.Notification.NotificationRequestDTO;
import Models.Notification.NotificationResponseDTO;
import Services.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Endpoint para criar uma nova notificação.
     * @param body dados da notificação
     * @return ResponseEntity com a notificação criada e o status HTTP 201
     */
    @Operation(summary = "Cria uma nova notificação", description = "Cria uma notificação com os dados fornecidos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Notificação criada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NotificationResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos",
                    content = @Content)
    })
    @PostMapping("/create")
    public ResponseEntity<NotificationResponseDTO> createNotification(
            @RequestBody NotificationRequestDTO body) {
        NotificationResponseDTO notification = notificationService.create(body);
        return new ResponseEntity<>(notification, HttpStatus.CREATED);
    }

    /**
     * Endpoint para buscar uma notificação por ID.
     * @param id id da notificação
     * @return ResponseEntity com a notificação encontrada e o status HTTP 200
     */
    @Operation(summary = "Busca uma notificação por ID", description = "Retorna os dados da notificação associada ao ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notificação encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NotificationResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Notificação não encontrada",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<NotificationResponseDTO> getNotificationById(@PathVariable Long id) {
        NotificationResponseDTO notification = new NotificationResponseDTO(notificationService.findById(id));
        return ResponseEntity.ok(notification);
    }

    /**
     * Endpoint para listar todas as notificações.
     * @return ResponseEntity com a lista de notificações e o status HTTP 200
     */
    @Operation(summary = "Lista todas as notificações", description = "Retorna uma lista de todas as notificações disponíveis.")
    @ApiResponse(responseCode = "200", description = "Lista de notificações",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = NotificationResponseDTO.class)))
    @GetMapping("/findAll")
    public ResponseEntity<List<NotificationResponseDTO>> listAllNotifications() {
        List<NotificationResponseDTO> notifications = notificationService.listAll();
        return ResponseEntity.ok(notifications);
    }

    /**
     * Endpoint para deletar uma notificação por ID.
     * @param id id da notificação
     * @return ResponseEntity com status HTTP 204 (sem conteúdo)
     */
    @Operation(summary = "Deleta uma notificação por ID", description = "Remove a notificação correspondente ao ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Notificação deletada",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Notificação não encontrada",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificationById(@PathVariable Long id) {
        notificationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
