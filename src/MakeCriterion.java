// possible criteria
class MakeCriterion extends SearchCriterion {
    private String desiredMake;

    MakeCriterion(String desiredMake) {
        this.desiredMake = desiredMake;
    }

    //    @Override
    public boolean matches(Vehicle vehicle) {
        if (desiredMake == null) {
            return true; // if no make specified, it's a match
        }
        return desiredMake.equalsIgnoreCase(vehicle.getMake());
    }
}
