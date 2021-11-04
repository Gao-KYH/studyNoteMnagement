package com.example;

/* making a note list*/

public class Note {
    String keyword;
    String comment;

    public Note(String keyword, String comment) {
        this.keyword = keyword;
        this.comment = comment;
    }

    public Note(){

    }

    public String getKeyword() {
        return keyword;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Note{" +
                "keyword='" + keyword + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
