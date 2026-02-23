# Sorting Tool
A versatile command-line utility designed to process, analyze, and sort various types of data (numbers, words, and full lines) from standard input or external files.

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Setup](#setup)
* [Building the application](#building-the-application)
* [Usage](#usage)
* [Testing](#testing)
* [Author](#author)

## General Info
The main purpose of this project is to:
- Provide a robust tool to process streams of input data, categorizing them as integers, individual words, or complete text lines.
- Implement flexible sorting mechanisms to arrange data either naturally (numerically/lexicographically) or by frequency of occurrence.
- Ensure smooth execution by handling input errors, invalid parameters, and missing arguments without crashing.
- Support seamless transitions between standard console input/output and file-based data processing.

## Technologies Used
- **Java 21** - Core programming language.
- **Gradle** - Build automation and project management tool.

## Features
- **Dynamic Data Types**: Configurable parsing for different inputs using the `-dataType` argument (`long`, `word`, or `line`).
- **Advanced Sorting Options**: Specify the sorting method with the `-sortingType` argument:
    - `natural`: Sorts numbers in ascending order and strings in lexicographical order.
    - `byCount`: Sorts elements based on their frequency of occurrence, calculating the percentage of the total for each element.
- **File Processing**: Safely redirect input and output streams using the `-inputFile` and `-outputFile` arguments instead of relying solely on the console.
- **Robust Error Handling**: Automatically skips unrecognized command-line arguments and ignores invalid data chunks (e.g., skipping text when parsing numbers) while providing informative warnings to the user.

## Setup
1. Ensure you have a recent version of **Java** installed.
2. Clone or download the project files to your local machine.
3. The project uses the **Gradle Wrapper**, so you do not need to install Gradle locally.

## Building the application
To build the project and compile the Java classes, run the following command in the root directory:

```bash
./gradlew clean build
```

## Usage
You can run the application directly from your terminal. Use command-line arguments to dictate how the program processes data.

### 1. Basic Console Usage
Process words and sort them by count (frequency) from the standard input (type data, then send EOF - `Ctrl+D` on Unix, `Ctrl+Z` on Windows):
```bash
java -cp build/classes/java/main Main -dataType word -sortingType byCount
```

### 2. File I/O Usage
Read numbers from an input file and output the naturally sorted result to an output file:
```bash
java -cp build/classes/java/main Main -dataType long -sortingType natural -inputFile data.txt -outputFile out.txt
```

### Valid Command-Line Arguments
- `-dataType [long, word, line]` (Defaults to `word`)
- `-sortingType [natural, byCount]` (Defaults to `natural`)
- `-inputFile [filename]`
- `-outputFile [filename]`

## Testing
The project includes automated tests utilizing the Hyperskill test framework. Run the test suite using:

```bash
./gradlew test
```

## Author
Project developed by **Jakub Podsadowski**
