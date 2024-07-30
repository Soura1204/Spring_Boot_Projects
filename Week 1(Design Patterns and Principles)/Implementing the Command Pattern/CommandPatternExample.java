public class CommandPatternExample {

    
    interface Command {
        void execute();
    }

    
    static class LightOnCommand implements Command {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        
        public void execute() {
            light.turnOn();
        }
    }

    static class LightOffCommand implements Command {
        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        
        public void execute() {
            light.turnOff();
        }
    }

    
    static class Light {
        public void turnOn() {
            System.out.println("The light is now ON.");
        }

        public void turnOff() {
            System.out.println("The light is now OFF.");
        }
    }

    
    static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }
    }

    
    public static void main(String[] args) {
        
        Light light = new Light();

        
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        
        RemoteControl remoteControl = new RemoteControl();

        
        remoteControl.setCommand(lightOn);
        System.out.println("Pressing the button to turn the light ON:");
        remoteControl.pressButton();

        
        remoteControl.setCommand(lightOff);
        System.out.println("Pressing the button to turn the light OFF:");
        remoteControl.pressButton();
    }
}
