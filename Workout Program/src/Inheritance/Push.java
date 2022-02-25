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
public class Push extends WorkoutProgram {

    private String pushTargetMuscle;

    public Push(String exerciseId, String exerciseName, String exerciseType, String pushTargetMuscle) {
        super(exerciseId, exerciseName, exerciseType);
        this.pushTargetMuscle = pushTargetMuscle;
    }

    public String getPushTargetMuscle() {
        return pushTargetMuscle;
    }

    @Override
    public String toString() {
        return super.toString() + "TargetMuscle: " + pushTargetMuscle + "\nCurrent Strength Level: "+ currentStrengthLevel()+"\n\n";
    }

    @Override
    public String display() {
        return super.display() + ", Target Muscle:"+ pushTargetMuscle; //To change body of generated methods, choose Tools | Templates.
    }
   public void WeightsSetter(int weightsLifted, int noOfSets, int noOfReps) {    
        super.WeightsSetter(weightsLifted, noOfSets, noOfReps);
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
