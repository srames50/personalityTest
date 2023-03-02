# Keirsey Personality Test Results
This Java program reads a file containing Keirsey Personality Test survey results and outputs the corresponding personality types for each participant. The Keirsey Temperament Sorter (keirsey.com) is a test that measures four independent dimensions of personality.

# How to Use
Compile the program using the command javac PersonalityTest.java
Prepare a file containing Keirsey Personality Test survey results.
Run the program using the command java PersonalityTest and follow the prompts to input the file name.
The program will process the data and output the corresponding personality types for each participant in the file.

# Methods

intro()
Displays an introduction to the program.

addtoArr()
Adds all the letters from each line of survey results to a character array.

answers()
Processes the data from the character array, calculates the tally for each personality type, and outputs the personality type for each participant.

answersProcessing1()
Iterates through the character array and determines the tally for questions that only have one option.

answersProcessing2()
Iterates through the character array and determines the tally for questions that have two options.

percentB()
Calculates the percentage of "B" answers for each personality type.

pType()
Determines the personality type based on the percentage of "B" answers for each personality type.
