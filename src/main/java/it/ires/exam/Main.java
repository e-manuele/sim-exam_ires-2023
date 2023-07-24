package it.ires.exam;

import it.ires.exam.dataobject.NetworkDistribution;
import it.ires.exam.dataobject.OperatorPlan;
import it.ires.exam.dataobject.SimCard;
import it.ires.exam.dataobject.Smartphone;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
            /*
    Il tempo di chiamata viene ritornato in secondi per motivi di test
     */

        OperatorPlan plan1 = new OperatorPlan("standard", 15.50);
        OperatorPlan plan2 = new OperatorPlan("medium", 20.50);
        OperatorPlan plan3 = new OperatorPlan("premium", 25.50);
        SimCard sim1 = new SimCard("+39 123 4567 890", plan1, 100);
        SimCard sim2 = new SimCard("+39 123 4567 891", plan2, 10);
        SimCard sim3 = new SimCard("+39 123 4567 892", plan3, 20);
        Smartphone smartphone1 = new Smartphone(sim1);


        smartphone1.startCall(sim2);

        smartphone1.startCall(sim3);
        Thread.sleep(2000);
        smartphone1.endCall();


        smartphone1.startCall(sim3);
        Thread.sleep(3000);
        smartphone1.endCall();

        System.out.println("smartphone1 time spent calling sim2: " + smartphone1.calculateCallsToSmn(sim2));
        System.out.println("smartphone1 total time spent calling " + smartphone1.calculateTotalCallsTime());
        System.out.println(sim1);


        ArrayList<SimCard> networkOperationSim = new ArrayList<>();
        ArrayList<OperatorPlan> networkOperationPlan = new ArrayList<>();
        networkOperationSim.add(sim1);
        networkOperationSim.add(sim3);
        networkOperationSim.add(sim2);
        networkOperationPlan.add(plan1);
        networkOperationPlan.add(plan2);
        networkOperationPlan.add(plan3);
        NetworkDistribution networkDistribution = new NetworkDistribution(networkOperationSim, networkOperationPlan);

        System.out.println(networkDistribution.operatorPlansToString());
    }
}
