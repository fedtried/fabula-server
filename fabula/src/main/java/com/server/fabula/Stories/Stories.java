package com.server.fabula.Stories;

import jakarta.persistence.*;

@Entity
@Table(name="stories")
public class Stories {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "quote")
    private String quote;

    @Column(name = "writing")
    private String writing;

    public Stories() {}

    public Stories(String date, String quote, String writing) {
        this.date = date;
        this.quote = quote;
        this.writing = writing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getWriting() {
        return writing;
    }

    public void setWriting(String writing) {
        this.writing = writing;
    }

    @Override
    public String toString() {
        return "Stories{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", quote='" + quote + '\'' +
                ", writing='" + writing + '\'' +
                '}';
    }
}
