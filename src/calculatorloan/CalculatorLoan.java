/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package CalculatorLoan;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author usu2dam
 */
public class CalculatorLoan extends Application {
    
    private final TextField TFAnnualInt = new TextField();
    private final TextField TFNumberOfYears = new TextField();
    private final TextField TFLoanAmoun = new TextField();
    private final TextField TFMonthlyPay = new TextField();
    private final TextField TFTotalPay = new TextField();
    private final Button btn = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) {
        
        GridPane gridPane = new GridPane();

        
        gridPane.add(new Label("Annual Interest Rate:"), 0, 0);
        gridPane.add(TFAnnualInt, 1, 0);
        
        gridPane.add(new Label("Number of Years:"), 0, 1);
        gridPane.add(TFNumberOfYears, 1, 1);
        
        gridPane.add(new Label("Loan Amount:"), 0, 2);
        gridPane.add(TFLoanAmoun, 1, 2);
        
        gridPane.add(new Label("Monthly Payment:"), 0, 3);
        gridPane.add(TFMonthlyPay, 1, 3);
        
        gridPane.add(new Label("Total Payment:"), 0, 4);
        gridPane.add(TFTotalPay, 1, 4);
        
        gridPane.add(btn, 1, 5);
        btn.setOnAction(e -> calculateLoanPayment());
        
        Scene scene = new Scene(gridPane, 300, 250);
        
        primaryStage.setTitle("CalculatorLoan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void calculateLoanPayment() 
    {
        double interess = Double.parseDouble(TFAnnualInt.getText());
        int ano = Integer.parseInt(TFNumberOfYears.getText());
        double cantidad = Double.parseDouble(TFLoanAmoun.getText());
        
        Loan loan = new Loan(interess, ano, cantidad);
        TFMonthlyPay.setText(String.format("$%.2f", loan.getMonthlyPayment()));
        TFTotalPay.setText(String.format("$%.2f", loan.getTotalPayment()));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

class Loan
{
    private double AnnualInt;
    private double cantidad;
    private int NumberOfYears;
    public Loan(double AnnualInterest, int NumberOfYears, double cantidad) 
    {
        this.AnnualInt = AnnualInterest;
        this.NumberOfYears = NumberOfYears;
        this.cantidad = cantidad;
    }
    public double getAnnualInt() 
    {
        return AnnualInt;
    }
    public double getLoanAmount() 
    {
        return cantidad;
    }
    public int getNumberOfYears() 
    {
        return NumberOfYears;
    }
    public double getMonthlyPayment() 
    {
        double monthlyInterestRate = AnnualInt / 1200;
        double monthlyPayment = cantidad * monthlyInterestRate / (1 - (Math.pow(1 / (1 + monthlyInterestRate), NumberOfYears * 12)));
        return monthlyPayment;
    }
    public double getTotalPayment() 
    {
        double total = getMonthlyPayment() * NumberOfYears * 12;
        return total;
    }
    public void setAnnualInt(double AnnualInt) 
    {
        this.AnnualInt = AnnualInt;
    }
    public void setLoanAmount(double cantidad) 
    {
        this.cantidad = cantidad;
    }
    public void setNumberOfYears(int numberOfYears) 
    {
        this.NumberOfYears = numberOfYears;
    }
}

