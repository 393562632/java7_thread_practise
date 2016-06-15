package com.java7.current.chapter7.case7_10;

/**
 * Created by jackeyChen on 2016/6/14.
 */
public class Event implements Comparable<Event> {
    private String thread;
    private int priority;

    public Event(String thread, int priority) {
        this.thread = thread;
        this.priority = priority;
    }


    @Override
    public int compareTo(Event e) {
        if(this.priority > e.getPriority()) {
            return -1;
        } else if(this.priority < e.getPriority()) {
            return 1;
        }
        return 0;
    }

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
