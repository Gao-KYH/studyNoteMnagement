package com.example;

/* implements interface */

public class HRStudy implements studyItems {

    private String studySubject;
    private boolean isHavingExam;

    public HRStudy(String studySubject) {
        this.studySubject = studySubject;

    }


    @Override
    public void readingTime(String articles) {
        System.out.println("You have totally 3 hours reading time for: " + articles);
    }


    @Override
    public void writingTime(String content) {
        System.out.println("You have totally 2 hours writing time for " + content);
    }


    @Override
    public void addingMoreTime() {

        if(isHavingExam){
            System.out.println("You have exam, you can add two more hours.");
            isHavingExam = false;
        }else {
            System.out.println("Continue studying tomowwor.");
        }
    }

    @Override
    public boolean havingExam() {
        return isHavingExam;

    }

    @Override
    public String toString() {
        return "HRStudy{" +
                "studySubject='" + studySubject + '\'' +
                ", isHavingExam=" + isHavingExam +
                '}';
    }
}


