package it.ires.exam.dataobject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Call {
    SimCard dest;
    LocalDateTime startCall;
    LocalDateTime endCall;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    double minutes;

    public Call(SimCard dest) {
        this.dest = dest;
        this.startCall = LocalDateTime.parse(LocalDateTime.now().format(dateTimeFormatter));
    }

    public SimCard getDest() {
        return dest;
    }

    public Call endCall() {
        this.endCall = LocalDateTime.parse(LocalDateTime.now().format(dateTimeFormatter));
        this.minutes = java.time.Duration.between(this.endCall, this.startCall).toMinutes();
        return this;
    }

    public double getMinutes() {
        if (this.endCall != null) {
            return this.minutes;
        } else {
            return java.time.Duration.between(
                    LocalDateTime.parse(LocalDateTime.now().format(dateTimeFormatter)),
                    this.startCall).toMinutes();
        }
    }


}


