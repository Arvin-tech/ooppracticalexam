package com.example.saguisa_ooppracticalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText loanAmount;
    Button small, big;
    TextView output; //interest output
    Bank bank = new Bank();
    double inputtedLoan = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find
        findViewById();

        //click
        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displaySBResult();
            }
        });

        //click
        big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputtedLoan = Double.parseDouble(loanAmount.getText().toString());
                displayBBResult();
            }
        });
    }

    public void findViewById(){
        loanAmount = findViewById(R.id.LoanAmountEditText);
        small = findViewById(R.id.SmallBankButton);
        big = findViewById(R.id.BigBankButton);
        output = findViewById(R.id.outputTextview);
    }

    public void displaySBResult(){
       //SmallBank sb = new SmallBank(inputtedLoan);
        //double result = sb.return_interest();
        //String finalRes = new Double(result).toString();
        //output.setText(finalRes);
        inputtedLoan = Double.parseDouble(loanAmount.getText().toString());
        Bank bank = new SmallBanks(); //small banks as actual object
        double interest = bank.computeInterest(inputtedLoan);
        output.setText(String.format("%.2f", interest));
    }

    public void displayBBResult(){
        //BigBank bb = new BigBank(inputtedLoan);
        //double result = bb.return_interest();
        //String finalRes = new Double(result).toString();
        //output.setText(finalRes);

        inputtedLoan = Double.parseDouble(loanAmount.getText().toString());
        Bank bank = new BigBanks();
        double interest = bank.computeInterest(inputtedLoan);
        output.setText(String.format("%.2f", interest));
    }

 public class Bank {
        private double loan_amount;
        private double interestRate = 0.04;
        private double interest;

        public Bank(){
            loan_amount = 0;
            interest = 0;
        }

        public Bank (double loan_amount){
            this.loan_amount = loan_amount;
        }

        public void computeInterest(double loanAmount, double interestRate){
            int n = 12;
            interest = loanAmount * (Math.pow(1 + interestRate / n, n)-1);
            setInterest(interest);
        }

        public void setInterest(double interest){
            this.interest = interest;
        }

        public double getInterest(){
            return interest;
        }

        public void setLoan_amount(double loan_amount){
            this.loan_amount = loan_amount;
        }
        public double getLoan_amount(){
            return loan_amount;
        }

        public double return_interest(){
            double returnInt = getInterest();
            return returnInt;
        }
    }

  public  class BigBank extends Bank {

        private double interestRate = 0.05;
        private double interest;

        public BigBank(double loan_amount){
            super(loan_amount);
        }

        @Override
        public void computeInterest(double loanAmount, double interestRate){
            int n = 12;
            double interest = loanAmount * (Math.pow(1 + interestRate / n, n)-1);
        }

        public double getInterest(){
            return interest;
        }
    }

    public class SmallBank extends Bank {

        private double interestRate = 0.03;
        double interest;

        public SmallBank(double loan_Amount){
            super(loan_Amount);
        }

        @Override
        public void computeInterest(double loanAmount, double interestRate){
            int n = 12;
            double interest = getLoan_amount();
            setInterest(interest);
        }
        public double getInterest(){
            return interest;
        }
    }
}




