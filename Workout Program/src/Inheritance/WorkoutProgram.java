package Inheritance;

import Interface.TargetWeightsInterface;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Talha
 */
abstract public class WorkoutProgram implements TargetWeightsInterface {

    protected String exerciseId;
    protected String exerciseName;
    protected String exerciseType;
    protected int noOfReps = 0;
    protected int noOfSets = 0;
    protected int weightsLifted = 0;

    public WorkoutProgram(String exerciseId, String exerciseName, String exerciseType) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
    }

    public boolean findID(String id) {
        if (this.exerciseId.equalsIgnoreCase(id)) {
            return true;
        } else {
            return false;
        }
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public int getNoOfReps() {
        return noOfReps;
    }

    public int getNoOfSets() {
        return noOfSets;
    }

    public int getWeightsLifted() {
        return weightsLifted;
    }

    public void WeightsSetter(int weightsLifted, int noOfSets, int noOfReps) {    
        this.weightsLifted = weightsLifted;
        this.noOfSets = noOfSets;
        this.noOfReps = noOfReps;
    }

    @Override
    public String toString() {
        return "ExerciseId: " + exerciseId + "\nExerciseName: " + exerciseName + "\nExerciseType: " + exerciseType + "\nNoOfReps: " + noOfReps + "\nNoOfSets: " + noOfSets + "\nWeightsLifted: " + weightsLifted + "\nWeights to lift next week: " + calcWeightsToLiftNextWeek() + "\n";
    }

    public String display() {
        return exerciseName ;
    }

    @Override
    public double calcWeightsToLiftNextWeek() {
        return Math.round(weightsLifted * 1.05);
    }

    public abstract String currentStrengthLevel();

}
