package consoleapp.InterviewWaitingPanel;

public class Interviewee {
    private final String name;
    private final String phoneNo;

    public Interviewee(String name, String phoneNo){
        this.name = name;
        this.phoneNo = phoneNo;
    }

    String getIntervieweeName(){
        return name;
    }

    String getIntervieweePhoneNo(){
        return phoneNo;
    }
}
