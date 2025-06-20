/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modules;

import com.mycompany.modules.tables.Accounts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Datuin
 */
public class UserAuthenticator {
    
    
    public static boolean updateAccount(String field, String newValue, int accountID)
    {
        List<String> validFields = Arrays.asList("name", "email", "contact_info");
        if (!validFields.contains(field)) {
            JOptionPane.showMessageDialog(null, "Invalid field update request!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(field.equals("email"))
        {
            boolean emailValid = checkEmailAvailability(newValue);
            if (!emailValid)
            {
                return false;
            }
        }    
        
        String query = "UPDATE accountdetails SET " + field + " = ? WHERE acc_id = ?";

        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, newValue);
            stmt.setInt(2, accountID);  

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Update successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } 
            else
            {
                JOptionPane.showMessageDialog(null, "No changes were made. Please check the input.", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error updating " + field + ": " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static boolean checkEmailAvailability(String email) {
        String checkQuery = "SELECT COUNT(*) FROM accountdetails WHERE Email = ?";

        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement checkStmt = con.prepareStatement(checkQuery)) {

            checkStmt.setString(1, email);
            ResultSet rs = checkStmt.executeQuery();

            return rs.next() && rs.getInt(1) == 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Assume false to avoid errors, but log the error
        }
    }

    public static boolean signUpAccount(String fullName, String email, String phoneNum, String password) {
        if (!checkEmailAvailability(email)) {
            JOptionPane.showMessageDialog(null, "Email already in use. Please use a different email.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String insertQuery = "INSERT INTO accountdetails (name, email, contact_info, password) VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement insertStmt = con.prepareStatement(insertQuery)) {

            insertStmt.setString(1, fullName);
            insertStmt.setString(2, email);
            insertStmt.setString(3, phoneNum);
            insertStmt.setString(4, password);
            insertStmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sign Up Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static List<Accounts> getAccount(String email, String password)
    {
        List<Accounts> account = new ArrayList<>();
        
        String query = "SELECT * FROM accountdetails WHERE email = ? AND password = ?";
        
        try(Connection connect = DatabaseUtility.getConnection();
            PreparedStatement prepStatement = connect.prepareStatement(query))
        {
            prepStatement.setString(1, email);
            prepStatement.setString(2, password);
            
            try (ResultSet result = prepStatement.executeQuery())
            {
                while (result.next())
                {
                    account.add(new Accounts(result.getInt("acc_id"), result.getString("name"), result.getString("email"), result.getString("contact_info"), result.getString("password")));
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return account;
    }
    
    public static boolean authenticateLogin(String email, String password)
    {
        return !getAccount(email, password).isEmpty();
    }
    
}
