
package com.mycompany.modules.tables;

public class Materials {
    private final int matdetID;
    private final int ideaID;
    private final String name;
    private final String quantity;

    public Materials(int ID, int idea, String itemName, String size) {
        this.matdetID = ID;
        this.ideaID = idea;
        this.name = itemName;
        this.quantity = size;
    }

    public int getMatdetID() {
        return matdetID;
    }

    public int getIdeaID() {
        return ideaID;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Materials{" +
                "matdetID=" + matdetID +
                ", ideaID=" + ideaID +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
