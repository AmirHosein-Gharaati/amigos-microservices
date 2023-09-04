package com.mycompany.notification;

import com.mycompany.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
            Notification.builder()
                    .toCustomerId(notificationRequest.toCustomerId())
                    .toCustomerEmail(notificationRequest.toCustomerEmail())
                    .sender("Amirhosein")
                    .message(notificationRequest.message())
                    .sentAt(LocalDateTime.now())
                    .build()
        );
    }
}
