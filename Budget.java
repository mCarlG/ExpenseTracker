/**
 * @Purpose: Allows for the creation of a budget object
 * @DueDate: 11/26/2023
 */
public class Budget {
    /**
     * @Purpose: Allows the user to instantiate a budget object. Uses polymorphism to set the correct type of budget
     */

    private float totalBudget;

    public Budget(float totalBudget) {
        /**
         * @Purpose: Constructor for budget superclass
         * @Param: (float) totalBudget: the new budget allotted
         */
        this.totalBudget = totalBudget;
    }

    public void setTotalBudget(float totalBudget) {
        /**
         * @Purpose: Sets the entire budget to one value for a category
         * @Param: (float) totalBudget: the new budget allotted
         */
        this.totalBudget = totalBudget;
    }

    public float getTotalBudget() {
        /**
         * @Purpose: Returns the total budget amount to the user
         * @Return: (float) totalBudget: the current totalBudget
         */
        return this.totalBudget()
    }

    public float addToBudget(float amountToAdd) {// May not need, only if there is an option to add a certain amount to budget
        /**
         * @Purpose: Adds a new value to the current budget without completely replacing the budget amount
         * @Param: (float) amountToAdd: The amount that the budget should be increased by
         * @Return: (float) newBudget: The new budget after adding the increase amount
         */
        currentBudget = this.totalBudget;
        newBudget = currentBudget + amountToAdd;
        return newBudget;
    }
}


public class UtilityBudget extends Budget {}
    /**
     * @Purpose: A subclass to allow for specification of the type of budget
     */
    private float totalBudget;

    public UtilityBudget(float totalBudget) {
        /**
         * @Purpose: Constructor for utility budget. Uses superclass value for totalBudget
         * @Param: (float) totalBudget: The total budget amount from the superclass
         */
        super(totalBudget);
    }


public class PersonalSpendingBudget extends Budget {}
    /**
     * @Purpose: A subclass to allow for specification of the type of budget
     */
    private float totalBudget;

    public PersonalSpendingBudget(float totalBudget) {
        /**
         * @Purpose: Constructor for personal spending budget. Uses superclass value for totalBudget
         * @Param: (float) totalBudget: The total budget amount from the superclass
         */
        super(totalBudget);
        }


public class SavingsBudget extends Budget {}
    /**
     * @Purpose: A subclass to allow for specification of the type of budget
     */
    private float totalBudget;

    public SavingsBudget(float totalBudget) {
        /**
         * @Purpose: Constructor for savings budget. Uses superclass value for totalBudget
         * @Param: (float) totalBudget: The total budget amount from the superclass
         */
        super(totalBudget);
    }
