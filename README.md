﻿# CarWashPriorityQueue
## Project Description
This repository contains a Java program that minimizes the average waiting time for customers at a car wash by using a heap/priority queue. Each car has different washing times based on its size and type. The program aims to optimize the order in which cars are washed to reduce the overall waiting time.

## Files
- `Musteri.java`: Defines the customer structure with arrival time and washing time.
- `Heap.java`: Implements the heap/priority queue structure to manage the customers based on their washing times.
- `Main.java`: Main class to handle the input parsing, heap operations, and output of the minimized average waiting time.

## Algorithm Explanation

### Musteri Class
The `Musteri` class defines the basic unit representing a customer. Each customer contains:
- Arrival time (`int arrivalTime`): The time at which the customer arrives.
- Washing time (`int washingTime`): The time required to wash the customer's car.

### Heap Class
The `Heap` class manages the customers and provides methods to manipulate the priority queue:
- `insert(Musteri customer)`: Adds a new customer to the heap.
- `extractMin()`: Extracts the customer with the minimum washing time.
- `isEmpty()`: Checks if the heap is empty.

### Main Class
The `Main` class contains the main method to run the car wash scheduling application:
- Parses the input to extract the number of customers and their arrival and washing times.
- Uses the `Heap` class to schedule the customers based on their washing times.
- Calculates and outputs the minimized average waiting time.

### Example Workflow
1. The user inputs the number of customers and their respective arrival and washing times:
 3
0 3
1 9
2 6
