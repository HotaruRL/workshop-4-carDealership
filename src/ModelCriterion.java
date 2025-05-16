class ModelCriterion extends SearchCriterion {
    private String desiredModel;

    ModelCriterion(String desiredModel) {
        this.desiredModel = desiredModel;
    }

    //    @Override
    public boolean matches(Vehicle vehicle) {
        if (desiredModel == null) {
            return true; // if no make specified, it's a match
        }
        return desiredModel.equalsIgnoreCase(vehicle.getModel());
    }
}
