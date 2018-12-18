import java.util.Vector;

class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {

        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental each : _rentals) {

            //show figures for this rental
            result.append("\t").append(each.getTitle());
            result.append("\t").append(String.valueOf(each.getCharge()));
            result.append("\n");

        }

        //add footer lines
        result.append("Amount owed is ").append(String.valueOf(getTotalCharge()));
        result.append("\n");
        result.append("You earned ").append(String.valueOf(getTotalFrenquentRenterPoints()));
        result.append(" frequent renter points");
        return result.toString();
    }
    public double getTotalCharge() {
        double result = 0;
        for (Rental each : _rentals) {
            result += each.getCharge();
        }
        return result;
    }
    public int getTotalFrenquentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : _rentals) {
            frequentRenterPoints += each.getFrequentRenterPoints();
        }

        return frequentRenterPoints;
    }

}
