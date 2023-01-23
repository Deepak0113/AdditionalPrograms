package consoleapp.InterviewWaitingPanel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WaitingPanel {
    private int waitingPanelSize;
    private Queue<Interviewee> queue;

    WaitingPanel(int waitingPanelSize){
        this.waitingPanelSize = waitingPanelSize;
         queue = new LinkedList<>();
    }

    void addInterviewee(String name, String phoneNo){
         queue.add(new Interviewee(name, phoneNo));
    }

    void callNext(){
         queue.remove();
    }
}
