package coursework;

/**
 * Room class
 * Contains the name of the room, the number of guests, as well as an object of the Person class
 */
public class Room
{
    private String roomName;
    private int numberOfGuests;
    Person payingGuest;

    /**
     * Room constructor
     * Initialises the values of Room objects
     */
    public Room()
    {
        roomName = "none";
        numberOfGuests = 0;
        payingGuest = new Person();
    }

    /**
     * Sets the name for an object
     *
     * @param nameInput the name entered by the user
     */
    public void setName(String nameInput)
    {
        this.roomName = nameInput;
    }

    /**
     * Returns the name of an object
     *
     * @return the name
     */
    public String getName()
    {
        return roomName;
    }

    /**
     * Sets the number of guests for the object
     *
     * @param numberInput the number entered by the user
     */
    public void setNumberOfGuests(int numberInput)
    {
        this.numberOfGuests = numberInput;
    }

    /**
     * Returns the number of guests for an object
     *
     * @return the number of guests
     */
    public int getNumberOfGuests()
    {
        return numberOfGuests;
    }

    /**
     * Checks if all of the values of an object are empty
     *
     * @return true if the object is empty, false if not
     */
    public boolean isObjectEmpty()
    {
        boolean objectIsEmpty = false;
        boolean sameRoom = false;
        boolean samePerson = false;
        if (roomName.equals("none") && numberOfGuests == 0)
        {
            sameRoom = true;
        }
        if (payingGuest.getFirstName().equals("none") && payingGuest.getLastName().equals("none") && payingGuest.getCreditCardNumber() == 0)
        {
            samePerson = true;
        }
        if (sameRoom && samePerson)
        {
            objectIsEmpty = true;
        }
        return objectIsEmpty;
    }
}
