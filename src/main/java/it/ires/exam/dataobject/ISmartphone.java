package it.ires.exam.dataobject;

public interface ISmartphone {
    public void startCall(SimCard dest);

    public void endCall();

    public boolean isInCall();

    public double calculateTotalCallsTime();

    public double calculateCallsToSmn(SimCard dest);

    public String toString();


}