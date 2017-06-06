package com.hacker.olevel.smartarchive.Controller;

import com.hacker.olevel.smartarchive.Model.Department;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * File: DepartmentHandler.java
 * Desc: Hold department names and codes
 *
 * Created by oposinii on 6/4/17.
 */

public class DepartmentHandler {
    private List<Department> departments = new ArrayList<>();
    private List<String> faculties = new ArrayList<>();

    public DepartmentHandler() {
        faculties.add("Faculty of Mineral Resources Technology");
        faculties.add("Faculty of Engineering");

        departments.add(new Department("Computer Science and Engineering", "CE", "Foe", 2004));
        departments.add(new Department("Electrical and Electronics Engineering", "EL", "Foe", 1998));
        departments.add(new Department("Mechanical Engineering", "MC", "Foe", 1998));
        departments.add(new Department("Mathematics", "MA", "Foe", 2002));

        departments.add(new Department("Environmental and Safety Engineering", "ES", "Fmrt", 2017));
        departments.add(new Department("Geology Engineering", "GL", "Fmrt", 1992));
        departments.add(new Department("Geomatics Engineering", "GM", "Fmrt", 1992));
        departments.add(new Department("Minerals Engineering", "MR", "Fmrt", 1992));
        departments.add(new Department("Mining Engineering", "MN", "Fmrt", 1992));
        departments.add(new Department("Petroleum Engineering", "PE", "Fmrt", 2008));

    }

    public List<Department> getDepartments() {
        return departments;
    }
    public List<String> getFaculties() {
        return faculties;
    }


}
