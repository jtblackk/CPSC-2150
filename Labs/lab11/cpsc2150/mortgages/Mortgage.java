package cpsc2150.mortgages;


/**
 * created by jtblack on 10/11/2019
 * created for CPSC 2151
 *
 * @invariants payment = (rate * principal) / (1-(1+rate)^ -NumberOfPayments) and
 *      0 <= rate <= 1 and
 *      0 < debtToIncomeRatio and
 *      MIN_YEARS * 12 <= numberOfPayments <= MAX_YEARS * 12 and
 *      0 < principal and
 *      0 <= percentDown < 1
 * @correspondences
 *      Payment = payment
 *      Rate = rate
 *      Customer = customer
 *      DebtToIncomeRatio = debtToIncomeRatio
 *      Principal = principal
 *      NumberOfPayments = numberOfPayments
 *      PercentDown = percentDown
 */
public class Mortgage extends AbsMortgage implements IMortgage {
    double payment;
    double rate;
    ICustomer customer;
    double debtToIncomeRatio;
    double principal;
    int numberOfPayments;
    double percentDown;

    /**
     * @param cost cost of the home
     * @param downPayment down payment on the home
     * @param numYears number of years to pay off the loan
     * @param customer the customer object
     * @pre 0 < cost and 0 <= downPayment and MIN_YEARS < numYears < MAX_YEARS and customer != null
     * @post customer = customer and principal = cost - downPayment and numberOfPayments = numYears * 12 and
     *      percentDown = downPayment / cost and
     *      [rate is calculated based on numYears, downPayment, and cost]
     *      [payment is calculated]
     */
    Mortgage(double cost, double downPayment, int numYears, ICustomer customer){
        this.customer = customer;

        //calculate monthly rate
        this.rate = this.calculateAPR(numYears, downPayment, cost) / 12;

        //calculate principal
        this.principal = cost - downPayment;

        //calculate number of payments
        this.numberOfPayments = numYears * 12;

        //calculate debt to income ratio
        this.debtToIncomeRatio = this.customer.getMonthlyDebtPayments() / (this.customer.getIncome() / 12);

        //calculate percent down
        this.percentDown = downPayment / cost;

        //calculate monthly payment
        this.payment = this.calculatePayment();
    }

    public boolean loanApproved(){
        if(this.rate*12 < IMortgage.RATETOOHIGH && this.percentDown >= IMortgage.MIN_PERCENT_DOWN && this.debtToIncomeRatio < IMortgage.DTOITOOHIGH){
            //loan approved
            return true;
        }
        //loan not approved
        return false;
    }

    public double getPayment(){
        return this.payment;
    }

    public double getRate(){
        return this.rate * 12;
    }

    public double getPrincipal(){
        return this.principal;
    }

    public int getYears(){
        return this.numberOfPayments / 12;
    }

    //helper functions

    private double calculateAPR(int numYears, double downPayment, double cost){
        //base rate
        double apr = IMortgage.BASERATE;

        //adjust apr for duration of loan
        if(numYears < IMortgage.MAX_YEARS){
            apr += IMortgage.GOODRATEADD;
        }
        else{
            apr += IMortgage.NORMALRATEADD;
        }

        //adjust apr for percent down
        if(downPayment / cost < IMortgage.PREFERRED_PERCENT_DOWN){
            apr += IMortgage.GOODRATEADD;
        }

        //adjust apr for credit score
        //very bad credit
        if(this.customer.getCreditScore() < IMortgage.BADCREDIT){
            apr += IMortgage.VERYBADRATEADD;
        } else
        //bad credit
        if(this.customer.getCreditScore() < IMortgage.FAIRCREDIT){
            apr += IMortgage.BADRATEADD;
        } else
        //fair credit
        if(this.customer.getCreditScore() < IMortgage.GOODCREDIT){
            apr += IMortgage.NORMALRATEADD;
        } else
        //good credit
        if(this.customer.getCreditScore() < IMortgage.GREATCREDIT){
            apr += IMortgage.GOODRATEADD;
        }
        //great credit adds nothing

        return apr;
    }

    //calculate payment based off of formula given for payment
    private double calculatePayment(){
        double dividend = this.rate * this.principal;
        double divisor = 1 - Math.pow(1 + this.rate, -this.numberOfPayments);
        return dividend/divisor;
    }
}
