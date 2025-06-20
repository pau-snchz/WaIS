
package com.mycompany.modules.tables;

public class RecyclingIdeas {
    private final int ideaID;
    private final int accID;
    private final int wasteID;
    private final String title;
    private final String imgURL;
    private final String dateCreated;

    public RecyclingIdeas(int idea, int acc, int waste, String name, String url, String date) {
        this.ideaID = idea;
        this.accID = acc;
        this.wasteID = waste;
        this.title = name;
        this.imgURL = url;
        this.dateCreated = date;
    }

    public int getIdeaID() {
        return ideaID;
    }

    public int getAccID() {
        return accID;
    }

    public int getWasteID() {
        return wasteID;
    }

    public String getTitle() {
        return title;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "RecyclingIdeas{" +
                "ideaID=" + ideaID +
                ", accID=" + accID +
                ", wasteID=" + wasteID +
                ", title='" + title + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", dateCreated='" + dateCreated +
                '}';
    }
}
