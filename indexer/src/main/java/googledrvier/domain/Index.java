package googledrvier.domain;

import googledrvier.IndexerApplication;
import googledrvier.domain.FileIndexed;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Index_table")
@Data
//<<< DDD / Aggregate Root
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long indexId;

    private Long fileId;

    private String filePath;

    private String fileName;

    @PostPersist
    public void onPostPersist() {
        FileIndexed fileIndexed = new FileIndexed(this);
        fileIndexed.publishAfterCommit();
    }

    public static IndexRepository repository() {
        IndexRepository indexRepository = IndexerApplication.applicationContext.getBean(
            IndexRepository.class
        );
        return indexRepository;
    }

    //<<< Clean Arch / Port Method
    public static void addFile(FileUploaded fileUploaded) {
        //implement business logic here:

        /** Example 1:  new item 
        Index index = new Index();
        repository().save(index);

        FileIndexed fileIndexed = new FileIndexed(index);
        fileIndexed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(index->{
            
            index // do something
            repository().save(index);

            FileIndexed fileIndexed = new FileIndexed(index);
            fileIndexed.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
