package googledrvier.domain;

import googledrvier.VideoProcessingApplication;
import googledrvier.domain.VideoProcessed;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Video_table")
@Data
//<<< DDD / Aggregate Root
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long videoId;

    private Long fileId;

    private String streamingUri;

    @PostPersist
    public void onPostPersist() {
        VideoProcessed videoProcessed = new VideoProcessed(this);
        videoProcessed.publishAfterCommit();
    }

    public static VideoRepository repository() {
        VideoRepository videoRepository = VideoProcessingApplication.applicationContext.getBean(
            VideoRepository.class
        );
        return videoRepository;
    }

    //<<< Clean Arch / Port Method
    public static void addVideo(FileUploaded fileUploaded) {
        //implement business logic here:

        /** Example 1:  new item 
        Video video = new Video();
        repository().save(video);

        VideoProcessed videoProcessed = new VideoProcessed(video);
        videoProcessed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(video->{
            
            video // do something
            repository().save(video);

            VideoProcessed videoProcessed = new VideoProcessed(video);
            videoProcessed.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
