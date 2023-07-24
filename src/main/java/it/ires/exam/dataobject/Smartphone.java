package it.ires.exam.dataobject;

public class Smartphone implements ISmartphone {

    Call calling;
    SimCard simcard;

    public Smartphone(SimCard simcard) {
        this.simcard = simcard;
    }

    @Override
    public void startCall(SimCard dest) throws SimBusyException {
        if (this.simcard.getStatus()) {
            this.calling = new Call(dest);
            this.simcard.setStatus(SimStatus.OCCUPATO);
        } else{
            throw new SimBusyException();
    }}

    @Override
    public void endCall() {
        this.simcard.setStatus(SimStatus.LIBERO);
        this.simcard.addCall(this.calling.endCall());
        this.calling = null;
    }

    @Override
    public boolean isInCall() {
        return this.calling != null;
    }

    @Override
    public double calculateTotalCallsTime() {
        return this.simcard.getCallLog()
                .stream()
                .map(Call::getMinutes)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    @Override
    public double calculateCallsToSmn(SimCard dest) {
        return this.simcard.getCallLog()
                .stream()
                .filter(c -> c.getDest().equals(dest))
                .map(Call::getMinutes)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public String toString() {
        return this.simcard.toString();
    }
}
