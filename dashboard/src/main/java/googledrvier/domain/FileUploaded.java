package googledrvier.domain;

import googledrvier.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class FileUploaded extends AbstractEvent {

    private Long fileId;
    private String fileName;
    private String filePath;
    private String fileType;
    private Integer fileSize;
    private Long ownerId;
}
