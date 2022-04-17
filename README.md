# OOPAssignment Stephen Byrne C20470166

- Link to GitHub: https://github.com/SByrne34/OOPAssignment
- Link to Youtube: 

-------------------------------

The project idea I chose for this assignment was Number 1: Topic Modeller

Classes

- Control
- FileProcessing
- FileGUI

Control Class
- This contains the main method, calls the FileGUI class and allows the project to execute.

FileProcessing Class
- This contains the setter for the FIlename attribute  and the readFile method.
The readFile method uses a try/catch, it reads the stop words text file and the files later selected by the user in the GUI, this is achieved with the use of a scanner which the words read being inserted into an arrayList first, the words from the files that will be selected in the GUI are then moved from an arrayList into a linked Hashmap. The top words are then printed with the limit being selected in the GUI, finally a Hashmap called Temporary is used to count the duplicate keys and values present in the files and the values in the linked Hashmap fileMap are copied into this hashmap which will be used in the FileGUI class.

FileGUI Class
- This class creates a GUI with it first making a Jframe that sets the size, layout and background of the interface. Five buttons are used with each one being assigned to a panel, the first button is used to select the first file and the second file is selected with the second button. The third button is used in conjunction with the JTextField that allows the user to enter a new stop word. The fourth button is also used with a JTextField, this text field allows the user to set a limit on the number of top words displayed and the button registers the number entered. The fifth button compares the two files, displayed how related they are to each other.

Core Functionality included
- Analyses the words in each file and decides the top words in each
- Stop words included in a file will be exlcuded from the analysis
- Creates a percentage of how related the files are to each other based on the words in each file
- User sets limit on top words shown and uses a button to compare both files in a GUI

Optional Functionality included
- GUI quality is improved with FlowLayout and setBackground used
- Files can be chosen within the GUI
- New words can be added to the stop words list in GUI

If I had more time, I would include:
- The results being saved to a file
- Displaying what topics are returned
