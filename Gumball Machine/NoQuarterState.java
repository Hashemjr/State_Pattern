// NoQuarterState class
class NoQuarterState implements State {
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public String insertQuarter() {
        gumballMachine.setState(gumballMachine.getHasQuarterState());
        return "You inserted a quarter\n";
    }

    public String ejectQuarter() {
        return "You haven't inserted a quarter\n";
    }

    public String turnCrank() {
        return "You turned, but there's no quarter\n";
    }

    public String dispense() {
        return "You need to pay first\n";
    }
}
