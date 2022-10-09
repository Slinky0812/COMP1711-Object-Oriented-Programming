# Lecture 8 Examples

## Exceptions

`Division.java` is a simple program to divide one integer value by another.
Run this program and see if you can trigger three different types of
exception. (Try an input of 0, or something that isn't a number.  Try
closing the input stream using `Ctrl+D`.)

`NPE.java` demonstrates one of the most common Java exceptions:
`NullPointerException`.  This occurs when you use an object reference to
invoke a method, but the object doesn't exist.

`Control.java` demonstrates how exceptions affect flow of control.  Try
running this program twice, the first time with a non-zero input value and
the second time with 0 as input. Compare the output generated in each case.

`CatchTest1.java` shows how multiple `catch` blocks can be used to
intercept the different types of exception that might occur when reading
and processing numerical data from a file.  `CatchTest2.java` is an
equivalent program that uses a single `catch` block to intercept all types
of exception and handle them all the same way.

`Checked` demonstrates occurrence of a checked exception in code.  Notice
that this also features an **exception specification**, which you are
required to write on methods that don't catch the checked exceptions
occurring within them.

## File I/O

`ReadFile1.java` shows the two simplest ways of reading a text file,
using classes from the Java NIO API.  One way gives you the file contents
as one large string, the other gives you the lines as a list of strings.

`ReadFile2.java` shows a low-level approach to reading text from a file
line by line, using the `BufferedReader` class.

`ReadFile3.java` does the same thing as `ReadFile2.java`, but in a slightly
simpler way, using the `Scanner` class.  This program also demonstrates
the use of a 'try with resources' block.

The programs in `WriteFileBad.java` and `WriteFileGood.java` both write
formatted data to a text file.  `WriteFileBad` makes the mistake of
not closing the file, with the result that nothing ends up in the file!
`WriteFileGood` fixes the problem using a 'try with resources' block.
This ensures that the file will always be closed properly, however the
program terminates.
