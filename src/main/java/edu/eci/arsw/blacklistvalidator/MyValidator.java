package main.java.edu.eci.arsw.blacklistvalidator;

import main.java.edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.LinkedList;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyValidator implements Runnable {
    int start;
    int end;
    int maliciousOccurrences;
    int checkedListsCount;
    int alarmCount;
    String ipaddress;
    Thread myThread;
    HostBlacklistsDataSourceFacade skds;
    LinkedList<Integer> blackListOcurrences;

    MyValidator(int start, int end, HostBlacklistsDataSourceFacade skds, int alarmCount, String ipaddress) {
        this.start = start;
        this.end = end;
        this.skds = skds;
        this.alarmCount = alarmCount;
        this.ipaddress = ipaddress;

        this.maliciousOccurrences = 0;
        this.checkedListsCount = 0;

        this.blackListOcurrences = new LinkedList<>();
        this.myThread = new Thread(this, "Holi crayoli");
    }

    @Override
    public void run() {
        //try {
            for (int i = this.start; this.maliciousOccurrences < this.alarmCount && i <= this.end; i++){
                this.checkedListsCount += 1;

                if (skds.isInBlackListServer(i, ipaddress)){

                    this.blackListOcurrences.add(i);

                    this.maliciousOccurrences += 1;
                }
            }

            if (this.maliciousOccurrences >= this.alarmCount){
                skds.reportAsNotTrustworthy(ipaddress);
            } else{
                skds.reportAsTrustworthy(ipaddress);
            }

            System.out.println("Blacklist: " + this.blackListOcurrences);

            LOG.log(Level.INFO, "Checked Black Lists:{0} of {1}", new Object[]{checkedListsCount, skds.getRegisteredServersCount()});

       // }
        /*catch(InterruptedException e) {
            System.out.println("Error!");
        }*/

        System.out.println("Thread end");
    }

    public int getMaliciousOccurrences() {
        return this.maliciousOccurrences;
    }

    public void startThread(){
        this.myThread.start();
    }

    public void runThread(){
        this.myThread.run();
    }

    private static final Logger LOG = Logger.getLogger(HostBlackListsValidator.class.getName());
}
