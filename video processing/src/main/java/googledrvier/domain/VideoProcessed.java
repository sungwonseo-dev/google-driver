package googledrvier.domain;

import googledrvier.domain.*;
import googledrvier.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class VideoProcessed extends AbstractEvent {

    private Long videoId;
    private Long fileId;
    private String streamingUri;

    public VideoProcessed(Video aggregate) {
        super(aggregate);
    }

    public VideoProcessed() {
        super();
    }
}
//>>> DDD / Domain Event
