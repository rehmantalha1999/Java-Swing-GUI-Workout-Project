package SysClasses;

import Inheritance.WorkoutProgram;
import Inheritance.Pull;
import Inheritance.Push;
import Inheritance.Legs;
import Inheritance.StrengthLevels;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author Talha
 */
public class AllExercisesSys {

    public static ArrayList<StrengthLevels> strength = new ArrayList<StrengthLevels>();
    public static ArrayList<WorkoutProgram> list = new ArrayList<WorkoutProgram>();

    public static void readExTxt(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("ERROR:File does not exists!");
            System.exit(0);
        }
        String exId;
        String exName;
        String exType;
        String targetMuscle;

        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            exId = input.next();
            exName = input.next();
            exType = input.next();
            targetMuscle = input.nextLine();

            if (exType.equalsIgnoreCase("push")) {
                Push push = new Push(exId, exName, exType, targetMuscle);
                list.add(push);
            } else if (exType.equalsIgnoreCase("pull")) {
                Pull pull = new Pull(exId, exName, exType, targetMuscle);
                list.add(pull);
            } else {
                Legs legs = new Legs(exId, exName, exType, targetMuscle);
                list.add(legs);
            }

        }
        input.close();
    }

    public static void readStrengthLevelTxt(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("ERROR:File does not exists!");
            System.exit(0);
        }
        String exId;
        String exName;
        int beginner;
        int intermediate;

        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            exId = input.next();
            exName = input.next();
            beginner = input.nextInt();
            intermediate = input.nextInt();

            StrengthLevels str = new StrengthLevels(exId, exName, beginner, intermediate);
            strength.add(str);
        }
        input.close();
    }

    public static WorkoutProgram searchExercise(String ExerciseName) {
        String s=ExerciseName.replace(" ","-");
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getExerciseName().equalsIgnoreCase(s)) {

                return (list.get(i));
            }
        }

        return null;

    }

    public static String getAllExercisesNamesString() {
        String disp = "";
        for (int i = 0; i < list.size(); i++) {
            disp += i + 1 + ". " + list.get(i).getExerciseName() + "\n";
        }

        return (disp);
    }

    public static String[] getAllExercisesNames() {
        String[] disp = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {

            disp[i] = list.get(i).getExerciseName();
        }

        return (disp);
    }

    public static String displayAllExercises() {
        String disp = "";
        for (int i = 0; i < list.size(); i++) {

            disp += list.get(i).display() + "\n";
        }

        return (disp);
    }

}
