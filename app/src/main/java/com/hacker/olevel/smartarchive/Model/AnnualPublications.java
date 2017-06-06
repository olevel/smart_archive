package com.hacker.olevel.smartarchive.Model;

/**
 * File: AnnualPublications.java
 * Desc: Handles project works published in a particular year
 *
 * Created by olevel on 6/6/17.
 */

public class AnnualPublications {
    public String year;
    public String departmentCode;
    public String category;

    public AnnualPublications(String departmentCode, String year) {
        this.year = year;
        this.departmentCode = departmentCode;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

}
