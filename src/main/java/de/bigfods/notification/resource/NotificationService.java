package de.bigfods.notification.resource;

import de.bigfods.notification.model.Notification;
import de.bigfods.notification.repository.NotificationRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestScoped
public class NotificationService {

  private final NotificationRepository notificationRepository;

  public Notification showNotification(Long id) {
    return notificationRepository.findById(id);
  }

  public List<Notification> showNotifications() {
    return notificationRepository.findAll().list();
  }

  public Notification updateNotifications(Long id, Notification newNotification) {
    Optional<Notification> noticationOpt = notificationRepository.findByIdOptional(id);

    if(noticationOpt.isEmpty()){
      return null;
    }

    Notification notification = noticationOpt.get();

    notification.setMessage(newNotification.getMessage());
    notification.setSubject(newNotification.getSubject());
    //Todo: Add possibility to change image icon;

    return notification;
  }

  public Notification addNotification(Notification notification ) {
    Objects.requireNonNull(notification);
    notificationRepository.persist(notification);
    return notification ;
  }

  public boolean deleteNotification(Long id) {
    return true;
  }
}
