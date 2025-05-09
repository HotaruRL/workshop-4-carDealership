public class Menu {
    // fields
    String pattern;
    int width;
    int paddingLength;
    String SPACE = " ";
    // constructor
    Menu(String pattern, int width, int paddingLength){
        this.pattern = pattern;
        this.width = width;
        this.paddingLength = paddingLength;
    }
    // methods
    public String createPattern(String s, int times){
        StringBuilder output = new StringBuilder();
        while (output.length() < times){
            output.append(s);
        }
        return output.toString();
    }
    public int alignCenter(){
        return (int) Math.floor(this.width / 2.0);
    }
    public void menuHeader(String menuName){
        int menuNameLength = menuName.length();
        String padding = createPattern(pattern, paddingLength);
        String spacing = createPattern(SPACE, alignCenter() - (menuNameLength / 2) - paddingLength);
        int middleRowLength = (paddingLength * 2) + (spacing.length() * 2) + menuNameLength;
        // adjust to make sure the top row and bottom always have the same length as middle row
        // no matter the menuName's length is odd or even
        if (width < middleRowLength){
            width = middleRowLength;
        }
        System.out.printf("%s\n", createPattern(pattern, width));
        System.out.printf("%s%s%s%s%s\n",
                padding,
                spacing,
                menuName,
                spacing,
                padding
        );
        System.out.printf("%s\n", createPattern(pattern, width));
    }
    public void printMainMenu(){
        System.out.print("""
                        [1] - Find vehicles within a price range
                        [2] - Find vehicles by make / model
                        [3] - Find vehicles by year range
                        [4] - Find vehicles by color
                        [5] - Find vehicles by mileage range
                        [6] - Find vehicles by type (car, truck, SUV, van)
                        [7] - List ALL vehicles
                        [8] - Add a vehicle
                        [9] - Remove a vehicle
                        [0] - Quit
                
                Please enter the appropriate number to execute the task: 
                """);
    }
}
