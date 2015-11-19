# HuffmanEncoding
AD300 - Assignment 6

Your task is to solve the Programming Project #5 (Huffman Coding) on page 1092.

Here are some details and interface requirements:

Create a public class HuffmanEncode

with a Constructor

public class HuffmanEncode(File input)

and public methods

public void encode()

The latter does the following:

Reads the File Object and counts the occurrence of every character (including special characters like newline and blanks).
Fills the Priority Queue with the nodes that you create out of the characters and occurrences.
Builds the Huffman Tree
Traverses the Huffman Tree 
The Traversal method should print for every leaf node the following info

'Character'<blank>Code<blank>Occurence.


The File foxtext.txt should create the following output:

'o' 000 4
'a' 001 4
'g' 01000 1
'j' 01001 1
'm' 01010 1
'u' 010110 1
'i' 010111 1
'
' 0110 3
'b' 011100 1
'x' 011101 1
'z' 011110 1
'y' 011111 1
't' 10000 2
'v' 100010 1
'l' 100011 1
'e' 1001 4
'n' 10100 2
''' 101010 1
's' 101011 1
'f' 10110 2
'h' 10111 2
'c' 110000 1
'p' 110001 1
'r' 11001 2
'T' 110100 1
'w' 110101 1
'd' 11011 2
' ' 111 8

As you can see in the "broken line" between 'i' and 'b' the newline character creates a newline in the output. 

Hints: Combining the nodes means that the new node does not have a character, it only has children and an occurrence value. The "combined" occurrence value is the sum of the values of the 2 children nodes.

Here is an example for the fields in a private node class that you might want to utilize in your Class:

private Character symbol; // char to be coded, empty if combined node
private CharNode leftChild; //
private CharNode rightChild; // 
private CharNode parent;
private Integer weight; // occurrence # of this char in the text

You need to think about the fact that the PriorityQueue needs to know how to order the elements (Comparable Interface).

Have fun! (I did. Took me 3 hours, so be prepared to set some time aside).

Julien Feis
