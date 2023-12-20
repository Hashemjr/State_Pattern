// SoldState class
class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public String insertQuarter() {
        return "Please wait, we're already giving you a gumball\n";
    }

    public String ejectQuarter() {
        return "Sorry, you already turned the crank\n";
    }

    public String turnCrank() {
        return "Turning twice doesn't give you another gumball!\n";
    }

    public String dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
        return "A gumball comes rolling out the slot...\n";
    }
}