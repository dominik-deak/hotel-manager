package coursework;

import java.util.*;
import java.io.*;

/**
 * Hotel Program Classes version
 * @author Dominik Deak - w1778659
 */
public class Hotel
{
    private static final Scanner input = new Scanner(System.in);
    private static final int NUMBER_OF_ROOMS = 8;
    public static final Room[] hotelRooms = new Room[NUMBER_OF_ROOMS];
    private static int roomNumber;

    /**
     * Main method of the program
     * Initialises the array of room objects
     * Displays a menu and allows the user to select from a number of options and calls the appropriate method
     */
    public static void main(String[] args)
    {
        boolean menuLoop = true;
        for (int i = 0; i < NUMBER_OF_ROOMS; i++)
        {
            hotelRooms[i] = new Room();
            Queue.hotelQueue[i] = new Room();
        }
        System.out.println("--------------------\nWelcome to the Hotel");
        while (menuLoop)
        {
            System.out.print("--------------------\n" +
                    "Press 'A' to add a customer to a room\n" +
                    "Press 'V' to view all rooms\n" +
                    "Press 'E' to display empty rooms\n" +
                    "Press 'D' to delete a customer from a room\n" +
                    "Press 'F' to find a room with a customer name\n" +
                    "Press 'S' to store program data into a file\n" +
                    "Press 'L' to load program data from a file\n" +
                    "Press 'O' to view guests ordered alphabetically\n" +
                    "Press 'Q' to quit\n" +
                    "Select option: ");
            String menuChoice = input.next();
            menuChoice = menuChoice.toLowerCase();
            switch (menuChoice)
            {
                case "a":
                    addCustomerToRoom();
                    break;
                case "v":
                    viewAllRooms();
                    break;
                case "e":
                    displayEmptyRooms();
                    break;
                case "d":
                    deleteCustomerFromRoom();
                    break;
                case "f":
                    findRoomForCustomerName();
                    break;
                case "s":
                    storeProgramData();
                    break;
                case "l":
                    loadProgramData();
                    break;
                case "o":
                    viewGuestsOrderedAlphabetically();
                    break;
                case "q":
                    menuLoop = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    /**
     * Adds a customer to a selected room if it is not occupied
     * Calls a method to add additional information
     * If the hotel is full, calls a method to place the customer into a queue
     * If both the hotel and queue are full, it lets the user know about it
     */
    private static void addCustomerToRoom()
    {
        boolean hotelIsFull = isHotelFull();
        if (hotelIsFull)
        {
            boolean queueIsFull = Queue.isQueueFull();
            if (queueIsFull)
            {
                System.out.println("--------------------\nHotel is full, Queue is full");
            } else {
                System.out.println("--------------------\nHotel is full, customer will be added to queue");
                Queue.addCustomerToQueue();
            }
        } else {
            boolean ansValid = false;
            try {
                System.out.print("--------------------\nEnter room number (0-7) or 8 to cancel: ");
                roomNumber = input.nextInt();
                if (roomNumber < 0 || roomNumber > 8)
                {
                    System.out.println("Invalid number");
                } else {
                    ansValid = true;
                }
            } catch (InputMismatchException e)
            {
                System.out.println("Error: " + e);
                input.next(); // This line is used to avoid returning 'e' as an answer to the menu
            }
            if (ansValid)
            {
                if (roomNumber == 8)
                {
                    return;
                }
                if (!(hotelRooms[roomNumber].isObjectEmpty()))
                {
                    System.out.println("Room " + roomNumber + " is already occupied");
                } else {
                    System.out.print("Enter name for room " + roomNumber + " (first name only): ");
                    String roomName = input.next();
                    hotelRooms[roomNumber].setName(roomName);
                    storeAdditionalInformation(roomNumber);
                }
            }
        }
    }

    /**
     * Checks if the hotel is full
     *
     * @return true if the hotel is full, false if not
     */
    private static boolean isHotelFull()
    {
        boolean hotelIsFull = true;
        for (Room roomObject : hotelRooms)
        {
            if (roomObject.isObjectEmpty())
            {
                hotelIsFull = false;
                break;
            }
        }
        return hotelIsFull;
    }

    /**
     * Stores additional information for a room
     *
     * @param numberInput the room number entered by the user in the previous method
     */
    private static void storeAdditionalInformation(int numberInput)
    {
        try
        {
            System.out.print("Enter the number of guests for room " + numberInput + ": ");
            int numberOfGuests = input.nextInt();
            hotelRooms[numberInput].setNumberOfGuests(numberOfGuests);
            System.out.print("Enter the first name of the paying guest: ");
            String firstName = input.next();
            hotelRooms[numberInput].payingGuest.setFirstName(firstName);
            System.out.print("Enter the last name of the paying guest: ");
            String lastName = input.next();
            hotelRooms[numberInput].payingGuest.setLastName(lastName);
            System.out.print("Enter the credit card number of the paying guest: ");
            int creditCardNumber = input.nextInt();
            hotelRooms[numberInput].payingGuest.setCreditCardNumber(creditCardNumber);
            System.out.println("Successfully stored information for room " + numberInput);
        } catch (InputMismatchException e)
        {
            System.out.println("Error: " + e);
            input.next();
            hotelRooms[numberInput].setName("none");
            hotelRooms[numberInput].setNumberOfGuests(0);
            hotelRooms[numberInput].payingGuest.setFirstName("none");
            hotelRooms[numberInput].payingGuest.setLastName("none");
            hotelRooms[numberInput].payingGuest.setCreditCardNumber(0);
        }
    }

    /**
     * Displays all rooms of the hotel
     * Displays additional information if the room is occupied
     */
    private static void viewAllRooms()
    {
        System.out.println("--------------------");
        for (int i = 0; i < NUMBER_OF_ROOMS; i++)
        {
            if (hotelRooms[i].isObjectEmpty())
            {
                System.out.println("Room " + i + " is occupied by: " + hotelRooms[i].getName());
            } else {
                System.out.println("Room " + i + " is occupied by: " + hotelRooms[i].getName());
                System.out.println("    -Number of guests: " + hotelRooms[i].getNumberOfGuests() +
                        "\n    -First name of paying guest: " + hotelRooms[i].payingGuest.getFirstName() +
                        "\n    -Last name of paying guest: " + hotelRooms[i].payingGuest.getLastName() +
                        "\n    -Credit card number of paying guest: " + hotelRooms[i].payingGuest.getCreditCardNumber());
            }
        }
    }

    /**
     * Displays all rooms that are empty
     */
    private static void displayEmptyRooms()
    {
        System.out.println("--------------------");
        for (int i = 0; i < NUMBER_OF_ROOMS; i++)
        {
            if (hotelRooms[i].isObjectEmpty())
            {
                System.out.println("Room " + i + " is empty");
            }
        }
    }

    /**
     * Deletes the customer from a selected room if that room has a customer
     * Also deletes the additional information
     * If there are people waiting in the queue, calls a method to move them to the emptied hotel room
     */
    private static void deleteCustomerFromRoom()
    {
        boolean ansValid = false;
        try {
            System.out.print("--------------------\nEnter room number (0-7) or 8 to cancel: ");
            roomNumber = input.nextInt();
            if (roomNumber < 0 || roomNumber > 8)
            {
                System.out.println("Invalid number");
            } else {
                ansValid = true;
            }
        } catch (InputMismatchException e)
        {
            System.out.println("Error: " + e);
            input.next();
        }
        if (ansValid)
        {
            if (roomNumber == 8)
            {
                return;
            }
            if (hotelRooms[roomNumber].isObjectEmpty())
            {
                System.out.println("Room " + roomNumber + " is already empty");
            } else {
                System.out.println(hotelRooms[roomNumber].getName() + " removed from room " + roomNumber);
                hotelRooms[roomNumber].setName("none");
                hotelRooms[roomNumber].setNumberOfGuests(0);
                hotelRooms[roomNumber].payingGuest.setFirstName("none");
                hotelRooms[roomNumber].payingGuest.setLastName("none");
                hotelRooms[roomNumber].payingGuest.setCreditCardNumber(0);
            }
            boolean queueIsEmpty = Queue.isQueueEmpty();
            if (!(queueIsEmpty))
            {
                Queue.removeCustomerFromQueue(roomNumber);
            }
        }
    }

    /**
     * Prompts the user to enter a name and finds the room with that name
     * Also lets the user know if there is no room with that name
     */
    private static void findRoomForCustomerName()
    {
        System.out.print("--------------------\nEnter customer name (first name only): ");
        String customerName = input.next();
        boolean found = false;
        for (Room roomObject : hotelRooms)
        {
            if (roomObject.getName().equals(customerName))
            {
                found = true;
                break;
            }
        }
        if (found)
        {
            for (int i = 0; i < NUMBER_OF_ROOMS; i++)
            {
                if (hotelRooms[i].getName().equals(customerName))
                {
                    System.out.println(customerName + " is in room " + i);
                }
            }
        } else {
            System.out.println(customerName + " can't be found in any of the rooms");
        }
    }

    /**
     * Stores all of the program data into two text files (HotelData.txt, QueueData.txt)
     */
    private static void storeProgramData()
    {
        try
        {
            PrintWriter hotelDataText = new PrintWriter("src\\coursework\\HotelData.txt");
            PrintWriter queueDataText = new PrintWriter("src\\coursework\\QueueData.txt");
            for (int i = 0; i < NUMBER_OF_ROOMS; i++)
            {
                hotelDataText.print(hotelRooms[i].getName() + " ");
                hotelDataText.print(hotelRooms[i].getNumberOfGuests() + " ");
                hotelDataText.print(hotelRooms[i].payingGuest.getFirstName() + " ");
                hotelDataText.print(hotelRooms[i].payingGuest.getLastName() + " ");
                hotelDataText.print(hotelRooms[i].payingGuest.getCreditCardNumber() + "\n");
                queueDataText.print(Queue.hotelQueue[i].getName() + " ");
                queueDataText.print(Queue.hotelQueue[i].getNumberOfGuests() + " ");
                queueDataText.print(Queue.hotelQueue[i].payingGuest.getFirstName() + " ");
                queueDataText.print(Queue.hotelQueue[i].payingGuest.getLastName() + " ");
                queueDataText.print(Queue.hotelQueue[i].payingGuest.getCreditCardNumber() + "\n");
            }
            queueDataText.print(Queue.front + " " + Queue.end);
            hotelDataText.close();
            queueDataText.close();
            System.out.println("--------------------\nSuccessfully stored program data");
        } catch (IOException e) {
            System.out.println("--------------------\nError, IOException is: " + e);
        }
    }

    /**
     * Loads all of the program data from two text files (HotelData.txt, QueueData.txt)
     */
    private static void loadProgramData()
    {
        try
        {
            File hotelDataFile = new File("src\\coursework\\HotelData.txt");
            File queueDataFile = new File("src\\coursework\\QueueData.txt");
            Scanner hotelDataScanner = new Scanner(hotelDataFile);
            Scanner queueDataScanner = new Scanner(queueDataFile);
            for (int i = 0; i < NUMBER_OF_ROOMS; i++)
            {
                hotelRooms[i].setName(hotelDataScanner.next());
                hotelRooms[i].setNumberOfGuests(Integer.parseInt(hotelDataScanner.next()));
                hotelRooms[i].payingGuest.setFirstName(hotelDataScanner.next());
                hotelRooms[i].payingGuest.setLastName(hotelDataScanner.next());
                hotelRooms[i].payingGuest.setCreditCardNumber(Integer.parseInt(hotelDataScanner.next()));
                Queue.hotelQueue[i].setName(queueDataScanner.next());
                Queue.hotelQueue[i].setNumberOfGuests(Integer.parseInt(queueDataScanner.next()));
                Queue.hotelQueue[i].payingGuest.setFirstName(queueDataScanner.next());
                Queue.hotelQueue[i].payingGuest.setLastName(queueDataScanner.next());
                Queue.hotelQueue[i].payingGuest.setCreditCardNumber(Integer.parseInt(queueDataScanner.next()));
            }
            Queue.front = Integer.parseInt(queueDataScanner.next());
            Queue.end = Integer.parseInt(queueDataScanner.next());
            hotelDataScanner.close();
            queueDataScanner.close();
            System.out.println("--------------------\nSuccessfully loaded program data");
        } catch (IOException e) {
            System.out.println("--------------------\nError, IOException is: " + e);
        }
    }

    /**
     * Orders all guest names alphabetically and displays them
     * The ordering is done using a bubble sort algorithm found in the study notes
     * Does not change the order of the original array of objects
     * Only displays the names of occupied rooms
     */
    private static void viewGuestsOrderedAlphabetically()
    {
        String[] alphabeticalNames = new String[NUMBER_OF_ROOMS];
        int counter = 0;
        for (int i = 0; i < NUMBER_OF_ROOMS; i++)
        {
            alphabeticalNames[i] = hotelRooms[i].getName();
        }
        for (int j = alphabeticalNames.length-2; j >= 0; j--)
        {
            for (int k = 0; k <= j; k++)
            {
                if (alphabeticalNames[k].compareToIgnoreCase(alphabeticalNames[k + 1]) > 0) // I found the compareToIgnoreCase method on the following website: https://www.w3schools.com/java/ref_string_comparetoignorecase.asp
                {
                    String temp = alphabeticalNames[k];
                    alphabeticalNames[k] = alphabeticalNames[k + 1];
                    alphabeticalNames[k + 1] = temp;
                }
            }
        }
        System.out.println("--------------------");
        for (String s : alphabeticalNames)
        {
            if (!(s.equals("none")))
            {
                if (counter > 0)
                {
                    System.out.print(", ");
                }
                System.out.print(s);
                counter++;
            }
        }
        System.out.println();
    }
}
