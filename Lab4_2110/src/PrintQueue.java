// Omar Elsayed B00993452 lab4

public class PrintQueue {

    private GenericQueue<Job> q;

    public PrintQueue(){
        q = new GenericQueue<>();
    }

    public void lpr (String owner, int jobId){
        Job newJob = new Job(owner, jobId);
        q.enqueue(newJob);
        System.out.println("Added job " + jobId + " by " + owner);
    }

    public void lpq(){
        System.out.print("Queue: ");
        int size = q.size();
        for(int i = 0; i < size ; i++){
            Job temp = q.dequeue(); // using roation method as in previous tasks
            System.out.print( temp + " ");
            q.enqueue(temp);
        }
        System.out.println(); // for formatting
    }

    public void lprm(int jobId){
        if(q.isEmpty() == true){
            System.out.println("Queue empty; nothing removed");
            return;
        }

        Job frontq = q.peek(); // only remove if front of queue so we used peek to get front element
        if (frontq.getJobId() == jobId){
            q.dequeue();
            System.out.println("Removed active job " + jobId);
        }else {
            System.out.println("Active job id does not match " + jobId + "; nothing removed");
        }
    }

    public void lprmAll(String owner) {
        int jobCount = 0;
        int size = q.size();
        for (int i = 0; i < size; i++) {
            Job temp = q.dequeue();
            if (temp.getOwner().equals(owner) == false) {
                q.enqueue(temp);
            } else {
                jobCount++;
            }
        }
        System.out.println("Removed " + jobCount + " job(s) owned by " + owner);
    }

}
