package sample;

public class Transformation {

    private String from; //value which been entered by user
    private String to; //result of calculation

    public Transformation(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }


    public String toString() {
        return from + "------> " + to ;
    }


}
