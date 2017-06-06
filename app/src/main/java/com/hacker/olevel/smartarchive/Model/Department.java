package com.hacker.olevel.smartarchive.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * File: Department.java
 * Desc: Represents a department model and a department object.
 *          Consist mainly of department name, code, and faculty
 * Created by olevel on 6/5/17.
 */

public class Department implements Serializable {
    private String name;
    private String code;
    private String faculty;
    public int establishmentDate;
    private int closureDate;
    private boolean isClosed = false;

    public Department(String name, String code, String faculty) {
        this.name = name;
        this.code = code;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setDissolved(boolean isOperational, Date dissolutionDate) {
        this.isClosed = isOperational;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dissolutionDate);

        this.closureDate = calendar.get(Calendar.YEAR);
    }

    public ArrayList<String> getYearGroups(int establishmentDate) {
        this.establishmentDate = establishmentDate;

        ArrayList<String> yearGroups = new ArrayList<>();
        if (isClosed) {
            // Department is dissolved so calculate years between establishmentDate and closureDate
            for (int i = closureDate; i > (establishmentDate - 1); i--) {
                yearGroups.add(i +"");
            }
        } else {
            // Get total number of years between year of institution and now
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            int currentYear = calendar.get(Calendar.YEAR);

            for (int i = currentYear; i > (establishmentDate - 1); i--) {
                yearGroups.add(i +"");
            }
        }

        return yearGroups;
    }
}
