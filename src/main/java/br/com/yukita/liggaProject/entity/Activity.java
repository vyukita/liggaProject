package br.com.yukita.liggaProject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String activity;
    private String type;
    private int participants;
    private double price;
    private String accessibility;
    private String duration;
    private boolean kidFriendly;
    private String link;
    private String keyCode;

    public Activity(String activity, String type, int participants, double price, String accessibility, String duration, boolean kidFriendly, String link, String keyCode) {
        this.activity = activity;
        this.type = type;
        this.participants = participants;
        this.price = price;
        this.accessibility = accessibility;
        this.duration = duration;
        this.kidFriendly = kidFriendly;
        this.link = link;
        this.keyCode = keyCode;
    }

    public Activity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isKidFriendly() {
        return kidFriendly;
    }

    public void setKidFriendly(boolean kidFriendly) {
        this.kidFriendly = kidFriendly;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }


}
