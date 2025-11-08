// Omar Elsayed B00993452
// Assigment 3

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatchStats {
    private  List<MatchRecord> matchList;


    // empty constructer to intialize an empty list
    public MatchStats() {
        matchList = new List<>();
    }


     // loads match data from a given text file.
     // reuses parsing logic from ReadWorldCupData but stores data into the match list.
    public void loadData(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {

            // Skip header line if present
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            // Read each subsequent line
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();

                // Skip blank lines
                if (line.isEmpty()) continue;

                // Split by tabs
                String[] tokens = line.split("\t");

                // Defensive check (some knockout lines may have fewer tokens)
                if (tokens.length < 8) {
                    System.out.println("Skipped malformed line: " + line);
                    continue;
                }

                // Extract tokens
                String roundNumber = tokens[1];
                String dateTime = tokens[2];
                String location = tokens[3];
                String homeTeam = tokens[4];
                String awayTeam = tokens[5];
                String group = tokens[6].isEmpty() ? "-" : tokens[6];

                // Parsing the result from "x - y" this was not same in the sample but was needed here to avoid invalid format crashes
                String[] scoreParts = tokens[7].trim().split(" - ");
                int homeGoals = 0;
                int awayGoals = 0;

                if (scoreParts.length == 2) {
                    try {
                        homeGoals = Integer.parseInt(scoreParts[0].trim());
                        awayGoals = Integer.parseInt(scoreParts[1].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Warning: Invalid score format -> " + tokens[7]);
                    }
                }

                // Create MatchRecord and add to list
                MatchRecord match = new MatchRecord(roundNumber, dateTime, location, homeTeam, awayTeam, group, homeGoals, awayGoals);
                matchList.add(match);
            }

            System.out.println(" Data has been successfully loaded from " + filename);

        } catch (FileNotFoundException e) {
            System.out.println(" Error: File not found. Please ensure the file path is correct: " + filename);
        }
    }


    // method to display all teams in a certain group entered
    public void displayTeams(String group){
        List<String> teams = new List<>();

        MatchRecord current = matchList.first(); // figure out first match

        while(current!= null) {
            if (current.getGroup().equalsIgnoreCase(group)) { // find matches that matches entered group

                if (!teams.contains(current.getHomeTeam())) { // adding home team to list if not there
                    teams.add(current.getHomeTeam());
                }
                if (!teams.contains(current.getAwayTeam())) { // adding away team to list if not there
                    teams.add(current.getAwayTeam());
                }
            }
            current = matchList.next(); // moving through our list with current as a pointer
        }

            if (teams.isEmpty()){ // no teams were found in our group
                System.out.println("No teams were found in this group");
            }else{ // if they were found print them out from list
                System.out.print("Teams in " + group + ": ");
                String team = teams.first();
                while (team!= null){
                    System.out.print(team);
                    team = teams.next(); // go to next team in list
                    if(team != null){
                        System.out.print(", "); // to only print the comma if theres a next team in list
                    }
                }
                System.out.println(); // for formatting
            }

    }


    // returns a count of how many matches entered team plays
    public int numMatches(String team){
        int count = 0 ; // to keep track of matches played
        MatchRecord current = matchList.first();

        while(current!= null){
            if (current.getHomeTeam().equalsIgnoreCase(team) || current.getAwayTeam().equalsIgnoreCase(team)) { // this is done becuase a team can play away and home in the tournment
                count++;
            }
            current = matchList.next();
        }

        return count;
    }


    // method to display team who scored the most goals in tournment
    public void highestTotalGoals(){
        if(matchList.isEmpty()){ // incase of empty files break
            System.out.println("No data is available in file");
            return;
        }

        String topTeam = "";
        int maxGoals = -1; // goals scored will always be more than - 1

        MatchRecord current = matchList.first();

        while (current != null) {

            // check home team's total goals across all the matches
            int homeTotal = 0;
            MatchRecord checker = matchList.first(); // acts as a temporary current pointer
            while (checker != null) {

                // used 2 if statments as we dont know if the team played home or away for a particular match
                // we find them in either home or away then increment home total goals counter
                if (checker.getHomeTeam().equalsIgnoreCase(current.getHomeTeam())) {
                    homeTotal = homeTotal + checker.getHomeGoals();
                }
                if (checker.getAwayTeam().equalsIgnoreCase(current.getHomeTeam())) {
                    homeTotal = homeTotal + checker.getAwayGoals();
                }
                checker = matchList.next(); // move to next item in list
            }

            if (homeTotal > maxGoals) { // updates if home team has more goals
                maxGoals = homeTotal;
                topTeam = current.getHomeTeam();
            }

            // check away team's total goals across all the matches
            int awayTotal = 0;
            checker = matchList.first();
            while (checker != null) {
                if (checker.getHomeTeam().equalsIgnoreCase(current.getAwayTeam())) {
                    awayTotal = awayTotal + checker.getHomeGoals();
                }
                if (checker.getAwayTeam().equalsIgnoreCase(current.getAwayTeam())) {
                    awayTotal = awayTotal + checker.getAwayGoals();
                }
                checker = matchList.next();
            }

            if (awayTotal > maxGoals) { // updates if away team has more goals
                maxGoals = awayTotal;
                topTeam = current.getAwayTeam();
            }

            current = matchList.next();
        }
        System.out.println("Team with highest total goals: " + topTeam + " (" + maxGoals + ")");
    }


    // method that displays lowest scoring team
    public void lowestTotalGoals() {
        List<String> teams = new List<>(); // list to store all unique teams
        MatchRecord record = matchList.first(); // used to traverse through our matchlist list from class

        while (record != null) {
            String home = record.getHomeTeam();
            String away = record.getAwayTeam();

            // add teams if they arent already in our list
            if (!teams.contains(home)) {
                teams.add(home);
            }
            if (!teams.contains(away)) {
                teams.add(away);
            }

            record = matchList.next(); // go to next item
        }

        String lowestTeam = "";
        int lowestGoals = 1000; // no team can reach this in one tournament


        // calculating  the total number of goals scored by each team
        String team = teams.first();
        while (team != null) {
            int goals = 0;
            MatchRecord current = matchList.first();

            while (current != null) {   // adding goals depending on whether the team played as home or away
                if (current.getHomeTeam().equalsIgnoreCase(team)) {
                    goals = goals + current.getHomeGoals();
                } else if (current.getAwayTeam().equalsIgnoreCase(team)) {
                    goals = goals + current.getAwayGoals();
                }
                current = matchList.next();
            }

            if (goals < lowestGoals) { //  if its less than lower current goals than this is the team with the lowest goals
                lowestGoals = goals;
                lowestTeam = team;
            }

            team = teams.next(); // move to next time in list
        }

        System.out.println("Lowest scoring team: " + lowestTeam + " (" + lowestGoals + " goals)");
    }


    // method to displayed how many matches played at entered stadium
    public void matchesPlayedAt(String stadiumName) {
        if (matchList.isEmpty()) {
            System.out.println("No data is available in file");
            return;
        }

        MatchRecord current = matchList.first();

        System.out.println("Matches played at " + stadiumName + ":");

        while (current != null) {
            if (current.getLocation().equalsIgnoreCase(stadiumName)) {
                System.out.println(current); // calls toString method from MatchRecord class
            }
            current = matchList.next();
        }
    }


    // method to displayed matches played on entered date
    public void matchesPlayedOn(String date) {
        if (matchList.isEmpty()) {
            System.out.println("No data is available in file");
            return;
        }

        MatchRecord current = matchList.first();

        System.out.println("Matches played on " + date + ":");

        while(current != null){
            String dateTime = current.getDateTime(); // to extract full date and time
            String matchDate = dateTime.substring(0,dateTime.indexOf(" ")); // extract ony the date as multiple matches can be played on the same day but different time

            if (matchDate.equals(date)){
                System.out.println(current);
            }

            current = matchList.next();
        }
    }


    // method to display matches played and results on entered team
    public void matchesPlayedBy(String teamName) {
        if (matchList.isEmpty()) {
            System.out.println("No data is available in file");
            return;
        }

        System.out.println("Matches played by " + teamName + ":");

        MatchRecord current = matchList.first();

        while (current != null) {

            String home = current.getHomeTeam();
            String away = current.getAwayTeam();

            // check if team played home or away
            if (home.equalsIgnoreCase(teamName)) {
                System.out.println(home + " vs. " + away + " " + current.getHomeGoals() + "–" + current.getAwayGoals());
            }
            else if (away.equalsIgnoreCase(teamName)) {
                System.out.println(home + " vs. " + away + " " + current.getHomeGoals() + "–" + current.getAwayGoals());
            }

            current = matchList.next();
        }
    }


    // Displays teams ranked by total number of wins (most to least)
    public void displayTeamsTopDown() {
        if (matchList.isEmpty()) {
            System.out.println("No data is available in file");
            return;
        }

        List<String> teams = new List<>(); // create list again for all unique teams
        MatchRecord record = matchList.first();

        while (record != null) {
            // only add if they are not in list
            if (!teams.contains(record.getHomeTeam())) {
                teams.add(record.getHomeTeam());
            }
            if (!teams.contains(record.getAwayTeam())){
                teams.add(record.getAwayTeam());
            }
            record = matchList.next(); // to move to next item
        }

        List<String> printed = new List<>(); // to keep track of the teams we printed already

        System.out.println("Teams ranked by performance (most wins to least wins):");

        //  to find and print teams in order of total wins
        for (int rank = 1; rank <= teams.size(); rank++) {
            String bestTeam = "";
            int bestWins = -1;

            // go through all teams and find the one with the highest number of wins not yet printed
            String team = teams.first();
            while (team != null) {
                if (!printed.contains(team)) {
                    int wins = 0;
                    MatchRecord current = matchList.first();

                    // Count number of wins for this team
                    while (current != null) {
                        String home = current.getHomeTeam();
                        String away = current.getAwayTeam();
                        int homeGoals = current.getHomeGoals();
                        int awayGoals = current.getAwayGoals();

                        if (home.equalsIgnoreCase(team) && homeGoals > awayGoals){
                            wins++;
                        }
                        else if (away.equalsIgnoreCase(team) && awayGoals > homeGoals) {
                            wins++;
                        }

                        current = matchList.next();
                    }

                    // to check which team has highest wins so far
                    if (wins > bestWins) {
                        bestWins = wins;
                        bestTeam = team;
                    }
                }
                team = teams.next(); // move to next team
            }

            // print the best teams
            if (!bestTeam.isEmpty()) {
                System.out.println(rank + ". " + bestTeam);
                printed.add(bestTeam);
            }
        }
    }
}
