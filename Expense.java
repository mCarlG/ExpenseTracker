/**
 * @Purpose: Class file for utilizing expenses
 * @DueDate: 11/26/2023
 */

public class Expense {
    /**
     * @Purpose: Superclass of each expense type. Allows for general creation of expenses
     */
    private float totalExpense;
    private String expenseType = "General Expense"; // This will always be changed when changed into a subclass

    public Expense (float totalExpense) {
        /**
         * @Purpose: Constructor for the expense class
         * @Param: (float) totalExpense: The total amount of the expense
         */
        this.totalExpense = totalExpense;
    }

    public void setTotalExpense(float totalExpense) {
        /**
         * @Purpose: Sets the total expense for the given expense object
         * @Param: (float) totalExpense: The new total expense for this object
         */
        this.totalExpense = totalExpense;
    }

    public float getTotalExpense(){
        /**
         * @Purpose: Returns the total expense for a given expense object
         * @Return: (float) totalExpense, the current total expense for this object
         */
        return this.totalExpense;
    }
}


public class UtilityExpense extends Expense {
    /**
     * @Purpose: Allows the user to create an expense specifically under the UtilityExpense category
     */
    private String expenseType;
    private float totalExpense;

    public UtilityExpense(float totalExpense) {
        /**
         * @Purpose: Constructor for the UtilityExpense class
         * @Param: (float) totalExpense: The total expenses for this UtilityExpense object
         */
        super(totalExpense);
        this.expenseType = "Utility expense"
    }

    public String getType() {
        /**
         * @Purpose: Tells the user what kind of expense a given expense object is
         * @Return: (String) expenseType: The name of the type of expense
         */
        return this.expenseType;
    }

    public void setTotalExpense(float totalExpense){
        /**
         * @Purpose: Sets the new total expense for a given expense object
         * @Param: (float) totalExpense: The new total expense amount
         */
        this.totalExpense = totalExpense;
    }

    public float getTotalExpense(){
        /**
         * @Purpose: Gives the user the current expense amount for a given expense object
         * @Return (float) totalExpense: The total dollar amount of a given expense
         */
        return this.totalExpense;
    }
}

public class SavingsExpense extends Expense {
    /**
     * @Purpose: Allows the user to create an expense specifically under the SavingsExpense category
     */
    private String expenseType;
    private float totalExpense;

    public SavingsExpense(float totalExpense) {
        /**
         * @Purpose: Constructor for the SavingsExpense class
         * @Param: (float) totalExpense: The total expenses for this SavigsExpense object
         */
        super(totalExpense)
        this.expenseType = "Savings expense"
    }

    public String getType() {
        /**
         * @Purpose: Tells the user what kind of expense a given expense object is
         * @Return: (String) expenseType: The name of the type of expense
         */
        return this.expenseType;
    }

    public void setTotalExpense(float totalExpense) {
        /**
         * @Purpose: Sets the new total expense for a given expense object
         * @Param: (float) totalExpense: The new total expense amount
         */
        this.totalExpense = totalExpense;
    }

    public float getTotalExpense(){

        /**
         * @Purpose: Gives the user the current expense amount for a given expense object
         * @Return (float) totalExpense: The total dollar amount of a given expense
         */
        return this.totalExpense;
    }
}

public class PersonalSpendingExpense extends Expense {
    /**
     * @Purpose: Allows the user to create an expense specifically under the PersonalSpendingExpense category
     */
    private String expenseType;
    private float totalExpense;

    public PersonalSpendingExpense(float totalExpense) {
        /**
         * @Purpose: Constructor for the PersonalSpendingExpense class
         * @Param: (float) totalExpense: The total expenses for this PersonalSpendingExpense object
         */
        super(totalExpense);
        this.expenseType = "Personal spending expense"
    }

    public String getType() {
        /**
         * @Purpose: Tells the user what kind of expense a given expense object is
         * @Return: (String) expenseType: The name of the type of expense
         */
        return this.expenseType;
    }

    public void setTotalExpense(float totalExpense) {
        /**
         * @Purpose: Sets the new total expense for a given expense object
         * @Param: (float) totalExpense: The new total expense amount
         */
        this.totalExpense = totalExpense;
    }

    public float getTotalExpense(){

        /**
         * @Purpose: Gives the user the current expense amount for a given expense object
         * @Return (float) totalExpense: The total dollar amount of a given expense
         */
        return this.totalExpense;
    }
}



// Methods needed:
// -A method to add expenses to a list of expenses when a button is clicked
// - Maybe sort the expenses by cost?
// - Create an expense report?