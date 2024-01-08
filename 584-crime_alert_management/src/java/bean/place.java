/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author mamir
 */
public class place {

    private int id;
    private String placeName;

    // Constructor
    public place() {
        this.id = 0;
        this.placeName = "";
    }

    public place(int id, String placeName) {
        this.id = id;
        this.placeName = placeName;
    }

    // Getter for id
    public int getId() {
        return this.id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for placeName
    public String getPlaceName() {
        return placeName;
    }

    // Setter for placeName
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
