package com.example;

/* implements interface */

public class IotStudy implements studyItems{

    private String studySubject;
    private boolean isHavingExam;


    public IotStudy(String studySubject) {
        this.studySubject = studySubject;

    }

    @Override
    public void readingTime(String content) {
        System.out.println("You have totally 2 hours reading time for: " + content);
    }


    @Override
    public void writingTime(String exercise) {
        System.out.println("You have totally 3 hours writing time for: " + exercise);
    }


    @Override
    public void addingMoreTime() {
        if(isHavingExam){
            System.out.println("You have exam, you can add two more hours.");

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
        return "IotStudy{" +
                "studySubject='" + studySubject + '\'' +
                ", isHavingExam=" + isHavingExam +
                '}';
    }
}

