package it.ires.exam;

import it.ires.exam.dataobject.NetworkDistribution;
import it.ires.exam.dataobject.OperatorPlan;
import it.ires.exam.dataobject.SimCard;
import it.ires.exam.dataobject.Smartphone;

import java.util.ArrayList;


public class PhoneApp {

    public static void main(String[] args) throws InterruptedException {
        //   Il tempo di chiamata viene ritornato in secondi per motivi di test

        OperatorPlan plan1 = new OperatorPlan("standard", 15.50);
        OperatorPlan plan2 = new OperatorPlan("medium", 20.50);
        OperatorPlan plan3 = new OperatorPlan("premium", 25.50);
        SimCard sim1 = new SimCard("+39 123 4567 890", plan1, 100);
        SimCard sim2 = new SimCard("+39 123 4567 891", plan2, 10);
//        SimCard sim3 = new SimCard("+39 123 4567 892", plan3, 20);
//        Smartphone smartphone1 = new Smartphone(sim1);
//        Smartphone smartphone2 = new Smartphone(sim2);
//
//
//        System.out.println("smartphone1 time spent calling sim2: " + smartphone1.calculateCallsToSmn(sim2));
//        System.out.println("smartphone1 time spent calling sim3: " + smartphone1.calculateCallsToSmn(sim3));
//        System.out.println("smartphone1 total time spent calling " + smartphone1.calculateTotalCallsTime());
//        System.out.println("sim1 info : " + sim1);
//        LASCIATA COMMENTATA COME  TEST PER LA PARTE 1 e 2



        NetworkDistribution networkDistribution = new NetworkDistribution();
        networkDistribution.addPlan(plan1);
        networkDistribution.addPlan(plan2);
        networkDistribution.addPlan(plan3);





        networkDistribution.updateCostPerMinToPlan("standard", 10.50);
        SimCard mySim = networkDistribution.createSimcard("+39 123 4567 890", plan1, 100);
        Smartphone mySmartphone = networkDistribution.createSmartphone(mySim);
        mySmartphone.startCall(sim1);
        mySmartphone.startCall(sim2);
        mySmartphone.endCall();


        System.out.println(networkDistribution.operatorPlansToString());




    }


}