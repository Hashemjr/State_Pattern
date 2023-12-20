// SoldOutState class
class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public String insertQuarter() {
        return "Sorry, gumballs are sold out\n";
    }

    public String ejectQuarter() {
        return "You haven't inserted a quarter\n";
    }

    public String turnCrank() {
        return "Sorry, gumballs are sold out\n";
    }

    public String dispense() {
        return "Sorry, gumballs are sold out\n";
    }
}