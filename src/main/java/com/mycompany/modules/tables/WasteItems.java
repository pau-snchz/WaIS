
package com.mycompany.modules.tables;

public class WasteItems {
    private final int wasteID;
    private final String wasteName;
    private final String wasteClassification;

    public WasteItems(int id, String name, String classification)
    {
        this.wasteID = id;
        this.wasteName = name;
        this.wasteClassification = classification;
    }

    public int getID() 
    { 
        return wasteID; 
    }
    public String getName() 
    { 
        return wasteName; 
    }
    public String getCategory() 
    { 
        return wasteClassification; 
    }

    @Override
    public String toString() {
        return "WasteItem{id = " + wasteID + ", name='" + wasteName + "', category='" + wasteClassification + "'}";
    }
}
