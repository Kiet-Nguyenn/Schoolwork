public class Car
{
    // Constants
    public final double capacity = 22;   // number of gallons the gas
    // tank can hold when full
    // Instance Variables
    double startMiles;
    double endMiles;
    double gallons;

    // Constructors
    public Car(double startMiles, double endMiles, double gallons){
        this.startMiles = startMiles;
        this.endMiles = endMiles;
        this.gallons = gallons;
    }

    // Methods

    /** precondition:  gallons > 0
     *  postcondition: calculates and returns the cars MPG (miles per gallon)
     *     for the current odometer readings.
     *  @return the car's MPG
     */
    public double calculateMPG()
    {
        if(gallons > 0){
            double mpg = (endMiles - startMiles) / gallons;
            return mpg;
        } else{
            return 0.0;
        }
    }

    /** precondition:  none
     *  postcondition: calculates and returns the number of miles the car
     *     can travel before its gas tank is empty.
     *  @return number of miles car can travel before tank is empty
     */
    public double milesToEmpty()
    {
        double distance = calculateMPG() * (capacity - gallons);
        return distance;
    }
}