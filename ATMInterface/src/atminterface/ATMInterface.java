/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atminterface;

import java.util.Scanner;

class ATM {

    int PIN = 2182;
    float TotalAmount;

    public void run() {
        System.out.print("Enter Your PIN: ");
        Scanner sc = new Scanner(System.in);
        int enterIN = sc.nextInt();

        if (enterIN == PIN) {
            displayopions();
        } else {
            System.out.println("Oops!! Invalid choice. Please try again..!!");
            run();
        }
    }

    public void displayopions() {
        System.out.println();
        System.out.println("Menu");
        System.out.println("1. Check Account Balance ");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
        System.out.println();
        System.out.print("Enter Your Choice: ");
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        if (op == 1) {
            runBalance();
        } else if (op == 2) {
            withdraw();
        } else if (op == 3) {
            deposit();
        } else if (op == 4) {
            System.out.println("Thankyou for using the ATM");
            System.out.println();
            System.out.println();
            return;
        } else {
            System.out.println("Oops!! Invalid choice. Please try again..!!!!");
        }
    }

    // To check balance opion
    public void runBalance() {
        System.out.println("Your balance : " + TotalAmount);
        System.out.println();
        System.out.print("Press 0 for exit OR Press 1 for menu:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if (choice == 0) {
            System.out.println();
            System.out.println();
            System.out.println("Thankyou for using the ATM");
            System.out.println();
            System.out.println();
            return;
        } else if (choice == 1) {
            displayopions();
        } else {
            System.out.println("Oops!! Invalid choice. Please try again..!!!!");
        }
    }

    // To withdraw money opion
    public void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        if (amount > TotalAmount) {
            System.out.println("Insufficient Balance. Unable to Withdraw ");
            System.out.println();
            System.out.println("Press 0 for exit OR press 1 for menu: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println();
                System.out.println();
                System.out.println("Thankyou for using the ATM");
                System.out.println();
                System.out.println();
                return;
            } else if (choice == 1) {
                displayopions();
            } else {
                System.out.println("Oops!! Invalid Input...!!");
            }
        } else {
            TotalAmount = TotalAmount - amount;
            System.out.println(" Money Withdrawl Successfully..!!");
            System.out.println();
            System.out.print("Press 0 for exit OR press 1 for menu: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println();
                System.out.println();
                System.out.println("Thankyou for using the ATM");
                System.out.println();
                System.out.println();
                return;
            } else if (choice == 1) {
                displayopions();
            } else {
                System.out.println("Oops!! Invalid choice Input..!!");
            }
        }
    }

    // to deposit money opion
    public void deposit() {
        System.out.print("Enter the amount to deposit: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        if (amount < 0) {
            System.out.println("Oops!! Invalid Input..! ");
            System.out.println();
            System.out.print("Press 0 for exit OR press 1 for menu: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println();
                System.out.println();
                System.out.println("Thankyou for using the ATM");
                System.out.println();
                System.out.println();
                return;
            } else if (choice == 1) {
                displayopions();
            } else {
                System.out.println("Oops!! Invalid Input..!!");
            }
        } else {
            TotalAmount = TotalAmount + amount;
            System.out.println("Money Deposited Successfully..!!");
            System.out.println();
            System.out.print("Press 0 for exit OR press 1 for menu: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println();
                System.out.println();
                System.out.println("Thankyou for using the ATM");
                System.out.println();
                System.out.println();
                return;
            } else if (choice == 1) {
                displayopions();
            } else {
                System.out.println("Oops!! Invalid Input..!!");
            }
        }
    }
}

public class ATMInterface {
    public static void main(String[] args ) {
        System.out.println();
        System.out.println("<-----Welome to ATM Mahine----->");
        System.out.println();
        System.out.println();
        ATM obj = new ATM();
        obj.run();
    }
}