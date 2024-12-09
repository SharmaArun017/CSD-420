/*
 * Date: 12/09/2024
 * Course: CSD420-H326 Advanced Java Programming
 * GitHub Repository: https://github.com/SharmaArun017/CSD-420
 * 
 * Program: FanManager of module 10 - assignment10
 * Description: This program is a GUI-based application that allows users to 
 * view and update records in the "fans" table located in the "databasedb" database.
 * 
 * Functionality:
 * 1. Display Button: Retrieves and displays a record based on the provided ID.
 * 2. Update Button: Updates a record in the database with changes made in the GUI fields.
 */

package module10.assignment10;

import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class FanManager extends JFrame {
    private JTextField idField, firstNameField, lastNameField, favoriteTeamField;
    private JButton displayButton, updateButton;

    private Connection con;

    public FanManager() {
        // GUI Setup
        setupGUI();

        // Database Connection
        connectToDatabase();
    }

    private void setupGUI() {
        setTitle("Fan Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        add(firstNameField);

        add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        add(lastNameField);

        add(new JLabel("Favorite Team:"));
        favoriteTeamField = new JTextField();
        add(favoriteTeamField);

        displayButton = new JButton("Display");
        updateButton = new JButton("Update");
        add(displayButton);
        add(updateButton);

        // Add Button Listeners
        displayButton.addActionListener(e -> displayRecord());
        updateButton.addActionListener(e -> updateRecord());

        setVisible(true);
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/databasedb";
            con = DriverManager.getConnection(url, "student1", "pass");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error connecting to database: " + e.getMessage());
        }
    }

    private void displayRecord() {
        try {
            int id = Integer.parseInt(idField.getText());
            String query = "SELECT * FROM fans WHERE ID = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                favoriteTeamField.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(this, "Record not found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error displaying record: " + e.getMessage());
        }
    }

    private void updateRecord() {
        try {
            int id = Integer.parseInt(idField.getText());
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String favoriteTeam = favoriteTeamField.getText();

            String query = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, favoriteTeam);
            pstmt.setInt(4, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Record updated successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Record not found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error updating record: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new FanManager();
    }
}
