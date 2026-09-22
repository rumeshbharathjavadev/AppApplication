package com.appapplication.com.Review;

import com.appapplication.com.Application.Application;
import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postlike;
    private String comment;
    private Long share;
    private String repost;
    private Long rating;

    @ManyToOne
    private Application application;


    public Review() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLike() {
        return postlike;
    }

    public void setLike(Long like) {
        this.postlike = like;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getShare() {
        return share;
    }

    public void setShare(Long share) {
        this.share = share;
    }

    public String getRepost() {
        return repost;
    }

    public void setRepost(String repost) {
        this.repost = repost;
    }

    public Integer getRating() {
        return Math.toIntExact(rating);
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

}
