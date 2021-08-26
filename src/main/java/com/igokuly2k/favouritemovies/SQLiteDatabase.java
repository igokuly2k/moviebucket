/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igokuly2k.favouritemovies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author igoku
 */
public class SQLiteDatabase {

    private static SQLiteDatabase obj;
    private Connection c;

    private SQLiteDatabase() {
        try {
            String sql = "CREATE TABLE MOVIES IF NOT EXISTS "
                    + "(MOVIENAME TEXT,"
                    + "LEADACTOR TEXT,"
                    + "LEADACTRESS TEXT,"
                    + "YEAROFRELEASE TEXT,"
                    + "DIRECTOR TEXT)";
            c = DriverManager.getConnection("movies.db");
            Statement stmt = c.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Database cannot be created");
        }
    }

    public static SQLiteDatabase getInstance() {
        if (obj == null) {
            obj = new SQLiteDatabase();
        }
        return obj;
    }

    public void addMovie(Movie m) {
        String sql = "INSERT INTO MOVIES VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(0,m.getMovieName());
            stmt.setString(1, m.getLeadActor());
            stmt.setString(2, m.getLeadActress());
            stmt.setString(3, m.getYearOfRelease());
            stmt.setString(4, m.getDirector());
            stmt.executeUpdate();
        } catch (SQLException e) {
            
        }
    }

    public ArrayList<Movie> queryAllMovie() {
        ArrayList<Movie> list = new ArrayList<>();
        String sql="SELECT * FROM MOVIES";
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(!rs.next()){
                Movie m = new Movie(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                list.add(m);
            }
        } catch (SQLException e) {

        }
        return list;
    }
}
