import java.util.*;

// Abstract class for devices
abstract class SmartDevice {
    protected String id;
    protected String type;
    protected boolean isOn;

    public SmartDevice(String id, String type) {
        this.id = id;
        this.type = type;
        this.isOn = false;
    }

    public void turnOn() {
        this.isOn = true;
        System.out.println(type + " " + id + " is turned on.");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println(type + " " + id + " is turned off.");
    }

    public String getStatus() {
        return type + " " + id + " is " + (isOn ? "on" : "off");
    }
}

// Concrete classes for each device type
class Light extends SmartDevice {
    public Light(String id) {
        super(id, "Light");
    }
}

class Thermostat extends SmartDevice {
    private int temperature;

    public Thermostat(String id) {
        super(id, "Thermostat");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat " + id + " temperature set to " + temperature);
    }

    @Override
    public String getStatus() {
        return "Thermostat " + id + " is " + (isOn ? "on" : "off") + " at " + temperature + " degrees";
    }
}

class DoorLock extends SmartDevice {
    public DoorLock(String id) {
        super(id, "DoorLock");
    }

    @Override
    public void turnOn() {
        this.isOn = true;
        System.out.println("DoorLock " + id + " is locked.");
    }

    @Override
    public void turnOff() {
        this.isOn = false;
        System.out.println("DoorLock " + id + " is unlocked.");
    }

    @Override
    public String getStatus() {
        return "DoorLock " + id + " is " + (isOn ? "locked" : "unlocked");
    }
}

// Main class to manage the smart home system
class SmartHomeSystem {
    private final List<SmartDevice> devices = new ArrayList<>();

    public void addDevice(SmartDevice device) {
        devices.add(device);
        System.out.println(device.type + " " + device.id + " added to the system.");
    }

    public void turnDeviceOn(String id) {
        for (SmartDevice device : devices) {
            if (device.id.equals(id)) {
                device.turnOn();
                break;
            }
        }
    }

    public void turnDeviceOff(String id) {
        for (SmartDevice device : devices) {
            if (device.id.equals(id)) {
                device.turnOff();
                break;
            }
        }
    }

    public void viewStatus() {
        for (SmartDevice device : devices) {
            System.out.println(device.getStatus());
        }
    }
}

// Main class to run the simulation
public class SmartHomeSimulation {
    public static void main(String[] args) {
        SmartHomeSystem smartHomeSystem = new SmartHomeSystem();

        // Create devices
        SmartDevice light1 = new Light("Light1");
        SmartDevice thermostat1 = new Thermostat("Thermostat1");
        SmartDevice doorLock1 = new DoorLock("DoorLock1");

        // Add devices to the system
        smartHomeSystem.addDevice(light1);
        smartHomeSystem.addDevice(thermostat1);
        smartHomeSystem.addDevice(doorLock1);

        // Turn devices on/off
        smartHomeSystem.turnDeviceOn("Light1");
        smartHomeSystem.turnDeviceOff("Light1");

        // Set temperature for the thermostat
        ((Thermostat) thermostat1).setTemperature(22);

        // View status
        smartHomeSystem.viewStatus();
    }
}
    
    
    