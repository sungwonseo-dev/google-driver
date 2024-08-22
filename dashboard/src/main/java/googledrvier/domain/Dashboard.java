package googledrvier.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Dashboard_table")
@Data
public class Dashboard {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Integer fileSize;
    private String fileName;
    private Boolean isFileUploaded;
    private Boolean isFileIndexed;
    private String streamingUri;
}
