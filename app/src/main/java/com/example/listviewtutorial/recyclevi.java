/*
A model class that holds the parameters of the API ( recyclevi object) . They are then called when the user wants to get information
from that particular parameter.
 */

package com.example.listviewtutorial;

public class recyclevi {
    private String title;
    private String publisher;
    private String imageUrl;
    private String inform;
    public recyclevi (){}


    public recyclevi(String title, String publisher, String imageUrl){
        this.title=title;
        this.publisher=publisher;
        this.imageUrl=imageUrl;

    }

    public String getTitle(){
        return title;
    }
    public  String getPublisher () {
        return publisher;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }
}
