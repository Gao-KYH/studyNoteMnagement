package com.example;

/* making the post list for review the knowledge with a key word and comments*/

import java.util.ArrayList;
import java.util.LinkedList;

public class Post {
    private String name;
    private String subject;
    private ArrayList<Note> notes;

    public Post(String name, String subject) {
        this.name = name;
        this.subject = subject;
        this.notes = new ArrayList<Note>();
    }

    /*check if there is already a note with the same key word in the post list*/

    public Post() {

    }

    public Note findNote(String keyword) {
        for (Note checkedNote : notes) {
            if(checkedNote.getKeyword().equals(keyword)) return checkedNote;
        }
        return null;
    }

    /*Chck if there is no matching key word then create a new note to the Post*/

    public boolean addNote(String keyword, String comment){
        if(findNote(keyword) == null){
            notes.add(new Note(keyword, comment));
//            System.out.println(keyword + "Note successfully added to the post");
            return true;
        }else {
//            System.out.println("Keyword" + keyword + "already exist in the list");
            return false;
        }
    }


    /*add note to the PostList for study review by index of the notes*/

    public boolean addToPostList(int tagNumber, LinkedList<Note> PostList) {
        int index = tagNumber - 1;
        if (index > 0 && index <= this.notes.size()) {
            PostList.add(this.notes.get(index));
            return true;
        }
//        System.out.println("This post doesnot have note with tagNumber "+tagNumber);
        return false;
    }

    /*add note to the Postlist for study review by the keyword of the notes*/

    public boolean addToPostList(String keyword, LinkedList<Note> PostList) {
        for (Note checkedNote : this.notes){
            if (checkedNote.getKeyword().equals(keyword)) {
                PostList.add(checkedNote);
                return true;
            }
        }
//        System.out.println(keyword+"There is no such keyword in post");
        return false;
    }
}
