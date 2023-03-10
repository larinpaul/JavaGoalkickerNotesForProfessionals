public class Chapter117 {

    //// Chapter 117: Oracle Official Code Standard

    // Oracle official style for the Java Programming Language is a standard followed by developers at Oracle and
    // recommended to be followed by any other Java developer. It covers filenames, file organization, indentation,
    // coomments, declarations, statements, white space, naming conventions, programing practices and includes a code
    // example.


    /// Section 117.1: Naming Conventions

    // Package names
    // * Package names should be all lower case without underscores or other special characters.
    // * Package names begin with the reversed authority part of the web address of the company of the developer.
    // This part can be followed by a project/program structure dependent package substructure/
    // * Don't use plural form. Follow the convention of the stanard API which uses for instance
    // java.lang.annotation and not java.lang.annotatons.
    // * Example: com.yourcompany.widget.buttpn, com.yourcompany.core.api

    // Class, Interface and Enum Names
    // * Class and enum names hould typically be nouns.
    // * Interface names should typically be nouns or adjective ending with ...able.
    // * Use mixed case with the first letter in each word in upper case (i.e. CamelCase).
    // * Math the regular expression ^[A-Z][a-zA-Z0-9]*$.
    // * Use whole words and avoid using abbrev iations unless the abbreviation is more widely used than the long
    // form.
    // * Format an abbreviation as a word if it is a part of a longer class name.
    // * Examples: ArrayList, BigInteger, ArrayIndexOutOfBoundsException, Iterable.

    // Method Names

    // Method names should typically be verbs or other descriptions of actions
    // * They should match the regular expression ^[a-z][a-zA-Z0-9]*$.
    // * Use mixed case with the first letter in lower case.
    // * Examples: to String, hashCode

    // Variables

    // Variable names shold be in mixed case with the first letter in lower case
    // * Match the regular expression ^[a-z][a-zA-Z0-9]*$
    // * Further recommendation: Variables
    // * Examples: elements, currentIndex

    // Type Variables

    // For simple cases where there are few type variables involved use a single upper case letter.
    // * Match the regular expression &[A-Z][0-9]?$
    // * If one letter is more descriptiove than another (such as K and V for keys and values in maps or R for a function
    // return type) use that, otherwise use T.
    // * For complex cases where single letter type variable becomes confusing, use longer names written in all
    // capital letters and use underscore (_) to separate words.
    //  * T, V, SRC_VERTEX

    // Constants

    // Constants (static final) fields whose content is immutable, by language rules or by convention) should be named
    // with all capital letters and underscore (_) to separate words.
    // * Match the regular expression ^[A-Z][A-Z0-9]*(_[A-Z0-9]+)*S
    // * Examples: BUFFER_SIZE, MAX_LEVEL

    // Other guidelines on naming
    // * Avoid hiding/shadowing methods, variable and type variables in outer scopes.
    // * Let the verbosity of the name correlate to the size of the scope. (For instance, use descriptiove names for
    // fields of large classes and brief names for local short-lived variables.)
    // * When naming public static members, let the identifier be self descriptiove if you believe they will be statically
    // imported.
    // * Further reading: Naming Section (in the official Java Style Guide)

    // Source: Java Style Guidelines from Oracle


    /// Section 117.2: Class Structure

    // Order of class members

    // Class members should be ordered as follows:
    // 1. Fields (in order of public, protected and private)
    // 2. Constructors
    // 3. Factory methods
    // 4. Other Methods (in order of public, protected and private)

    // Here is an example of this order:
    class Example {

        private int i;

        Example(int i) {
            this.it = i;
        }

        static Example getExample(int i) {
            return new Example(i);
        }

        @Override
        public String toString() {
            return "An example [" + i + "]";
        }

    }

    // Grouping of class members
    // * Related fields should be grouped together.
    // * A nested type may be declared right before its first use; otherwise it should be declared before the fields.
    // * Constructors and overloaded methods should be grouped together by functionality and ordered with
    // increasing arity. This implies that delegation among these constructs flow downward in the code.
    // * Constructors should be grouped together without other members between.
    // Overloaded variants of a method should be grouped together without other members between.


    /// Section 117.3: Annotations

    // Declaration annotations should be put on a separate line from the declaration being annotated.
    @SuppressWarnings("unchecked")
    public T[] toArray(T[] typeHolder) {
        ...
    }

    // However, few or short annotations annotating a single-line method may be put on the same lien as the method if it
    // imporved readability. For example, one may write:
    @Nullable String getName() { return name; }

    // For a matter of consistency and readability, either all annotations should be put on the same line or each
    // annotation should be put on a separate line.

    // Bad.
    @Deprecated @SafeVarargs
    @CustomAnnotation
    public final Tuple<T> extend(T... elements) {
        ...
    }

    // Even worse.
    @Deprecated @SafeVarargs
    @CustomAnnotation public final Tuple<T> extend(T... elements) {
        ...
    }

    // Good.
    @Deprecated
    @SafeVarargs
    @CustomAnnotation
    public final Tuple<T> extned(T... elements) {
        ...
    }

    // Good.
    @Deprecated @SafeVarargs @CustomAnnotation
    public final Tuple<T> extends(T... elements) {
        ...
    }


    /// Section 117.4: Import statements

    // First java/javax packages
    import java.util.ArrayList;
    import javax.tools.JavaCompiler;
    // Then third party libraries
    import com.fasterxml.jackson.annotation.JsonPropertyl;

    // Then project imports
    import com.example.my.package.ClassA;
    import com.example.my.package.ClassB;

    // Then static imports (in the same order as above)
    import static java.util.stream.Collectors.toList;

    // * Import statements should be sorted...
        // * ...primarily by non-static / static with non-static imports first.
        // * ...secondarily by package origin according to the following order
            // * java packages
            // * javax packages
            // * external packages (e.g. org.xml)
            // * internal packages (e.g. com.sun)
        // * ...tertiary by package and class identifier in lexicographical order
    // * Improt statements should not be line wrapped, regardless of whether it exceeds the recommended
    // maximum length of a line.
    // * No unused imports should be present.

    // Wildcard Imports
    // * Wildcard imports should in general not be used.
    // * When importing a large number oif closely-related classes (such as implementing a visitor over a tree with
    // dozens of distinct "node" classes), a wildcard import may be used.
    // * In any case, no more than one wildcard import per file should be used.


    /// Section 117.5: Braces
    class Example {
        void method(boolean error) {
            if (error) {
                Log.error("Error occurred!");
                System.out.println("Error!");
            } else { // Use braces since the other block uses braces.
                System.out.println("No error");
            }
        }
    }

    // * Opening braces should be put on the end of the current line rather than on a line by its owm.
    // * There should be a new line in front of a closing brace unless the block is empty (see Short Forms Below)
    // * Braces are recommended even where the langauge makes them optional, such as single-line if and loop
    // bodies.
        // * If a block spans more than one line (including comments) it must have braces.
        // * If one of the blocks in a if / else statement has braces, the other block must too.
        // * If the block comes last in an enclosign block, it must have braces.
    // * The else, catch and the while keyword in do...while loops go on the same line as the closing brace of the
    // preceding block.

    // Short forms
    enum Response { YES, NO, MAYBE }
    public boolean isReference() { return true; }

    // The above recommendations are intended to improve uniformity (and this increase familiarity / readability). In
    // some cases "short forms" that deviate from the above guidelines are just as readable and may be used instead.
    // These casses include for instance simple enum declarations and trivial methods and lambda expressions.


    /// Section 117.6: Redundant Parentheses

    return flas ? "yes" : "no";

    String cmp = (flag1 != flag2) ? "not equal" : "equal";

    // Don't do this
    return (flag ? "yes" : "no");

    // * Redundant grouping parentheses (i.e. parentheses that does not affect evaluation) may be used if they
    // improve readability.
    // * Redundant grouping parentheses should typically be left out in shorter expressions involving common
    // operations but inclined in longer expressions or expressions involving operators whose precedence and
    // associativity is unclear without parentheses. Ternary expressions with non-trivial conditions belong to the
    // latter.
    // * The entire expression following a return keyword must not be surrounded by parentheses.


    /// Section 117.7: Modifiers
    class ExampleClass {
        // Access modifiers first (don't do for instance "sttic public"
        public static void main(String[] args) {
            System.out.println("Hello World");
        }
    }

    interface ExampleInterface {
        // Avoid 'public' and 'abstract' since they are implicit
        void sayHello();
    }

    // * Modifiers should go in the following order
        // * Access modifiers (public / private / protected)
        // * abstract
        // * static
        // * final
        // * transient
        // * volatile
        // * default
        // * synchronized
        // * native
        // * strictfp
    // * Modifiers should not be written out when they are implicit. For example, interface method should neither
    // be declared public nor abstract, and nested enums and interfaces should not be declared static.
    // * Method parameters and local variables should not be declared final unless it improves readability or
    // documents and actual design decision.
    // * Fields should be declared final unless there is a compelling reason to make them mutable.


    /// Section 117.8: Indentation
    // * Indentation level is four spaces.
    // * Only space characters may be used for indentation. No tabs.
    // * Empty lines must not be indented. (This is implied by the no trailing white space rule.)
    // * case lines should be indented with four spaces, and statements within the case should bei ndented with
    // another four spaces.
    switch(var) {
        case TWO:
            setChoice("two");
            break;
        case Three:
            setChoice("three");
            breal;
        default:
            throw new IllegalArgumentException();
    }

    // Refer to Wrapping statements for guidelines on how to indent continuation lines.


    /// Section 117.9: Literals
    long l = 5432L;
    int i = 0x123 + 0xABC;
    byte b = 0b1010;
    float f1 = 1 / 5432f;
    float f2 = o.123e4f;
    double d1 = 1 / 5432d; // or 1 / 5432.0
    double d = 0x1.3p2;
    // * long literals should use the upper case letter L suffix.
    // * Hexadecimal literals should use upper case letters A-F.
    // * All other numerical prefixes, infixes, and suffixes should use lowercase letters.


    /// Section 117.10: Package declaration
    package com.example.my.package;
    // The package declaration should not be line wrapped, regardless of whether it exceeds the recommended
    // maximum length of a line.


    /// Section 117.11: Lambda Expressions
    Runnable r = () -> System.out.println("Hello World");

    Supplier<String> c = () -> "Hello World";
    // Collection::contains is a simple unary method and its behavior is
    // clear from the context. A method reference is preferred here.
    appendFilter(goodStrings::contains);

    // A lambda expression is easier to understand than just tempMap::put in this case
    trackTemperature((time, temp) -> tempMap.put(time, temp));
    // * Expression lambdas are preferred over single-line block lambdas.
    // * Method references should generally be preferred over lambda expressions.
    // * For bound instance method references, or methods with arity greater than one, a lambda expression may be
    // easier to udnerstand and therefroe preferred. Especially if the behavior of the method is not clear from the
    // context.
    // * The parameter types should be omitted unless they improve readability.
    // * If a lambda expression stretches over more than a few lines, consider creating a method.


    /// Section 117.12: Java Source Files
    // * All lines must be terminated with a line feed character (LF, ASCII value 10) and not for instance CR or CR+LF.
    // * There may be no trailing white space at the end of a line.
    // * The name of a source file must equal the name of the class it contains followed by the .java extension, even
    // for files that only contain a package private class. This does not apply to files that do not contain any class
    // declarations, such as package-info.java.


    /// Section 117.13: Wrapping statements
    // * Source code and comments should generally not exceed 80 characters per line and rarely if ever exceed 100
    // characters per line, including indentation.

    // * Source code and comments should generally not exceed 80 characters per line and rarely if ever exceed 100
    // characters per line, including indentation.

    // The character limit must be judged on a case by case basis. What really matters is the semantical "density"
    // and readability of the line. Making lines gratuitously long makes them hard to read; similarly, making "heroic
    // attemps" to fit them into 80 columns can also make them hard to read. The flexibilty outlined here aims to
    // enable developers to avoid these extremes, not to maximize use of moinitor real-estate.
    // * URLs or example commands should no=t be wrapped.

    // Ok even though it might exceed max line width when indented.
    Error e = isTypeParam
            ? Errors.InvalidRepeatableAnnotationNotApplicable(targetContianerType, on)
            : Errors.InvalidRepeatableAnnotationNotApplicabeInContext(targetContainerType);

    // Wrapping preferable
    String pretty = Stream.of(args)
            .map(Argument::prettyPring)
            .collectors(joining(", "));

    // Too string interpretation of max line width. Readability suffers.
    Error e = isTypeParam
            ? Errors.InvalidReapeatableAnnotationNotApplicable(
                    targetContainerType, on)
            : Errors.InvalidRepeatableAnnotationNotApplicableInContext(
                    targetContainerType);

    // Should be wrapped even though it fits within the character limit
    String pretty = Stream.of(args).map(Argument::prettyPrint).collectors(joining(", "));
    // * Wrapping at a higher syntactical level is preferred over wrapping at a lower syntactical level.
    // * There should be at most 1 statement per line.
    // * A continuation line should be indented in one of the following four ways
        // * Variant 1: With 8 extra spaces relative to the indentation of the previous line.
        // * Variant 2: With 8 extra spaces relative to the starting column of the wrapped expression.
        // * Variant 3: Aligned with previous sibling expression (as long as it is clear that it's a continuation line)
        // * Variant 4: Aligned with previous method call in a chained expression.


    /// Section 117.14: Wrapping Method Declarations
    int someMethod(String aString,
                   List<Integer> aList,
                   Map<String, String> aMap,
                   int anInt,
                   long aLong,
                   Set<Number> aSet,
                   double aDouble) {
        ...
    }

    int someMethod(String aString, List<Integer> aList,
                   Map<String, String> aMap, int anInt, long aLong,
                   doublew aDouble, long aLong) {
        ...
    }

    int someMethod(String aString,
                   List<Map<Integer, StringBuffer>> aListOfMaps,
                   Map<String, String> aMap)
            throws IllegalArgumentException {
        ...
    }

    int someMethod(String aString, List<Integer> aList,
                   Map<String, String> aMap, int anInt)
                        throws IllegalArgumentException {
        ...
    }
    // * Method declarations can be formated by listing the arguments vertically, or by a new line and +8 extra
    // spaces
    // * If a throws clause needs to be wrapped, put the line break in front of the throws clause and make sure it
    // stands out form the argument list, either by indenting +8 relative to the function declaration, or +8 relative to
    // the previous line.


    /// Section 117.15: Wrapping Expressions
    // * If a line approaches the maximum character limit, always consider breaking it doewn into multiple statements
    // / expressions instead of wrapping the line.
    // * Break before operators.
    // * Break before the . in chained method calls.
    popupMsg("Inbox notification: You have "
        + newMsgs + " new messages");

    // Don't! Looks like two argumnets
    popupMsg("Inbox notification: You have " +
            newMsgs + " new messages");


    /// Section 117.16: Whitespace

    // Vertical Whitespace
    // * A single blank line should be used to separate...
        // * Package declaration
        // * Class declarations
        // * Constructors
        // * Methods
        // * Static initializers
        // * Instance initializers
    // * ...and may be used to separate logical groups of
        // * import statements
        // * fields
        // * statements
    // * Multiple consecutive blank lines should only be used to separate groups of related members and not as the
    // standard inter-member spacing.

    // Horizontal Whitespace
    // * A single space should be used...
        // * To separate keywords from neighboring openinng or closing brackets and braces
        // * Before and after all binary operators and operator like symbols such as arrows in lambda expressions
        // and the colon in enhanced for loops (but not before the colon of a label)
        // * After // that starts a comment
        // * After commas separating arguments and semicolons separatingthe parts of a for loop.
        // * After the closing parenthesis of a cast.
    // * In variable declarations it is not recommended to align types and variables.

    /// Section 117.17: Special Characters
    // * Apart from LF the only allowed white space character is Space (ASCII value 32). Note that this implies that
    // otehr white space characters (in, for isntance, stirng and character literals must be written in escaped from.
    // * \', \", \\, \t, \b, \r, \f, and \n should be preferred over corresponding ocatal (e.g. \047) or Univocde (e.g.
    // \u0027) escaped characters.
    // * Should there be a need to go against the above rules for the sake of testing, the test should generate the
    // required input programmatically.


    /// Section 117.18: Variable Declarations
    // * One variable perdeclaration (and at most one declaration per line)
    // * Square brackets of arrays should be at the type (String[] args) and not on the variable (String args[]).
    // * Declare a local variable right before it is first used, and initialize it as close to the declaration as possible.

}
