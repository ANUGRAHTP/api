package com.anugrah.mycourse;



public class CourseModel {


    String title,description,duration,venue,date;

    public CourseModel() {
    }


    public CourseModel(String title, String description, String duration, String venue, String date) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.venue = venue;
        this.date = date;
    }

    public String getTitle(String s4) {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription(String s2) {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration(String s3) {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getVenue(String s4) {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate(String s1) {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
