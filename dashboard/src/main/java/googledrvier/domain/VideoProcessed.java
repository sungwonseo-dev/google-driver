package googledrvier.domain;

import googledrvier.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class VideoProcessed extends AbstractEvent {

    private Long videoId;
    private Long fileId;
    private String streamingURI;
}
