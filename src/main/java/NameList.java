import java.util.ArrayList;
import java.util.Arrays;

public class NameList {
    private NameList() {
        firstNames.addAll(Arrays.asList("Anthony", "Arthur", "Aaron", "Alfred", "Alice", "Alina","Adam"));
        firstNames.addAll(Arrays.asList("Benjamin", "Barry", "Becca"));
        firstNames.addAll(Arrays.asList("Carrie", "Caroline", "Catherine", "Callie", "Caleb", "Cory"));
        firstNames.addAll(Arrays.asList("Donald", "Dave", "Dylan", "Devin", "Drew", "Daniel", "Douglas"));
        firstNames.addAll(Arrays.asList("Esmerelda", "Ezra", "Ezekiel", "Eve"));
        firstNames.addAll(Arrays.asList("Fred"));
        firstNames.addAll(Arrays.asList("George", "Gregory"));
        firstNames.addAll(Arrays.asList("Harry", "Hudson"));
        firstNames.addAll(Arrays.asList("Isabella"));
        firstNames.addAll(Arrays.asList("John", "Joe", "James"));
        firstNames.addAll(Arrays.asList("Kabsal"));
        firstNames.addAll(Arrays.asList("Louis", "Lilly", "Laura"));
        firstNames.addAll(Arrays.asList("Max", "Maeve", "Maurice"));
        firstNames.addAll(Arrays.asList("Ned"));
        firstNames.addAll(Arrays.asList("Oprah"));
        firstNames.addAll(Arrays.asList("Peri"));
        firstNames.addAll(Arrays.asList("Quasar"));
        firstNames.addAll(Arrays.asList("Ryan", "Rod"));
        firstNames.addAll(Arrays.asList("Sam", "Sylvia", "Samantha"));
        firstNames.addAll(Arrays.asList("Terry"));
        firstNames.addAll(Arrays.asList("Ulfred"));
        firstNames.addAll(Arrays.asList("Veronica"));
        firstNames.addAll(Arrays.asList("Wyndle"));
        firstNames.addAll(Arrays.asList("Xavier"));
        firstNames.addAll(Arrays.asList("Yondu"));
        firstNames.addAll(Arrays.asList("Zev"));
        /*
         * In the constructor, initialize the first and last name lists.
         */
        lastNames.addAll(Arrays.asList("Aaronson", "Amato", "Arteaga"));
        lastNames.addAll(Arrays.asList("Berkowitz", "Benito", "Blickely", "Blumenthal"));
        lastNames.addAll(Arrays.asList("Craven", "Cain", "Clover", "Corbett", "Cunningham"));
        lastNames.addAll(Arrays.asList("Darnell", "Darmond", "Deane", "DeLuca", "Dente", "Dhruv", "Doran"));
        lastNames.addAll(Arrays.asList("Ehrlacher", "Elieson", "Evans"));
        lastNames.addAll(Arrays.asList("Feller", "Fishburn", "Freeman"));
        lastNames.addAll(Arrays.asList("Gauck", "Garcia", "Garman", "Gordon", "Greenwald"));
        lastNames.addAll(Arrays.asList("Hamilton", "Harris", "Heit", "Heller", "Hughes", "Hurtig"));
        lastNames.addAll(Arrays.asList("Isler"));
        lastNames.addAll(Arrays.asList("Jacobs", "Johnson"));
        lastNames.addAll(Arrays.asList("Kane", "Keefer", "Knight", "Kummer"));
        lastNames.addAll(Arrays.asList("Leach", "Lebson", "Lew", "Linz", "Lopez"));
        lastNames.addAll(Arrays.asList("Macek", "Major", "McManus", "McDonald", "Miller"));
        lastNames.addAll(Arrays.asList("Newman", "Navarro", "Nelson"));
        lastNames.addAll(Arrays.asList("Otto"));
        lastNames.addAll(Arrays.asList("Potter", "Patterson", "Peters"));
        lastNames.addAll(Arrays.asList("Quasar"));
        lastNames.addAll(Arrays.asList("Richardson", "Rifkin", "Rollfinke", "Rudow"));
        lastNames.addAll(Arrays.asList("Smith", "Sachs", "Schneider", "Seidenman"));
        lastNames.addAll(Arrays.asList("Thompson"));
        lastNames.addAll(Arrays.asList("Underwood"));
        lastNames.addAll(Arrays.asList("Vernick", "Varley", "Van Der Velpen"));
        lastNames.addAll(Arrays.asList("Woodson", "Walsh", "Watson", "Weiss", "Weinstein", "Wolf"));
        lastNames.addAll(Arrays.asList("Xavierson"));
        lastNames.addAll(Arrays.asList("Yrians"));
        lastNames.addAll(Arrays.asList("Zlamal"));
    }
    private ArrayList<String> firstNames = new ArrayList<String>();
    private ArrayList<String> lastNames = new ArrayList<String>();
    private static NameList nameList = null;

    /**
     * Gets a random first name from the list.
     * @return A String that is a random first name.
     */
    public String getFirstName() {
        return firstNames.get((int)Math.round(Math.random() * firstNames.size()));
    }

    /**
     * Gets a random last name from the list.
     * @return A String that is a random last name.
     */
    public String getLastName() {
        return lastNames.get((int)Math.round(Math.random() * lastNames.size()));
    }

    /**
     * Gets the NameList instance if it exists, otherwise make a new one.
     * @return The one and only NameList instance.
     */
    public static NameList getInstance() {
        nameList = nameList == null ? new NameList() : nameList;
        return nameList;
    }
}