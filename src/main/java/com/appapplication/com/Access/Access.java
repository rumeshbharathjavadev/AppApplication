package com.appapplication.com.Access;

import com.appapplication.com.Details.Details;
import jakarta.persistence.*;

@Entity
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String microphone;
    private String stoage;
    private String camera;
    private String message;
    private String notification;


    @ManyToOne
    private Details application;

    public Access() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMicrophone() {
        return microphone;
    }

    public void setMicrophone(String microphone) {
        this.microphone = microphone;
    }

    public String getStoage() {
        return stoage;
    }

    public void setStoage(String stoage) {
        this.stoage = stoage;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public Details getApplication() {
        return application;
    }

    public void setApplication(Details application) {
        this.application = application;
    }
}
