// HasQuarterState class
class HasQuarterState implements State {
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public String insertQuarter() {
        return "You can't insert another quarter\n";
    }

    public String ejectQuarter() {
        gumballMachine.setState(gumballMachine.getNoQuarterState());
        return "Quarter returned\n";
    }

    public String turnCrank() {
        gumballMachine.setState(gumballMachine.getSoldState());
        return "You turned the crank...\n";
    }

    public String dispense() {
        return "No gumball dispensed\n";
    }
}