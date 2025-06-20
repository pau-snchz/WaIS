/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modules;

import com.mycompany.modules.tables.*;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Datuin
 */
public class WasteSorterIdentifier {
    
    public static List<WasteItems> searchItems(String search) {
        List<WasteItems> results = new ArrayList<>();

        String query = "SELECT * FROM wasteitems WHERE name = ?";
        search = search.trim(); // Remove leading/trailing spaces

        System.out.println("Executing query: " + query + " with search: '" + search + "'"); // Debugging

        try (Connection connect = DatabaseUtility.getConnection();
             PreparedStatement prepStatement = connect.prepareStatement(query)) 
        {
            prepStatement.setString(1, search);

            try (ResultSet result = prepStatement.executeQuery()) 
            {
                while (result.next()) 
                {
                    results.add(new WasteItems(
                        result.getInt("waste_id"),
                        result.getString("name"),
                        result.getString("classification")
                    ));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Items found: " + results.size()); // Debugging
        return results;
    }
    
    public static List<RecyclingIdeas> getIdeas(int wasteID)
    {
        List<RecyclingIdeas> results = new ArrayList<>();
        
        String query = "SELECT * FROM recyclingidea WHERE waste_id = ?";
        
        try(Connection connect = DatabaseUtility.getConnection();
            PreparedStatement prepStatement = connect.prepareStatement(query))
        {
            prepStatement.setInt(1, wasteID);
            
            try (ResultSet result = prepStatement.executeQuery())
            {   
                while (result.next())
                {
                    results.add(new RecyclingIdeas(result.getInt("idea_id"), result.getInt("acc_id"), result.getInt("waste_id"), result.getString("title"), result.getString("image_url"), result.getString("datecreated")));
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return results;        
    }
    
    public static List<RecyclingIdeas> getIdeas(int wasteID, String title)
    {
        List<RecyclingIdeas> results = new ArrayList<>();
        
        String query = "SELECT * FROM recyclingidea WHERE waste_id = ? AND title = ?";
        
        try(Connection connect = DatabaseUtility.getConnection();
            PreparedStatement prepStatement = connect.prepareStatement(query))
        {
            prepStatement.setInt(1, wasteID);
            prepStatement.setString(2, title);
            
            try (ResultSet result = prepStatement.executeQuery())
            {   
                while (result.next())
                {
                    results.add(new RecyclingIdeas(result.getInt("idea_id"), result.getInt("acc_id"), result.getInt("waste_id"), result.getString("title"), result.getString("image_url"), result.getString("datecreated")));
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return results;        
    }
    
    public static List<Materials> getMaterials(int ideaID)
    {
        List<Materials> materials = new ArrayList<>();
        
        String query = "SELECT * FROM material_details WHERE idea_id = ?";
        
        System.out.println("Executing query: " + query + " with search: '" + ideaID + "'");
        
        try(Connection connect = DatabaseUtility.getConnection();
            PreparedStatement prepStatement = connect.prepareStatement(query))
        {
            prepStatement.setInt(1, ideaID);
            
            try (ResultSet result = prepStatement.executeQuery())
            {   
                System.out.println(result);
                while (result.next())
                {
                    materials.add(new Materials(result.getInt("matdet_id"), result.getInt("idea_id"), result.getString("name"), result.getString("quantity")));
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        System.out.println("Items found: " + materials.size());
        return materials;        
    }
    public static List<Steps> getSteps(int ideaID)
    {
        List<Steps> steps = new ArrayList<>();
        
        String query = "SELECT * FROM steps_details WHERE idea_id = ? ORDER BY `order` ASC";
        
        System.out.println("Executing query: " + query + " with search: '" + ideaID + "'");
        
        try(Connection connect = DatabaseUtility.getConnection();
            PreparedStatement prepStatement = connect.prepareStatement(query))
        {
            prepStatement.setInt(1, ideaID);
            
            try (ResultSet result = prepStatement.executeQuery())
            {   
                System.out.println(result);
                while (result.next())
                {
                    steps.add(new Steps(result.getInt("step_id"), result.getInt("idea_id"), result.getString("step_title"), result.getString("step_description"), result.getInt("order")));
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        System.out.println("Items found: " + steps.size());
        return steps;        
    }
    public static String getAuthor(int accID)
    {
        String query = "SELECT * FROM accountdetails WHERE acc_id = ?";
        
        try(Connection connect = DatabaseUtility.getConnection();
            PreparedStatement prepStatement = connect.prepareStatement(query))
        {
            prepStatement.setInt(1, accID);
            
            try (ResultSet result = prepStatement.executeQuery())
            {   
                if(result.next())
                {
                    return result.getString("name");
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
