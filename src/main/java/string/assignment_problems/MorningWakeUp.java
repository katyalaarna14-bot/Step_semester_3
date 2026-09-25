package string.assignment_problems;

interface Ringable {

    String ring();
}

class AlarmClock implements Ringable {

    private String time;

    public AlarmClock(String time) {
        this.time = time;
    }

    @Override
    public String ring() {
        return "Alarm ringing for " + time;
    }
}

class Doorbell implements Ringable {

    private String location;

    public Doorbell(String location) {
        this.location = location;
    }

    @Override
    public String ring() {
        return "Doorbell ringing at " + location;
    }
}

public class MorningWakeUp {

    static String ringAll(Ringable[] devices) {

        StringBuilder result = new StringBuilder();

        for (Ringable device : devices) {
            result.append(device.ring()).append("\n");
        }

        return result.toString();
    }
}