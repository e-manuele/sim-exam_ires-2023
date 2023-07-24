package it.ires.exam.dataobject;

import java.util.ArrayList;
import java.util.Objects;

public class SimCard {
    final String number;
    String user;
    SimStatus status;
    double credit;
    OperatorPlan operatorPlan;
    ArrayList<Call> callLog;


    public SimCard(String number, OperatorPlan operatorPlan,double credit) {
        this.number = number;
        this.operatorPlan = operatorPlan;
        this.credit = credit;
        callLog = new ArrayList<>();
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public ArrayList<Call> getCallLog() {
        return callLog;
    }

    public void addCall(Call call){
        this.callLog.add(call);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SimCard simCard = (SimCard) o;
        return  Objects.equals(number, simCard.number) &&
                Objects.equals(user, simCard.user);
    }

    @Override
    public String toString() {
        return "SimCard :" +
                "number='" + number + '\'' +
                ", user='" + user + '\'' +
                ", credit=" + credit +
                ", operatorPlan=" + operatorPlan +
                ", callLog=" + callLog;
    }

    public boolean getStatus() {
        return status.isValue();
    }

    public void setStatus(SimStatus status) {
        this.status = status;
    }
}
