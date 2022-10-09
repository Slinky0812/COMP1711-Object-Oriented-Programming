# Lecture 7 Examples

`Array.c` and `Array.java` compare array access in C and Java, demonstrating
that C does no initialisation of array elements and no bounds checking,
whereas Java ensures that arrays of primitives are initialised and that we
cannot exceed the bounds of an array.

`ArrayInit.java` shows different approaches to array initialisation,
including examples of **static initialisation**.

`ArrayLoop.java` demonstrates the two styles of for loop that can be used
to iterate over array contents.

`ArrayPrint.java` shows that you don't get useful output if you try to
print an array using `System.out.println()`.  It also shows how you can
use the `toString()` and `deepToString()` methods of the `Arrays` utility
class to do 'pretty printing' of array contents.

`ArrayUtil.java` demonstrate use of the various utility methods provided
in the `Arrays` class.

`Wrapper.java` shows how **wrapper classes** such as `Integer` are used
to store lists of values that are normally represented in Java using
primitive types.

`ListBenchmark.java` compares the performance of `ArrayList` and `LinkedList`
in a scenario where a list is constructed by repeatedly inserting items
at the front of the list.  Try running it like so:

    java ListBenchmark 5000
    java ListBenchmark 20000
    java ListBenchmark 100000
    java ListBenchmark 200000

`ListMethods.java` contains examples of invoking various methods on lists.

`Lotto.java` shows how list methods and some of the utility methods from
the `Collections` class can be used to simulate the National Lottery.
