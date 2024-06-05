package com.example.mailapp.models;

public class Mail {

    //atributos
    private String subject; //asunto
    private String message; //mensaje
    private String senderName; // quien envía el mensaje
    private String color; //color tomará un valor en haxadecimal

    //metodos


    public Mail(String subject, String message, String senderName) {
        this.subject = subject;
        this.message = message;
        this.senderName = senderName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
