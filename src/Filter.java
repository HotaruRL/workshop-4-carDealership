import java.util.ArrayList;

/*
- Each criterion is a class by itself
- We can add as many criteria as we want
- We then create an ArrayList of activeCriteria and then add the criteria we want into it
- The Filter class using its filter() will go through each item in the ArrayList and
for each item, it will go through the ArrayList of activeCriteria, and check if it matches any,
(if there are multiple active criteria, it must match ALL to be added to the results list - AND operator)
then add such item, if applicable, to the results ArrayList, which is then returned as an output

- To re-use this template, replace the Vehicle vehicle with whatever applicable
 */
interface SearchCriterion{
    boolean matches(Vehicle vehicle);
}

// main search logic
public class Filter {
    public ArrayList<Vehicle> filter(ArrayList<Vehicle> listOfAll, ArrayList<SearchCriterion> activeCriteria){
        ArrayList<Vehicle> results = new ArrayList<>();
        if (activeCriteria == null || activeCriteria.isEmpty()){
            return listOfAll; // return all if there is no active criteria
        }
        for (Vehicle v : listOfAll){
            boolean matchesAll = true;
            for (SearchCriterion criterion : activeCriteria){
                if (!criterion.matches(v)){
                    matchesAll = false;
                    break;
                }
            }
            if (matchesAll){
            results.add(v);
            }
        }
        return results;
    }
}

// possible criteria
class MakeCriterion implements SearchCriterion{
    private String desiredMake;
    MakeCriterion(String desiredMake){
        this.desiredMake = desiredMake;
    }
    @Override
    public boolean matches(Vehicle vehicle) {
        if (desiredMake == null) {
            return true; // if no make specified, it's a match
        }
        return desiredMake.equalsIgnoreCase(vehicle.getMake());
    }
}
class ModelCriterion implements SearchCriterion{
    private String desiredModel;
    ModelCriterion(String desiredModel){
        this.desiredModel = desiredModel;
    }
    @Override
    public boolean matches(Vehicle vehicle) {
        if (desiredModel == null) {
            return true; // if no make specified, it's a match
        }
        return desiredModel.equalsIgnoreCase(vehicle.getModel());
    }
}