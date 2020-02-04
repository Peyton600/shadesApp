package com.example.peytons_hotwheels;

public class Auto {
    static final double STATE_TAX = 0.07;
    static final double INTREST_RATE = .09;
    private double mPrice;
    private double mDownPayment;
    private int mLoanTerm;

    public void setPrice(double mPrice) {
        this.mPrice = mPrice;
    }
    public double getPrice(){
        return mPrice;
    }
    public void setDownPayment(double down){
        mDownPayment = down;
    }
    public double getDownPayment(){
        return mDownPayment;
    }
    public void setLoanTerm(String term){
        if(term.contains("15"))
            mLoanTerm=15;
        else if (term.contains("20"))
            mLoanTerm= 20;
         else
             mLoanTerm = 30;
    }
    public int getLoanTerm(){
        return mLoanTerm;
    }
    public double taxAmount(){
        return mPrice*STATE_TAX;

    }
    public double totalCost(){
        return mPrice+taxAmount();
    }
    public double borrowedAmount(){
        return totalCost()- mDownPayment;
    }
    public double intrestAmount(){
        return borrowedAmount()* INTREST_RATE;

    }
    public double monthlyPayment(){
        return (borrowedAmount() + intrestAmount())/(mLoanTerm * 12);
    }


}
