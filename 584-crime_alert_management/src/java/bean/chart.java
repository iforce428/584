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
public class chart {
    private String label;
    private int data;
    
    
    public chart(String label, int data){
        this.label = label;
        this.data = data;
    }

    // Getter for label
    public String getLabel() {
        return label;
    }

    // Setter for label
    public void setLabel(String label) {
        this.label = label;
    }

    // Getter for data
    public int getData() {
        return data;
    }

    // Setter for data
    public void setData(int data) {
        this.data = data;
    }
}
