# Arcade Machine System

This project implements an **Arcade Machine Management System** aimed at allowing the creation and customization of different types of arcade machines. Users can add video games to the machines, register custom machines, and generate a purchase invoice.

## Main Features
- Creation and customization of **pre-configured machines** such as: **Classic Arcade**, **Dance Revolution**, **Shooting Machine**, **Racing Machine**, and **Virtual Reality**.
- Customization of the machines by selecting **material** (wood, aluminum, carbon fiber) and **color**.
- Management of **video games** added to each machine, allowing only games compatible with the machine’s category.
- Implementation of design patterns such as **Singleton** for centralized management of the machines.
- Adherence to **SOLID** design principles to ensure clean and extensible code.
- **Billing functionality** at the end of the session, showing the machines and video games purchased.

## Project Structure

The project follows a class structure organized by responsibility:

- **Machine**: Abstract base class representing a generic arcade machine.
- **Machine Subclasses**: Specialized classes inheriting from `Machine` (e.g., `ArcadeMachine`, `DanceRevolutionMachine`, etc.).
- **Video Game**: Class representing the video games that can be added to the machines.
- **MachineManager**: Class implementing the **Singleton** pattern and managing all registered machines.
- **Main**: Class that handles the program flow and user interaction.

## Program Execution

### Requirements
- **Java 8** or higher installed.
- **Java compiler** (javac) to compile the code.

### How to Run the Program

1. **Clone the repository** or download the project files.
2. **Compile the source code** using the following command in the root directory of the project:
    ```bash
    javac Main.java
    ```
3. **Run the program**:
    ```bash
    java Main
    ```

### Program Menu

When you run the program, a menu with the following options will be displayed:
1. **Add a pre-configured machine**: Select a predefined machine and customize it with material and color.
2. **Show all registered machines**: View the registered machines and their details.
3. **Search machines by filters**: Filter machines by the number of video games, material type, or video game name.
4. **Add a video game to a registered machine**: Add a video game to one of the registered machines, ensuring its category is compatible.
5. **Remove a video game from a registered machine**: Remove a video game previously added to a machine.
6. **Generate invoice and exit**: End the program and generate an invoice with the machines and video games purchased.

### Example Execution

```plaintext
Main Menu
1. Add a pre-configured machine
2. Show all registered machines
3. Search machines by filters
4. Add a video game to a registered machine
5. Remove a video game from a registered machine
6. Generate invoice and exit
Select an option: 1
