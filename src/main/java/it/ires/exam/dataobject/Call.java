package it.ires.exam.dataobject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Call {
    SimCard dest;
    String startCall;
    String endCall;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    double minutes;

    public Call(SimCard dest) {
        this.dest = dest;
        this.startCall = LocalDateTime.now().format(dateTimeFormatter);

    }

    public SimCard getDest() {
        return dest;
    }

    public Call endCall() {
        this.endCall = LocalDateTime.now().format(dateTimeFormatter);
        this.minutes = Math.abs(java.time.Duration.between(LocalDateTime.parse(this.endCall), LocalDateTime.parse(this.startCall)).toSeconds()); //OVVIAMENTE VA CAMBIATO IN toMinutes()
        return this;
    }

    public double getMinutes() {
        if (this.endCall != null) {
            return this.minutes;
        } else {
            return Math.abs(java.time.Duration.between(
                    LocalDateTime.parse(LocalDateTime.now().format(dateTimeFormatter)),
                    LocalDateTime.parse(this.startCall)).toSeconds()); //OVVIAMENTE VA CAMBIATO IN toMinutes()
        }
    }

    @Override
    public String toString() {
        return "Call[" +
                "dest=" + dest +
                ", minutes=" + minutes+"] ";
    }
}


