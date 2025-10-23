// Omar Elsayed B00993452 lab4// Omar Elsayed B00993452 lab4

public class Job {
    private String owner;
    private int jobId;

    public Job(String o, int j){
        this.owner = o;
        this.jobId = j;
    }

    public String getOwner(){
        return  owner;
    }

    public int getJobId(){
        return jobId;
    }

    public String toString(){
        return  owner + ":" + jobId;
    }
}
