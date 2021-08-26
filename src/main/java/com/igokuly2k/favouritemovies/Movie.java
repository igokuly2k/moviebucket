/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igokuly2k.favouritemovies;

import java.util.Calendar;

/**
 *
 * @author igoku
 */
public class Movie {

    private String movieName;
    private String leadActress;
    private String yearOfRelease;
    private String director;
    private String leadActor;

    public Movie(String movieName, String leadActor, String leadActress, String yearOfRelease, String director) {
        this.movieName = movieName;
        this.leadActor = leadActor;
        this.leadActress = leadActress;
        this.yearOfRelease = yearOfRelease;
        this.director = director;
    }

    public boolean validateYear(String year) {
        int a;
        try {
            a = Integer.parseInt(year);
            return a >= 1800 && a <= Calendar.getInstance().getWeekYear();
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String getMovieName() {
        return movieName;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public String getLeadActress() {
        return leadActress;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public String getDirector() {
        return director;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

    public void setLeadActress(String leadActress) {
        this.leadActress = leadActress;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
