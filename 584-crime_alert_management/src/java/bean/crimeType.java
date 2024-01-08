package bean;


public class crimeType {
    private int id;
    private String crimeType;
    
    public crimeType(){
        this.id = 0;
        this.crimeType = null;
    }

    // Constructor
    public crimeType(int id, String crimeType) {
        this.id = id;
        this.crimeType = crimeType;
    }

    // Getter for id
    public long getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for crimeType
    public String getCrimeType() {
        return crimeType;
    }

    // Setter for crimeType
    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }
}
