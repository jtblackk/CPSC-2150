package cpsc2150.mortgages;

public class MortgageController implements IMortgageController {
    private IMortgageView view;

    MortgageController(IMortgageView v){
        view = v;
    }

    public void submitApplication(){
        boolean anotherCustomer = true;
        do {
            //------------get customer info------------//
            ICustomer customer;

            //get name
            view.printToUser("What's your name?");
            String name = view.getName();

            //get yearly income
            Double yearlyIncome = Double.MIN_VALUE; //set to min value to ignore error message
            do {
                //error message if user entered an invalid value
                if (yearlyIncome != Double.MIN_VALUE) {
                    view.printToUser("Income must be greater than " + ICustomer.MIN_YEARLY_INCOME + ".");
                }
                //get income from user
                view.printToUser("How much is your yearly income?");
                yearlyIncome = view.getYearlyIncome();
            }
            while (!(yearlyIncome > ICustomer.MIN_YEARLY_INCOME));

            //get monthly debt payments
            Double monthlyDebt = Double.MIN_VALUE; //set to min value to ignore error message
            do {
                //error message if user entered an invalid value
                if (monthlyDebt != Double.MIN_VALUE) {
                    view.printToUser("Debt must be greater than or equal to " + ICustomer.MIN_MONTHLY_DEBT + ".");
                }
                //get monthly debt from user
                view.printToUser("How much are your monthly debt payments?");
                monthlyDebt = view.getMonthlyDebt();
            }
            while (!(monthlyDebt >= ICustomer.MIN_MONTHLY_DEBT));

            //get credit score
            Integer creditScore = Integer.MIN_VALUE; //set to min value to ignore error message
            do {
                //error message if user entered an invalid value
                if (creditScore != Integer.MIN_VALUE) {
                    view.printToUser("Credit Score must be greater than " + ICustomer.MIN_CREDIT_SCORE + " and less than " + ICustomer.MAX_CREDIT_SCORE + ".");
                }
                //get credit score from user
                view.printToUser("What is your credit score?");
                creditScore = view.getCreditScore();
            }
            while (!(creditScore > ICustomer.MIN_CREDIT_SCORE && creditScore < ICustomer.MAX_CREDIT_SCORE));

            //initialize customer
            customer = new Customer(monthlyDebt, yearlyIncome, creditScore, name);

            boolean anotherMortgage = true;
            do {
                //------------get mortgage info------------//
                IMortgage mortgage;
                //get cost of house
                Double cost = Double.MIN_VALUE; //set to min value to ignore error message
                do {
                    //error message if user entered an invalid value
                    if (cost != Double.MIN_VALUE) {
                        view.printToUser("Cost must be greater than " + IMortgage.MIN_HOUSE_COST + ".");
                    }
                    //get cost of house
                    view.printToUser("How much does the house cost?");
                    cost = view.getHouseCost();
                }
                while (!(cost > IMortgage.MIN_HOUSE_COST));

                //get down payment
                Double downPay = Double.MIN_VALUE; //set to min value to ignore error message
                do {
                    //error message if user entered an invalid value
                    if (downPay != Double.MIN_VALUE) {
                        view.printToUser("Down Payment must be greater than " + IMortgage.MIN_DOWN_PAYMENT + " and less than the cost of the house.");
                    }
                    //get down payment
                    view.printToUser("How much is the down payment?");
                    downPay = view.getDownPayment();
                }
                while (!(downPay > IMortgage.MIN_DOWN_PAYMENT && downPay < cost));

                //get number of years
                Integer term = Integer.MIN_VALUE; // set to min value to ignore error message
                do {
                    //error message if user entered an invalid value
                    if (term != Integer.MIN_VALUE) {
                        view.printToUser("Years must be greater than " + IMortgage.MIN_TERM);
                    }
                    //get number of years
                    view.printToUser("How many years?");
                    term = view.getYears();
                }
                while (!(term > IMortgage.MIN_TERM));

                //instantiate mortgage
                mortgage = new Mortgage(cost, downPay, term, customer);

                //------------print summary------------//
                view.printToUser("Name: " + name);
                view.printToUser("Income: $" + yearlyIncome);
                view.printToUser("Credit Score: " + creditScore);
                view.printToUser("Monthly Debt: $" + monthlyDebt);
                view.printToUser("Mortgage info:");
                if (mortgage.loanApproved()) {
                    view.printToUser("Principal Amount: $" + mortgage.getPrincipal());
                    view.displayRate(mortgage.getRate());
                    view.printToUser("Term: " + term + " years");
                    view.displayPayment(mortgage.getPayment());
                } else {
                    view.printToUser("Loan Denied");
                }
                anotherMortgage = view.getAnotherMortgage();
            }
            while(anotherMortgage == true);
            anotherCustomer = view.getAnotherCustomer();
        }
        while(anotherCustomer == true);
    }
}
