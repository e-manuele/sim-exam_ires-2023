package it.ires.exam;
import it.ires.exam.dataobject.OperatorPlan;
import it.ires.exam.dataobject.SimCard;



public class PhoneApp {

  public static void main(String[] args)  {
    OperatorPlan plan = new OperatorPlan("standard", 15.10);
    SimCard sim = new SimCard("+39 123 4567 890", plan, 100);
    System.out.println("Hello world");
  }

}