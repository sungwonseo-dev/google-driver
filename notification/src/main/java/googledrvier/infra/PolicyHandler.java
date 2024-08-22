package googledrvier.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import googledrvier.config.kafka.KafkaProcessor;
import googledrvier.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    NotificationRepository notificationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FileUploaded'"
    )
    public void wheneverFileUploaded_AddNotification(
        @Payload FileUploaded fileUploaded
    ) {
        FileUploaded event = fileUploaded;
        System.out.println(
            "\n\n##### listener AddNotification : " + fileUploaded + "\n\n"
        );

        // Sample Logic //
        Notification.addNotification(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='VideoProcessed'"
    )
    public void wheneverVideoProcessed_AddNotification(
        @Payload VideoProcessed videoProcessed
    ) {
        VideoProcessed event = videoProcessed;
        System.out.println(
            "\n\n##### listener AddNotification : " + videoProcessed + "\n\n"
        );

        // Sample Logic //
        Notification.addNotification(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
