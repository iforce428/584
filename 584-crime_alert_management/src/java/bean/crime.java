package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN123
 */
public class crime implements java.io.Serializable {

    public int ID;
    public String crimename;
    public int resident_id;
    public int crime_id;
    public String crimetype;
    public String place;
    public int place_id;
    public String notes;
    public String time;
    public String Status;

    public crime() {
    }

    public crime(int ID, String crimename, int resident_id, int crime_id, int place_id, String notes, String time, String Status) {
        this.ID = ID;
        this.crimename = crimename;
        this.resident_id = resident_id;
        this.crime_id = crime_id;
        this.place_id = place_id;
        this.notes = notes;
        this.time = time;
        this.Status = Status;
    }

    public int getID() {
        return this.ID;
    }

    public String getCrimename() {
        return this.crimename;
    }

    public String getCrimetype() {
        return this.crimetype;
    }

    public String getPlace() {
        return this.place;
    }
    
        public void setCrimetype(String type) {
        this.crimetype = type;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getResident_id() {
        return resident_id;
    }

    public int getCrime_id() {
        return crime_id;
    }

    public int getPlace_id() {
        return place_id;
    }

    public String getNotes() {
        return notes;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return Status;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCrimename(String crimename) {
        this.crimename = crimename;
    }

    public void setResident_id(int resident_id) {
        this.resident_id = resident_id;
    }

    public void setCrime_id(int crime_id) {
        this.crime_id = crime_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

}
