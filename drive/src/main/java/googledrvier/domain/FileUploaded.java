package googledrvier.domain;

import googledrvier.domain.*;
import googledrvier.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FileUploaded extends AbstractEvent {

    private Long fileId;
    private String fileName;
    private String filePath;
    private String fileType;
    private Integer fileSize;
    private Long ownerId;

    public FileUploaded(File aggregate) {
        super(aggregate);
    }

    public FileUploaded() {
        super();
    }
}
//>>> DDD / Domain Event
