package string.class_problems;

abstract class Instrument {

    public Instrument() {
    }

    public abstract String play();
}

class StringInstrument extends Instrument {

    public StringInstrument() {
        super();
    }

    @Override
    public String play() {
        return "String instrument is playing";
    }
}

class Violin extends StringInstrument {

    public Violin() {
        super();
    }

    @Override
    public String play() {
        return super.play() + " | Violin plays a melody";
    }
}

public class OrchestraWarmUp {
}