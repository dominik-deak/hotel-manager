# Hotel Management Application

## Overview

This Hotel Management Application is a Java console application developed to manage bookings for a hotel with eight rooms. The project demonstrates both procedural and object-oriented programming techniques in Java, emphasizing data structures, file handling, and user interaction via a console interface.

## Features

The application provides the following features:

1. **Room Management**
   - Add a customer to a room.
   - View all rooms and their occupancy status.
   - Display empty rooms.
   - Delete a customer from a room and automatically assign the next customer from the waiting list.
   - Find a room by customer's name.
   - View guests ordered alphabetically by name.

2. **Data Persistence**
   - Store program data into a file.
   - Load program data from a file.

3. **Queue Management**
   - Implement a waiting list for customers when the hotel is full.
   - Extra credit feature: Implemented as a circular queue.

4. **Extended Room Information**
   - Track the number of guests in a room.
   - Store additional information for the paying guest, including:
     - First name
     - Surname
     - Credit card number

## Implementation

The application is implemented in two versions:

### Arrays Version

This version uses arrays to manage room bookings and related functionalities. It demonstrates a procedural programming approach.

### Classes Version

This version employs object-oriented programming principles with the use of classes such as `Hotel`, `Room`, and `Person`. It encapsulates data and functionality to promote code maintainability and extensibility.

## Usage

Upon starting the application, you will be presented with a menu of options. Enter the corresponding letter to perform the desired action:

- `A`: Add a customer to a room.
- `V`: View all rooms.
- `E`: Display empty rooms.
- `D`: Delete a customer from a room.
- `F`: Find a room by customer name.
- `S`: Store program data into a file.
- `L`: Load program data from a file.
- `O`: View guests ordered alphabetically by name.
- `Q`: Quit the application.

### Example

To add a customer, enter `A`, then follow the prompts to specify the room number and customer details.
