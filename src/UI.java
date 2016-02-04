/**
 * Title:          Week 3 - Iterator (Animal Collection)
 * Author:         Elijah Cornell
 * Creation Date:  2016-02-01
 * Class:          PRG/421 - Roland Morales
 */

/**
 * Helper class to handle user interface / console interactions
 * <p/>
 * Usage: UI ui = UI.getInstance();
 */
public class UI {

    private static final UI SINGLETON = new UI();

    /**
     * @return Singleton UI instance
     */
    public static UI getInstance() {
        return SINGLETON;
    }

    /**
     * Private default constructor for singleton pattern
     */
    private UI() {
    }

    /**
     * Display a message to the console
     *
     * @param text Text string to display
     */
    public void display(String text) {
        System.out.println(text);
    }

    /**
     * Display a custom error message to the console
     *
     * @param text Error text to display
     */
    public void displayError(String text) {
        spacer();
        display("!!!  ERROR: " + text);
        spacer();
    }

    /**
     * Display a blank line to the console
     */
    public void spacer() {
        System.out.print(System.lineSeparator());
    }

}
