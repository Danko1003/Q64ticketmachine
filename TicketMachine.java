/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 7.1
 */
/**Look at the class definition in
source code and use this knowledge, along with the additional information about ordering we have given
you, to make a list of the names of the fields, constructors, and methods in the TicketMachine class.
Hint: There is only one constructor in the class.
 * Class,functions,variables,
 * 
 * 
 * 
 * 
 * 
 */
class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // New field to track if discount is selected
    private boolean discountSelected;
    
    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
        price = 1000;
        balance = 0;
        total = 0;
        discountSelected = false;  // discount is off by default
    }

    /**
     * @Return The price of a ticket.
     */
    public void setPrice(int price){
        /** set your price */
        this.price = price;
    }

    public int getPrice()
    {
        return price;
    }

    public void prompt() 
    {
        System.out.println("Please insert the correct amount of money");  
    }

    /**
     * Return The amount of money already inserted for the next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    public int gettotal(){
        return total;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        prompt();
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " + amount);
        }
    }

    /**
     * Allow user to select discount.
     */
    public void selectDiscount() {
        discountSelected = true;
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket(int ticketamount)
    {   
        for (int i = 0; i < ticketamount; i++) {
            int currentPrice = discountSelected ? price / 2 : price; // use discount if chosen
            int amountLeftToPay = currentPrice - balance;  // local variable
    
            if(amountLeftToPay <= 0) {
                // Simulate the printing of a ticket
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + currentPrice + " cents.");
                System.out.println("##################");
                System.out.println();
    
                // Update the total collected with the price
                total = total + currentPrice;
                // Reduce the balance by the price
                balance = balance - currentPrice;
                // Reset discount for next ticket
                discountSelected = false;
            }
            else {
                System.out.printf("You must insert at least %d more cents.%n",
                                  amountLeftToPay);
            }
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    
    public void affordable(int budget) {
        if(price > budget) {
            System.out.println("Too expensive. Budget: " + budget );
        } else {
            System.out.println("Just right");
        }
    }

    public int emptyMachine() {
        int memorytotal = total;
        total = 0;
        return memorytotal;
    }
}
