package SysClasses;

import Inheritance.WorkoutProgram;
import Inheritance.Pull;
import Inheritance.Push;
import Inheritance.Legs;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Talha
 */
public class ExerciseSys {

    public static ArrayList<WorkoutProgram> SelectedExList = new ArrayList<WorkoutProgram>();

    public static boolean checkId(String exId) {
        for (int i = 0; i < SelectedExList.size(); i++) {
            WorkoutProgram get = SelectedExList.get(i);
            if (get.findID(exId)) {
                return (true);
            }
        }
        return false;
    }

    public static boolean addExercise(String id, int weightsLifted, int noOfSets, int noOfReps) {
        // id, weights lifted, no of sets, no of reps

        if (checkId(id)) {
            System.out.println("Exercise already exists!");
            return (false);
        } else {
            for (int j = 0; j < AllExercisesSys.list.size(); j++) {
                WorkoutProgram w = AllExercisesSys.list.get(j);
                if (w.getExerciseId().equalsIgnoreCase(id)) {              
                    if (w.getExerciseType().equalsIgnoreCase("push")) {
                        Push e;
                        e = (Push) w;
                        Push p = new Push(e.getExerciseId(), e.getExerciseName(), e.getExerciseType(), e.getPushTargetMuscle());
                        p.WeightsSetter(weightsLifted, noOfSets, noOfReps);
                        SelectedExList.add(p);
                        System.out.println("Exercise Added!");

                    } else if (w.getExerciseType().equalsIgnoreCase("pull")) {
                        Pull e;
                        e = (Pull) w;
                        Pull p = new Pull(e.getExerciseId(), e.getExerciseName(), e.getExerciseType(), e.getPullTargetMuscle());
                        p.WeightsSetter(weightsLifted, noOfSets, noOfReps);
                        SelectedExList.add(p);
                        System.out.println("Exercise Added!");

                    } else {
                        Legs e;
                        e = (Legs) w;
                        Legs p = new Legs(e.getExerciseId(), e.getExerciseName(), e.getExerciseType(), e.getLegTargetMuscle());
                        p.WeightsSetter(weightsLifted, noOfSets, noOfReps);
                        SelectedExList.add(p);
                        System.out.println("Exercise Added!");
                    }

                }
            }

        }
        return true;

    }

    public static WorkoutProgram removeExercise(String id) {
        WorkoutProgram sm = null;
        for (int i = 0; i < SelectedExList.size(); i++) {
            if (SelectedExList.get(i).getExerciseId().equalsIgnoreCase(id)) {
                sm = SelectedExList.remove(i);
                return sm;
            }
        }
        return null;
    }

    public static String getAllSelectedExercises() {
        String res = "";
        for (WorkoutProgram v : SelectedExList) {
            res += v.toString();
        }
        return res;
    }

    public static String getExercisesByType(String type) {
        String res = "";

        switch (type) {
            case "push":
                for (WorkoutProgram sm : SelectedExList) {
                    if (sm instanceof Push) {
                        res += sm.toString();
                    }
                }
                break;
            case "pull":
                for (WorkoutProgram sm : SelectedExList) {
                    if (sm instanceof Pull) {
                        res += sm.toString();
                    }
                }
            case "legs":

                for (WorkoutProgram sm : SelectedExList) {
                    if (sm instanceof Legs) {
                        res += sm.toString();
                    }
                }
                break;

        }
        return res;
    }

    public static String[] getAllExercisesNames() {
        String[] disp = new String[SelectedExList.size()];
        for (int i = 0; i < SelectedExList.size(); i++) {

            disp[i] = SelectedExList.get(i).getExerciseName();
        }

        return (disp);
    }
    
    public static WorkoutProgram searchExercise(String ExerciseName) {
        for (int i = 0; i < SelectedExList.size(); i++) {
            if (SelectedExList.get(i).getExerciseName().equalsIgnoreCase(ExerciseName)) {

                return (SelectedExList.get(i));
            }
        }

        return null;

    }
}
