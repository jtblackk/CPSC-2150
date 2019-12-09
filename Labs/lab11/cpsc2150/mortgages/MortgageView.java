package cpsc2150.mortgages;

import java.util.Scanner;

/**
 * view layer of MVC architecture for Mortgage app
 */

public class MortgageView implements IMortgageView {
    private Scanner console;
    private IMortgageController controller;

    MortgageView(){
        console = new Scanner(System.in);
        //don't worry about initializing controller. handled by setController
    }

    //interface method implementations
    /**
     * {see IMortgageView.setController}
     */
    public void setController(IMortgageController c){
        controller = c;
    }

    /**
     * {see IMortgageView.getHouseCost}
     */
    public double getHouseCost(){
        return console.nextDouble();
    }

    /**
     * {see IMortgageView.getDownPayment}
     */
    public double getDownPayment(){
        return console.nextDouble();
    }

    /**
     * {see IMortgageView.getYears}
     */
    public int getYears(){
        return console.nextInt();
    }

    /**
     * {see IMortgageView.getMonthlyDebt}
     */
    public double getMonthlyDebt(){
        return console.nextDouble();
    }

    /**
     * {see IMortgageView.getYearlyIncome}
     */
    public double getYearlyIncome(){
        return console.nextDouble();
    }

    /**
     * {see IMortgageView.getCreditScore}
     */
    public int getCreditScore(){
        return console.nextInt();
    }

    /**
     * {see IMortgageView.getName}
     */
    public String getName(){
        return console.nextLine();
    }

    /**
     * {see IMortgageView.printToUser}
     */
    public void printToUser(String s){
        System.out.println(s);
    }

    /**
     * {see IMortgageView.displayPayment}
     */
    public void displayPayment(double p){ System.out.println("Monthly Payment: $" + p); }

    /**
     * {see IMortgageView.displayRate}
     */
    public void displayRate(double r){
        r *= 100;
        System.out.println("Interest Rate: " + r + "%");
    }

    /**
     * {see IMortgageView.displayApproved}
     */
    public void displayApproved(boolean a){
        if(a){
            System.out.println("Loan approved");
        }
        else{
            System.out.println("Loan denied");
        }
    }

    /**
     * {see IMortgageView.getAnotherMortgage}
     */
    public boolean getAnotherMortgage(){
        //get choice
        String choice;
        do{
            System.out.println("Would you like to apply for another mortgage? Y/N");
            choice = console.next();
            console.nextLine();
        }
        while(!(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")));

        //return choice
        if(choice.equalsIgnoreCase("y")){
            return true;
        }
        return false;
    }

    /**
     * {see IMortgageView.getAnotherCustomer}
     */
    public boolean getAnotherCustomer(){
        //get choice
        String choice;
        do{
            System.out.print("Would you like to consider another customer? Y/N \n");
            choice = console.next();
            console.nextLine();
        }
        while(!(choice.equalsIgnoreCase("y") ||choice.equalsIgnoreCase("n")));

        //return choice
        if(choice.equalsIgnoreCase("y")){
            return true;
        }
        return false;
    }

}
