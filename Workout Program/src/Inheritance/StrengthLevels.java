package Inheritance;

/**
 *
 * @author Talha
 */
public class StrengthLevels {
    String ExId;
    String ExName;
    int beginner;
    int intermediate;

    public StrengthLevels(String ExId, String ExName, int beginner, int intermediate) {
        this.ExId = ExId;
        this.ExName = ExName;
        this.beginner = beginner;
        this.intermediate = intermediate;
    }

    public String getExName() {
        return ExName;
    }

    public int getBeginner() {
        return beginner;
    }

    public int getIntermediate() {
        return intermediate;
    }
 
}
