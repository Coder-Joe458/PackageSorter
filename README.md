# Package Sorter

## Overview

The **Package Sorter** is a program designed for a robotic arm in an automation factory. Its goal is to classify packages based on their dimensions and mass into different stacks: **STANDARD**, **SPECIAL**, and **REJECTED**.

### Sorting Rules:
- A package is **bulky** if:
    - Its volume (width x height x length) is greater than or equal to 1,000,000 cm³, or
    - Any of its dimensions (width, height, or length) is greater than or equal to 150 cm.
- A package is **heavy** if its mass is greater than or equal to 20 kg.

The package will be sorted into one of three categories:
1. **STANDARD**: Neither bulky nor heavy.
2. **SPECIAL**: Either bulky or heavy, but not both.
3. **REJECTED**: Both bulky and heavy.

## Structure

The project contains two main files:

1. **`PackageSorter.java`**:
    - Implements the sorting logic that categorizes packages based on their dimensions and mass.

2. **`Main.java`**:
    - Contains test cases to verify the correctness of the sorting logic. It includes standard cases, edge cases, and tests for handling maximum allowable input values.

## Prerequisites

To run this project, you'll need:

- **Java Development Kit (JDK)** (version 8 or above).

## How to Run

1. **Clone the repository**:

    ```bash
    https://github.com/Coder-Joe458/PackageSorter.git
    ```

2. **Navigate to the project directory**:

    ```bash
    cd PackageSorter
    ```

3. **Compile the files**:

    ```bash
    javac PackageSorter.java
    javac Main.java
    ```

4. **Run the program**:

    ```bash
    java Main
    ```

The output should confirm that all test cases pass successfully.

## Input Validation

- The package dimensions (width, height, length) and mass must be non-negative.
- If any dimension or mass exceeds the maximum value for an `int` (2,147,483,647), the function will throw an `IllegalArgumentException`.

## Example Usage

```java
public class Main {
    public static void main(String[] args) {
        String result = PackageSorter.sort(120, 130, 140, 18);
        System.out.println(result);  // Output: STANDARD
    }
}
