package string.class_problems;

abstract class KitchenTool {

    private int speedLevel;

    public abstract String prepare();

    public int getSpeedLevel() {
        return speedLevel;
    }

    public void setSpeedLevel(int speedLevel) {
        if (speedLevel >= 1 && speedLevel <= 5)
            this.speedLevel = speedLevel;
    }
}

interface Washable {

    String clean();
}

class Blender extends KitchenTool implements Washable {

    @Override
    public String prepare() {
        return "Blender is preparing food";
    }

    @Override
    public String clean() {
        return "Blender is being cleaned";
    }
}

public class SmartKitchen {
}