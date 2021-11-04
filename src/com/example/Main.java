package com.example;

import java.util.*;

public class Main {

//The Posts created below will be added to the ArrayList

    private static ArrayList<Post> posts = new ArrayList<>();

    public static void main(String[] args) {

//define the subjects of the two education IoT and HR. The reading and writing contents//

        System.out.println("***** Internet of Thing *****");
        IotStudy myIotStudy = new IotStudy("javaprogramming");
        myIotStudy.readingTime("oop");
        myIotStudy.writingTime("w3school");
        myIotStudy.havingExam();
        myIotStudy.addingMoreTime();
        System.out.println("     ");

        System.out.println("***** HR *****");
        HRStudy myHRStudy = new HRStudy("Global justice");
        myHRStudy.readingTime("Inequality");
        myHRStudy.writingTime("notes");
        myHRStudy.havingExam();
        myHRStudy.addingMoreTime();
        System.out.println("     ");


        System.out.println("***** Review Notes by Post *****");

        //create aa object of Post class named "java" of "IOT" subject;
        // and add notes of keyword and comments to it//

        Post post = new Post("java","IoT");

        post.addNote("oop","object orientated program");
        post.addNote("class","Blue print that object follows; number of objects");
        post.addNote("object","real world entity; properties; methods; instance of class");
        post.addNote("oop principles","abstrct; encapsulation; inheritance; Polymorphism");
        posts.add(post);

        //create another  object of the Post class named "GLobal Justice"of "HR" subejct;
        // and add notes of keyword and comments to it

        post = new Post("Global Justice","HR");

        post.addNote("global justice","read Rawl's article");
        post.addNote("inequality","economy; women's rights");
        post.addNote("migration","read articles; open border;");
        posts.add(post);

        post = new Post("words","English study");

        post.addNote("thank you","tack; Tusen tack! ");
        post.addNote("good morning","god morgon");
        post.addNote("have a nice day","Ha en bra dag");
        post.addNote("I want to travel","jag vill resa");
        posts.add(post);

        //The Linklist of the postlist to show the notes of the POst created above
        LinkedList<Note> postList_1 = new LinkedList<>();

        posts.get(0).addToPostList("oop",postList_1);
        posts.get(0).addToPostList("class", postList_1);
        posts.get(0).addToPostList("global justice",postList_1);
        posts.get(1).addToPostList("inequality", postList_1);

        review(postList_1);

    }

// create a function to review the study notes by the linkedlist
// function reads the input of user: the number of options to choose how to read the notes

    private static void review(LinkedList<Note> postList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

//create listiterator of postlist
        ListIterator<Note> listIterator = postList.listIterator();

//first check if the postlist have studynotes in it

        if (postList.size() == 0) {
            System.out.println("This postlist has no note to review");
        }else{
//the postlist is not empty and printout the menu and let user to operate
            System.out.println("Now review "+ listIterator.next().toString());
            printMenu();
        }

//if user doesn't choose to quit(type 0), read the input of the int
        while (!quit) {
            int operation = sc.nextInt();
            sc.nextLine();

//use switch to catogorize the operation of the user
            switch (operation){
                case 0:
                    System.out.println("Postlist is over");
                    quit = true;
                    break;
//show next. need to check if there is a next note.
                case 1:
                    if(!forward){
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
 //if there is a next note, printout to read otherwise print out "no note available..."
                    if(listIterator.hasNext()){
                        System.out.println("Now review "+listIterator.next().toString());
                    }else {
                        System.out.println("No note available, reaches the end of the list");
                        forward = false;
                    }break;
//show the previous note, if it exists, printout the note,
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now review "+listIterator.previous().toString());
                    }else {
                        System.out.println("It is the first note");
                        forward=false;
                    }
                    break;
// printout the postlist
                case 3:
                    printList(postList);
                    break;
//printout the operation menu
                case 4:
                    printMenu();
                    break;
//delete the current note, and check if the next note exist, show the next note.
                case 5:
                    if (postList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now review "+listIterator.next().toString());
                        }else {
                            if(listIterator.hasPrevious())
                                System.out.println("Now review "+listIterator.previous().toString());
                        }
                    }

            }
        }

    }

// the function is to print out the menu of the operations
    private static void printMenu(){
        System.out.println("Operation options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to review next note\n"+
                "2 - to review previous note\n"+
                "3 - list of all notes \n"+
                "4 - print all available options\n"+
                "5 - delete current note\n");
    }

// the function is to Iterator all the notes from the postlist and print them out

    private static void printList(LinkedList<Note> postList){
        Iterator<Note> iterator = postList.iterator();
        System.out.println("****************************");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("****************************");
    }

}
