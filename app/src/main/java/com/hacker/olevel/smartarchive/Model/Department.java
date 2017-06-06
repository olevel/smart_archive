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
    public String name;
    public String code;
    private String faculty;
    public int establishmentDate;
    public int closureDate;
    public boolean isClosed = false;

    public Department(String name, String code, String faculty, int establishmentDate) {
        this.name = name;
        this.code = code;
        this.faculty = faculty;
        this.establishmentDate = establishmentDate;
    }

    public ArrayList<String> getYearGroups() {
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
