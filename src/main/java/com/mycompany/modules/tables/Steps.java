
package com.mycompany.modules.tables;

public class Steps {
    private final int stepID;
    private final int ideaID;
    private final String stepTitle;
    private final String stepDesc;
    private final int order;

    public Steps(int ID, int idea, String title, String desc, int precedence) {
        this.stepID = ID;
        this.ideaID = idea;
        this.stepTitle = title;
        this.stepDesc = desc;
        this.order = precedence;
    }

    public int getStepID() {
        return stepID;
    }

    public int getIdeaID() {
        return ideaID;
    }

    public String getStepTitle() {
        return stepTitle;
    }

    public String getStepDesc() {
        return stepDesc;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "Steps{" +
                "stepID=" + stepID +
                ", ideaID=" + ideaID +
                ", stepTitle='" + stepTitle + '\'' +
                ", stepDesc='" + stepDesc + '\'' +
                ", order=" + order +
                '}';
    }
}
