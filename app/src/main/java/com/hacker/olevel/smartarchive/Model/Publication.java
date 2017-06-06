package com.hacker.olevel.smartarchive.Model;

/**
 * File: Publication.java
 * Desc: This refers to a model of a given publication belonging to a particular
 *          faculty, department and year group
 *
 * Created by olevel on 6/5/17.
 */

public class Publication {
    public String topic;
    public String synopsis;
    public String author;
    public String supervisor; // can be more than one and shall be comma separated values
    public int publicationDate;
    public String departmentCode;

    public Publication(String topic, String synopsis, String author, String supervisor, int publicationDate, String departmentCode) {
        this.author = author;
        this.synopsis = synopsis;
        this.author = author;
        this.supervisor = supervisor;
        this.publicationDate = publicationDate;
        this.departmentCode = departmentCode;
    }

}
