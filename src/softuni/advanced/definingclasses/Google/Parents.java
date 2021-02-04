package softuni.advanced.definingclasses.Google;

public class Parents {
    private String parentName;
    private String parentBirthday;

    public String getParentName() {
        return parentName;
    }

    public String getParentBirthday() {
        return parentBirthday;
    }

    public Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }
}
