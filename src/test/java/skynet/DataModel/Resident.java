package skynet.DataModel;



public class Resident {
    public String firstname;
    public String lastname;
    public String gender;
    public String wearableid;

    public Resident(String firstName, String lastName, String gender, String wearableId) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.gender = gender;
        this.wearableid = wearableId;
    }
}
