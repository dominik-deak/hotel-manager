package coursework;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Queue class
 * Contains a second array of room objects that represents a queue
 * Queue is implemented as a circular queue
 */
public class Queue
{
    private static final Scanner input = new Scanner(System.in);
    private static final int QUEUE_SIZE = 8;
    public static final Room[] hotelQueue = new Room[QUEUE_SIZE];
    public static int front = 0;
    public static int end = 0;

    /**
     * Checks if the queue is full
     *
     * @return true if the queue is full, false if not
     */
    public static boolean isQueueFull()
    {
        boolean queueIsFull = true;
        for (Room roomObject : hotelQueue)
        {
            if (roomObject.isObjectEmpty())
            {
                queueIsFull = false;
                break;
            }
        }
        return queueIsFull;
    }

    /**
     * Checks if the queue is empty
     *
     * @return true if the queue is empty, false if not
     */
    public static boolean isQueueEmpty()
    {
        boolean queueIsEmpty = true;
        for (Room roomObject : hotelQueue)
        {
            if (!(roomObject.isObjectEmpty()))
            {
                queueIsEmpty = false;
                break;
            }
        }
        return queueIsEmpty;
    }

    /**
     * Adds a customer to the queue
     * Also prompts for additional information
     */
    public static void addCustomerToQueue()
    {
        try {
            System.out.print("Enter name for queue (first name only): ");
            String queueName = input.next();
            hotelQueue[end].setName(queueName);
            System.out.print("Enter the number of guests: ");
            int numberOfGuests = input.nextInt();
            hotelQueue[end].setNumberOfGuests(numberOfGuests);
            System.out.print("Enter the first name of the paying guest: ");
            String firstName = input.next();
            hotelQueue[end].payingGuest.setFirstName(firstName);
            System.out.print("Enter the last name of the paying guest: ");
            String lastName = input.next();
            hotelQueue[end].payingGuest.setLastName(lastName);
            System.out.print("Enter the credit card number of the paying guest: ");
            int creditCardNumber = input.nextInt();
            hotelQueue[end].payingGuest.setCreditCardNumber(creditCardNumber);
            System.out.println("Successfully stored information for queue");
            end = (end + 1) % QUEUE_SIZE;
        } catch (InputMismatchException e)
        {
            System.out.println("Error: " + e);
            input.next();
            hotelQueue[end].setName("none");
            hotelQueue[end].setNumberOfGuests(0);
            hotelQueue[end].payingGuest.setFirstName("none");
            hotelQueue[end].payingGuest.setLastName("none");
            hotelQueue[end].payingGuest.setCreditCardNumber(0);
        }
    }

    /**
     * Moves the person at the front of the queue to the empty hotel room
     * Deletes the information of that person from the queue
     *
     * @param roomNumberInput the room number entered by the user in the previous method
     */
    public static void removeCustomerFromQueue(int roomNumberInput)
    {
        Hotel.hotelRooms[roomNumberInput].setName(hotelQueue[front].getName());
        Hotel.hotelRooms[roomNumberInput].setNumberOfGuests(hotelQueue[front].getNumberOfGuests());
        Hotel.hotelRooms[roomNumberInput].payingGuest.setFirstName(hotelQueue[front].payingGuest.getFirstName());
        Hotel.hotelRooms[roomNumberInput].payingGuest.setLastName(hotelQueue[front].payingGuest.getLastName());
        Hotel.hotelRooms[roomNumberInput].payingGuest.setCreditCardNumber(hotelQueue[front].payingGuest.getCreditCardNumber());
        hotelQueue[front].setName("none");
        hotelQueue[front].setNumberOfGuests(0);
        hotelQueue[front].payingGuest.setFirstName("none");
        hotelQueue[front].payingGuest.setLastName("none");
        hotelQueue[front].payingGuest.setCreditCardNumber(0);
        front = (front + 1) % QUEUE_SIZE;
    }
}
