// Omar Elsayed B00993452
// Assigment 3


//this loads match data from file, then calls MatchStats methods to display required outputs.
public class FIFAStatsDemo {
    public static void main(String[] args) {

        // creating the MatchStats object for use
        MatchStats stats = new MatchStats();

       // loading data from file
        String filename = "UNI second year\\CSCI2110\\A3\\src\\fifa-world-cup-2022-UTC.txt"; // alter the paths this was my paths to be able to load my file
        stats.loadData(filename);

        System.out.println("\n--------------------------------------------------");
        System.out.println("a) Display all teams in a given group:");
        stats.displayTeams("Group A");

        System.out.println("\n--------------------------------------------------");
        System.out.println("b) Number of matches played by a team:");
        System.out.println("Matches played by France: " + stats.numMatches("France"));

        System.out.println("\n--------------------------------------------------");
        System.out.println("c) Team with the highest total goals:");
        stats.highestTotalGoals();

        System.out.println("\n--------------------------------------------------");
        System.out.println("d) Team with the lowest total goals:");
        stats.lowestTotalGoals();

        System.out.println("\n--------------------------------------------------");
        System.out.println("e) All matches played at a given stadium:");
        stats.matchesPlayedAt("Lusail Stadium");

        System.out.println("\n--------------------------------------------------");
        System.out.println("f) All matches played on a given date:");
        stats.matchesPlayedOn("18/12/2022"); // finals day

        System.out.println("\n--------------------------------------------------");
        System.out.println("g) All matches played by a given team:");
        stats.matchesPlayedBy("Morocco");

        System.out.println("\n--------------------------------------------------");
        System.out.println("h) Teams ranked by performance:");
        stats.displayTeamsTopDown();
    }
}
