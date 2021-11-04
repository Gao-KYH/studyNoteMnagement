package com.example;

public interface studyItems {
    /**
     * add reading time to the study
     * @param content
     */
    void readingTime(String content);
    void writingTime(String exercise);

//    void usedByReading(int hour);
//    void usedByWriting(int hour);

    /**
     * turn on havingExam to decide whether adding more hours
     */

    void addingMoreTime();
    boolean havingExam();
}
