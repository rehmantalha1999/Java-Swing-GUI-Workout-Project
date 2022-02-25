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
public class Legs extends WorkoutProgram {

    private String legTargetMuscle;
    
    public Legs(String exerciseId, String exerciseName,String exerciseType, String legTargetMuscle) {
        super(exerciseId, exerciseName,exerciseType);
        this.legTargetMuscle = legTargetMuscle;
    }

    public String getLegTargetMuscle() {
        return legTargetMuscle;
    }
    public void WeightsSetter(int weightsLifted, int noOfSets, int noOfReps) {    
        super.WeightsSetter(weightsLifted, noOfSets, noOfReps);
    }
     @Override
    public String toString() {
        return super.toString() + "TargetMuscle: "+ legTargetMuscle + "\nCurrent Strength Levels: " + currentStrengthLevel()+"\n";
    }
    @Override
    public String display() {
        return super.display() + ", Target Muscle:"+ legTargetMuscle; //To change body of generated methods, choose Tools | Templates.
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
