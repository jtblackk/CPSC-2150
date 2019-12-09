package cpsc2150.mortgages;

public class MortgageController implements IMortgageController {
    private IMortgageView view;

    MortgageController(IMortgageView v){
        view = v;
    }

    public void submitApplication(){
        //clear error label
        view.printToUser("");

        //------------get customer info------------//
        String name = view.getName();
        // check that name precondition met; alert if not
        if (name.length() < 1) {
            view.printToUser("Must enter a name.");
        }

        Double yearlyIncome = view.getYearlyIncome();
        // check that yearly precondition met; alert if not
        if (yearlyIncome < ICustomer.MIN_YEARLY_INCOME) {
            view.printToUser("Income must be at least $" + ICustomer.MIN_YEARLY_INCOME + ".");
        }

        Double monthlyDebt = view.getMonthlyDebt();
        // check that monthly debt precondition met; alert if not
        if(monthlyDebt < ICustomer.MIN_MONTHLY_DEBT){
            view.printToUser("Debt must be at least $" + ICustomer.MIN_MONTHLY_DEBT + ".");
        }

        Integer creditScore = view.getCreditScore();
        // check that credit score precondition met; alert if not
        if (creditScore < ICustomer.MIN_CREDIT_SCORE || creditScore > ICustomer.MAX_CREDIT_SCORE) {
            view.printToUser("Credit Score must be at least " + ICustomer.MIN_CREDIT_SCORE + " and at most " + ICustomer.MAX_CREDIT_SCORE + ".");
        }


        //------------initialize customer------------//
        ICustomer customer = new Customer(monthlyDebt, yearlyIncome, creditScore, name);


        //------------get mortgage info------------//
        Double houseCost = view.getHouseCost();
        // check that house cost precondition met; alert if not
        if (houseCost < IMortgage.MIN_HOUSE_COST) {
            view.printToUser("Cost must be at least $" + IMortgage.MIN_HOUSE_COST + ".");
        }

        Double downPayment = view.getDownPayment();
        // check that down payment precondition met; alert if not
        if (downPayment < IMortgage.MIN_DOWN_PAYMENT || downPayment > houseCost) {
            view.printToUser("Down Payment must be at least $" + IMortgage.MIN_DOWN_PAYMENT + " and at most the cost of the house.");
        }

        Integer years = view.getYears();
        // preconditions met by virtue of getting this value from
        // a drop-down menu which already meets the preconditions.


        //------------initialize Mortgage------------//
        IMortgage mortgage = new Mortgage(houseCost, downPayment, years, customer);


        //------------print mortgage details------------//
        view.displayApproved(mortgage.loanApproved());
        //mortgage approved; print out the specifics.
        if(mortgage.loanApproved()) {
            view.displayRate(mortgage.getRate());
            view.displayPayment(mortgage.getPayment());
        }
        //mortgage denied; print zeros
        else{
            view.displayRate(0);
            view.displayPayment(0);
        }
    }
}
