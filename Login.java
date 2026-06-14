/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poep2;

public class Login {
    
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellphone;
    
    public String registerUser(String firstName, String lastName, String username, String password, String cellphone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellphone = cellphone;
        
        if (!username.contains("_") || username.length() > 5) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*\\d.*") || !password.matches(".*[!@#$%^&*].*")) {
            return "Password is not correctly formatted, please ensure that your password contains at least 8 characters, a capital letter, a digit, and a special character.";
        }
        if (!cellphone.matches("\\+27[0-9]{9}")) {
            return "Cellphone number is not correctly formatted, please ensure that your cellphone number starts with +27 and is followed by 9 digits.";
        }
        return "User has been registered successfully";
    }
    
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
}