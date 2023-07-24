package it.ires.exam.dataobject;

import java.util.ArrayList;
import java.util.Optional;

public class NetworkDistribution {
    ArrayList<Smartphone> smartphoneArrayList;
    ArrayList<OperatorPlan> operatorPlanArrayList;

    public NetworkDistribution(ArrayList<Smartphone> smartphoneArrayList, ArrayList<OperatorPlan> operatorPlanArrayList) {
        this.smartphoneArrayList = smartphoneArrayList;
        this.operatorPlanArrayList = operatorPlanArrayList;
    }

    public void startCall(SimCard sim1, SimCard sim2) throws SimBusyException {
//        if (smartphoneArrayList.isInCall() && sim2.getStatus()) {
//            sim1.startCall(sim2);
//            sim2.startCall((sim1));
//        } else throw new SimBusyException("The sim is busy");
    }


    public void endCall(SimCard sim1, SimCard sim2) {
        if (!sim1.getStatus() && !sim2.getStatus()) {
            sim1.endCall();
            sim2.endCall();
        }
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


}
