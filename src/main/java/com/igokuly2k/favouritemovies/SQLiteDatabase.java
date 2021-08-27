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
            String sql = "CREATE TABLE IF NOT EXISTS MOVIES "
                    + "(MOVIENAME TEXT,"
                    + "LEADACTOR TEXT,"
                    + "LEADACTRESS TEXT,"
                    + "YEAROFRELEASE TEXT,"
                    + "DIRECTOR TEXT)";
            c = DriverManager.getConnection("jdbc:sqlite:movies.db");
            Statement stmt = c.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static SQLiteDatabase getInstance() {
        if (obj == null) {
            obj = new SQLiteDatabase();
        }
        return obj;
    }

    public void addMovie(Movie m) {
        String sql = "INSERT INTO MOVIES(MOVIENAME,LEADACTOR,LEADACTRESS,YEAROFRELEASE,DIRECTOR) "
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1,m.getMovieName());
            stmt.setString(2, m.getLeadActor());
            stmt.setString(3, m.getLeadActress());
            stmt.setString(4, m.getYearOfRelease());
            stmt.setString(5, m.getDirector());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Movie> queryAllMovie() {
        ArrayList<Movie> list = new ArrayList<>();
        String sql="SELECT MOVIENAME,LEADACTOR,LEADACTRESS,YEAROFRELEASE,DIRECTOR FROM MOVIES";
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Movie m = new Movie(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                list.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public ArrayList<Movie> queryFilter(String category, String searchFilter){
        ArrayList<Movie> list = new ArrayList<>();
        String sql = "SELECT MOVIENAME,LEADACTOR,LEADACTRESS,YEAROFRELEASE,DIRECTOR FROM MOVIES WHERE "+category+" LIKE \'%"+searchFilter+"%\'";
        try{
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Movie m = new Movie(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                list.add(m);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }
}
