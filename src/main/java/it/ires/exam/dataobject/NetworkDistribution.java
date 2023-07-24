package it.ires.exam.dataobject;

import java.util.ArrayList;
import java.util.Optional;

public class NetworkDistribution {
    ArrayList<Smartphone> smartphoneArrayList;
    ArrayList<OperatorPlan> operatorPlanArrayList;

    public NetworkDistribution() {
        this.smartphoneArrayList = new ArrayList<>();
        this.operatorPlanArrayList = new ArrayList<>();
    }

    public void startCall(Smartphone smartphone1, SimCard sim2) throws SimBusyException {
            smartphone1.startCall(sim2);
            sim2.getCall(smartphone1.getSimcard());
    }


    public void endCall(Smartphone smartphone1) {
       SimCard called = smartphone1.getCalling();
       smartphone1.endCall();
       called.endCallReceived();

    }


    public String operatorPlansToString() {
        return String.valueOf(operatorPlanArrayList);
    }

    public OperatorPlan getPlan(String name) {
        Optional<OperatorPlan> thisPlan =
                operatorPlanArrayList.stream()
                        .filter(plan -> plan.name.equals(name))
                        .findFirst();
        if (thisPlan.isPresent()) {
            return thisPlan.get();
        } else {
            System.out.println("The plan is not present. Check name");
            return null;
        }
    }
    public void updateCostPerMinToPlan(String name,double costPerMin){
        getPlan(name).setCostPerMin(costPerMin);
    }

    public SimCard createSimcard(String number, OperatorPlan operatorPlan,double credit) {
        return new SimCard( number, operatorPlan,credit);
    }
    public void addPlan(OperatorPlan plan){
        this.operatorPlanArrayList.add(plan);
    }

    public Smartphone createSmartphone(SimCard sim){
        return new Smartphone(sim);
    }


}
