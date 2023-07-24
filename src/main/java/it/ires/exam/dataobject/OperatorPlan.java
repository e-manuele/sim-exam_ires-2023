package it.ires.exam.dataobject;

public class OperatorPlan {
    double costPerMin;
    String name;
    public OperatorPlan(String name, double costPerMin){
        this.name = name;
        this.costPerMin=   costPerMin;
    }

    public double getCostPerMin(){
        return  this.costPerMin;
    }
}
