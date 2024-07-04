package coursework;

/**
 * Person class
 * Contains the first name, last name and credit card number of the paying guest
 */
public class Person
{
    private String firstName;
    private String lastName;
    private int creditCardNumber;

    /**
     * Person constructor
     * Initialises the values of Person objects
     */
    public Person()
    {
        firstName = "none";
        lastName = "none";
        creditCardNumber = 0;
    }

    /**
     * Sets the first name of the paying guest
     *
     * @param nameInput the name entered by the user
     */
    public void setFirstName(String nameInput)
    {
        this.firstName = nameInput;
    }

    /**
     * Returns the first name of the paying guest
     *
     * @return the first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the last name of the paying guest
     *
     * @param nameInput the name entered by the user
     */
    public void setLastName(String nameInput)
    {
        this.lastName = nameInput;
    }

    /**
     * Returns the last name of the paying guest
     *
     * @return the last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the credit card number of the paying guest
     *
     * @param numberInput the number entered by the user
     */
    public void setCreditCardNumber(int numberInput)
    {
        this.creditCardNumber = numberInput;
    }

    /**
     * Returns the credit card number of the paying guest
     *
     * @return the credit card number
     */
    public int getCreditCardNumber()
    {
        return creditCardNumber;
    }
}
