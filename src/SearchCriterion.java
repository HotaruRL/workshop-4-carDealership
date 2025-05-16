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
public abstract class SearchCriterion{
    abstract boolean matches(Vehicle vehicle);
}
