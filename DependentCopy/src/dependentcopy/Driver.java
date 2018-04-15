
package dependentcopy;

/**
 * This example demonstrates a very poor design -- one that is
 * burdened by dependency issues, causing Rigidity (requires KeyboardReader 
 * and ScreenWriter objects), Fragility (changing the Copier class to accomodate
 * other Reader or Writer objects might break programs using the original version) 
 * and Immobility (you can't use the Copier class where file input and file 
 * output are needed, for example).
 * <p>
 * Notice that the High-Level Copier class (also called the client, because it uses 
 * the services of other objects) is highly dependent on the KeyboardReader 
 * and ScreenWriter implementations (Low-Level classes).
 * 
 * Design error #1 -- Copier violates Dependency Inversion Principle, which
 * states that 1) High-level modules should not depend upon low level
 * modules. Both should depend upon abstractions; and, 2) Abstractions
 * should not depend upon details. Details should depend upon abstractions. The
 * term "details" refers to implementation logic.
 * <p>
 * Design error #2 -- violates Liskov Substitution Principle, which tells us:
 * derived classes (e.g., KeyboardReader and ScreenWriter) must be usable 
 * through their base class interface (in this case the base class is the
 * Object class), without the client (in this case, Copier) being able to tell 
 * the difference. That isn't true here! The object class does not have the
 * methods readln() and writeln() which are in KeyboardReader and KeyboardWriter
 * respectively.
 * <p>
 * INSTRUCTIONS: to run this from Netbeans, press the run button and type in
 * some text at the output console. Then press return. The text will be copied to
 * the output console.
 * 
 * @author  Jim Lombardo
 * @version 1.02 
 * @see     IndependentCopy project - an improved version.
 * @see     UML diagram for architectural concept
*/
public class Driver {

	public static void main(String[] args) {
		// Declare rigid, concrete objects
		KeyboardReader reader = new KeyboardReader();
		ScreenWriter writer = new ScreenWriter();
		
		// Copy from reader to writer
		// Notice that copier is dependent on implementation of reader/writer
		// making it rigid, fragile and immobile
		Copier copier = new Copier( reader, writer );
		copier.copy();
		
		// Send end of program message
		System.out.println("Program ended. Line of reader input copied successfully to writer output.");
	}
}
