package com.example.qasim.whatsappclone.model;

import java.util.Date;

public class Message {
    private String text;
    private Date date;
    private boolean fromMe;


    public Message(String text, Date date, boolean fromMe) {
        this.text = text;
        this.date = date;
        this.fromMe = fromMe;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isFromMe() {
        return fromMe;
    }

    public void setFromMe(boolean fromMe) {
        this.fromMe = fromMe;
    }
    public String getFormattedDate(){
        return   String.format("%2d:%2d",date.getHours(),date.getMinutes());
    }
}
