/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poep2;


import java.util.Scanner;

public class POEP2 {
    
    private static Scanner input = new Scanner(System.in);
    private static Login login = new Login();
    private static boolean loggedIn = false;
    
    public static void main(String[] args) {
        
        // Load Part 3 test data
        MessagePart3.loadTestData();
        
        int option = 0;
        
        System.out.println("Welcome to QuickChat");
        
        while (option != 4) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Stored Messages (Part 3)");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            option = input.nextInt();
            input.nextLine();
            
            if (option == 1) {
                System.out.print("Enter first name: ");
                String firstName = input.nextLine();
                System.out.print("Enter last name: ");
                String lastName = input.nextLine();
                System.out.print("Enter username: ");
                String username = input.nextLine();
                System.out.print("Enter password: ");
                String password = input.nextLine();
                System.out.print("Enter cellphone number: ");
                String cellphone = input.nextLine();
                
                String result = login.registerUser(firstName, lastName, username, password, cellphone);
                System.out.println(result);
            }
            else if (option == 2) {
                System.out.print("Enter username: ");
                String username = input.nextLine();
                System.out.print("Enter password: ");
                String password = input.nextLine();
                
                if (login.loginUser(username, password)) {
                    loggedIn = true;
                    System.out.println("Welcome " + login.getFirstName() + " " + login.getLastName() + "!");
                    
                    // QuickChat Menu - Exit when user types 3
                    int menu = 0;
                    while (menu != 3) {
                        System.out.println("\nQuickChat Menu:");
                        System.out.println("1. Send Message");
                        System.out.println("2. Show recently sent messages");
                        System.out.println("3. Quit");
                        System.out.print("Choose option: ");
                        menu = input.nextInt();
                        input.nextLine();
                        
                        if (menu == 1) {
                            System.out.print("How many messages to send? ");
                            int count = input.nextInt();
                            input.nextLine();
                            
                            for (int i = 0; i < count; i++) {
                                System.out.println("\n--- Message " + (i + 1) + " ---");
                                System.out.print("Recipient: ");
                                String rec = input.nextLine();
                                System.out.print("Message (max 250 chars): ");
                                String msgText = input.nextLine();
                                
                                Message m = new Message();
                                m.generateID();
                                m.recipient = rec;
                                m.messageText = msgText;
                                m.createMessageHash();
                                
                                System.out.println("\nMessage Details:");
                                System.out.println("ID: " + m.messageID);
                                System.out.println("Hash: " + m.messageHash);
                                System.out.println("Recipient: " + rec);
                                System.out.println("Message: " + msgText);
                                
                                System.out.println("\n1. Send\n2. Disregard\n3. Store");
                                System.out.print("Choose: ");
                                int action = input.nextInt();
                                input.nextLine();
                                
                                String result = "";
                                if (action == 1) {
                                    result = m.SentMessage();
                                } else if (action == 2) {
                                    result = "Message disregarded.";
                                } else if (action == 3) {
                                    result = m.storeMessage();
                                } else {
                                    result = "Invalid option.";
                                }
                                System.out.println(result);
                                System.out.println("Total messages sent: " + Message.totalMessages);
                            }
                        }
                        else if (menu == 2) {
                            System.out.println("Coming Soon.");
                        }
                    }
                    System.out.println("Returning to Main Menu...");
                } else {
                    System.out.println("Invalid username or password.");
                }
            }
            else if (option == 3) {
                if (loggedIn) {
                    StoredMenu.showMenu();
                } else {
                    System.out.println("Please login first!");
                }
            }
        }
        
        System.out.println("Thank you for using QuickChat!");
        input.close();
    }
}
