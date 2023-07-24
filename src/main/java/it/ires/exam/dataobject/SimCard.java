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
    ArrayList<Call> callLogSent;
    ArrayList<Call> callLogReceived;


    public SimCard(String number, OperatorPlan operatorPlan,double credit) {
        this.number = number;
        this.operatorPlan = operatorPlan;
        this.credit = credit;
        this.setStatus(SimStatus.LIBERO);
        callLogSent = new ArrayList<>();
        callLogReceived = new ArrayList<>();
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public ArrayList<Call> getCallLogSent() {
        return callLogSent;
    }

    public void addCall(Call call){
        this.callLogSent.add(call);
    }
    public void addCallReceived(Call call){
        this.callLogReceived.add(call);
    }

    public void getCall(SimCard caller) throws SimBusyException {
        if (this.getStatus()) {
            this.calling = new Call(caller);
            this.setStatus(SimStatus.OCCUPATO);
        } else{
            throw new SimBusyException("The sim is busy");
        }
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
                ", callLog=" + callLogSent;
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
        credit = credit - (this.calling.getMinutes() * operatorPlan.getCostPerMin());
        this.calling = null;

    }
    public void endCallReceived() {
        this.setStatus(SimStatus.LIBERO);
        this.addCallReceived(this.calling.endCall());
        this.calling = null;

    }
}
