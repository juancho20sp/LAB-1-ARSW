package main.java.edu.eci.arsw.blacklistvalidator;

import main.java.edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class MyValidator implements Runnable {
    int[] startValues;
    int[] endValues;
    int totalServers;
    int totalThreads;

    MyValidator(int totalThreads) {
        this.totalThreads = totalThreads;

        HostBlacklistsDataSourceFacade skds = HostBlacklistsDataSourceFacade.getInstance();
        this.totalServers = skds.getRegisteredServersCount();

        System.out.println("Total servers" + this.totalServers);
    }

    @Override
    public void run() {
        /*try {
            for(int i = this.start; i <= this.end; i++){
                System.out.println(i);
                Thread.sleep(100);
            }
        } catch(InterruptedException e) {
            System.out.println("Error!");
        }*/

        System.out.println("Thread end");
    }

    private void createDivisions() {

    }


    public static void main(String[] args) {

    }

}
