package de.bigfods.notification.resource;

import de.bigfods.notification.model.Notification;import io.quarkus.security.Authenticated;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/api/notifications/")
public class NotificationResource {

  private final NotificationService notificationService;

  @GET
  public List<Notification> showNotifications(){
    return notificationService.showNotifications();
  }

  @GET
  @Path("{notificationId}")
  public Notification showNotification(@PathParam("notificationId") long id){
    return notificationService.showNotification(id);
  }

  @POST
  @Transactional
  @Authenticated
  public Notification addNotifications(Notification notification){
    return notificationService.addNotification(notification);
  }

  @Path("{notificationId}")
  @PUT
  @Transactional
  @Authenticated
  public Notification updateNotification(@PathParam("notificationId") Long id, Notification notification){
    return notificationService.updateNotifications(id, notification);
  }

  @Path("{notificationId}")
  @DELETE
  @Transactional
  @Authenticated
  public boolean deleteNotification(@PathParam("notificationId") Long id){
    System.out.println("executed");
    return notificationService.deleteNotification(id);
  }
}
