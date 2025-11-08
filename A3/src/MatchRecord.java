// Omar Elsayed B00993452
// Assigment 3


public class MatchRecord {
    private String roundNumber;
    private String dateTime;
    private String location;
    private String homeTeam;
    private String awayTeam;
    private String group;
    private int homeGoals;
    private int awayGoals;

    public MatchRecord(String roundNumber, String dateTime, String location, String homeTeam, String awayTeam, String group, int homeGoals , int awayGoals){
        this.roundNumber = roundNumber;
        this.dateTime = dateTime;
        this.location = location;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.group = group;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public String getRoundNumber(){
        return roundNumber;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getLocation(){
        return location;
    }

    public String getHomeTeam(){
        return homeTeam;
    }

    public String getAwayTeam(){
        return awayTeam;
    }

    public String getGroup() {
        return group;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public String toString() {
        return homeTeam + " " + homeGoals + " - " + awayGoals + " " + awayTeam  + " (" + roundNumber + ", " + location + ", " + dateTime + ")";
    }
}
