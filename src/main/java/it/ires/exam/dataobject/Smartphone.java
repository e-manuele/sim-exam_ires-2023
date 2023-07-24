package it.ires.exam.dataobject;

public class Smartphone implements ISmartphone {


    SimCard simcard;

    public Smartphone(SimCard simcard) {
        this.simcard = simcard;
    }

    @Override
    public void startCall(SimCard dest) {
        try {
            this.simcard.startCall(dest);
        } catch (SimBusyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void endCall() {
        this.simcard.endCall();
    }

    @Override
    public boolean isInCall() {
        return this.simcard.calling != null;
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
