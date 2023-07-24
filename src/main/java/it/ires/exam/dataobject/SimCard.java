package it.ires.exam.dataobject;

import java.util.ArrayList;
import java.util.Objects;

public class SimCard {
    final String number;
    String user;
    Call calling;
    SimStatus status;
    double credit;
    OperatorPlan operatorPlan;
    ArrayList<Call> callLog;


    public SimCard(String number, OperatorPlan operatorPlan,double credit) {
        this.number = number;
        this.operatorPlan = operatorPlan;
        this.credit = credit;
        this.setStatus(SimStatus.LIBERO);
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

    public void startCall(SimCard dest) throws SimBusyException {
        if (this.getStatus()) {
            this.calling = new Call(dest);
            this.setStatus(SimStatus.OCCUPATO);
        } else{
            throw new SimBusyException("The sim is busy");
        }
    }
    public void endCall() {
        this.setStatus(SimStatus.LIBERO);
        this.addCall(this.calling.endCall());
        credit = credit - (this.calling.getMinutes() * operatorPlan.costPerMin);
        this.calling = null;

    }
}
