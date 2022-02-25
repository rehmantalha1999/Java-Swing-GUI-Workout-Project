/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inheritance;

import SysClasses.AllExercisesSys;

/**
 *
 * @author Talha
 */
public class Pull extends WorkoutProgram {

    private String pullTargetMuscle;

    public Pull(String exerciseId, String exerciseName, String exerciseType, String pullTargetMuscle) {
        super(exerciseId, exerciseName, exerciseType);
        this.pullTargetMuscle = pullTargetMuscle;
    }

    public String getPullTargetMuscle() {
        return pullTargetMuscle;
    }
 public void WeightsSetter(int weightsLifted, int noOfSets, int noOfReps) {    
        super.WeightsSetter(weightsLifted, noOfSets, noOfReps);
    }

    @Override
    public String toString() {
        return super.toString() + "TargetMuscle: " + pullTargetMuscle + "\nCurrent Strength Level: " + currentStrengthLevel()+"\n";
    }

  @Override
    public String display() {
        return super.display() + ", Target Muscle:"+ pullTargetMuscle; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String currentStrengthLevel() {

        for (int i = 0; i < AllExercisesSys.strength.size(); i++) {
            if (AllExercisesSys.strength.get(i).ExName.equalsIgnoreCase(exerciseName)) {
                if (weightsLifted <= AllExercisesSys.strength.get(i).beginner) {
                    return ("Beginner");
                } else if (weightsLifted > AllExercisesSys.strength.get(i).beginner && weightsLifted <= AllExercisesSys.strength.get(i).intermediate) {
                    return ("Intermediate");
                } else {
                    return ("Advanced!");
                }
            }

        }
        return null;
    }
}
