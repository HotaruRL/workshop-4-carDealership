import java.util.ArrayList;

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

