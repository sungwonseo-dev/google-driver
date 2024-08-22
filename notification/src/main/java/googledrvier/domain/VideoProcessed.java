package googledrvier.domain;

import googledrvier.domain.*;
import googledrvier.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class VideoProcessed extends AbstractEvent {

    private Long videoId;
    private Long fileId;
    private String streamingUri;
}
