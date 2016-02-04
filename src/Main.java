/**
 * Title:          Week 3 - Iterator (Animal Collection)
 * Author:         Elijah Cornell
 * Creation Date:  2016-02-01
 * Class:          PRG/421 - Roland Morales
 *
 * Program Requirements:
 *
 * Key parts:
 *  - Allow the reading of a collection of animal objects from an external file.
 *  - Output on screen the content of a collection of animal objects.
 *  - Use Iterator to achieve these goals.
 *
 * Must demonstrate the use of an Iterator
 *
 * Program Flow:
 *  -> Read animal.txt file into Animal collection
 *  -> Use an iterator to loop though and display animals in collection
 *
 * Input: animals.txt file
 * Output: Console
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    private final UI ui = UI.getInstance();

    /**
     * Main program loop
     */
    private void mainLoop() {

        ui.display("========================================");
        ui.display("|          Animal Collection           |");
        ui.display("|    PRG-421 - Wk3 - Elijah Cornell    |");
        ui.display("========================================");

        //

        List<Animal> animalList = new ArrayList<>();
        File animalFile = new File("animals.txt");

        parseAnimalFile(animalFile, animalList);

        displayAnimals(animalList);

    }

    /**
     * Parse animal data file
     * @param animalFile File of animal data
     * @param animalList List of animals
     */
    private void parseAnimalFile(File animalFile, List<Animal> animalList) {


        try(BufferedReader br = new BufferedReader(new FileReader(animalFile))) {

            String line = br.readLine();

            while (line != null) {

                Animal animal = new Animal(line);

                animalList.add(animal);

                line = br.readLine();
            }

        } catch (FileNotFoundException fefe) {

            ui.displayError("Could not find file " + animalFile.getAbsolutePath());

        } catch (IOException e) {

            ui.displayError("Could not process file " + animalFile.getName() + " : " + e.getMessage());

        }

    }

    /**
     * Display each animal within collection via an iterator
     * @param animalList List of animals
     */
    private void displayAnimals(List<Animal> animalList) {

        Iterator itr = animalList.iterator();

        while(itr.hasNext()) {

            Animal animal = (Animal) itr.next();

            ui.display( animal.getName() );

        }

    }


    /**
     * Main program entry point
     *
     * @param args None
     */
    public static void main(String[] args) {

        Main m = new Main();
        m.mainLoop();

    }

}
