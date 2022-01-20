/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.edu.eci.arsw.blacklistvalidator;

import main.java.edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
import main.java.edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class HostBlackListsValidator {
    int[] startValues;
    int[] endValues;
    HostBlacklistsDataSourceFacade skds;

    private static final int BLACK_LIST_ALARM_COUNT=5;
    
    /**
     * Check the given host's IP address in all the available black lists,
     * and report it as NOT Trustworthy when such IP was reported in at least
     * BLACK_LIST_ALARM_COUNT lists, or as Trustworthy in any other case.
     * The search is not exhaustive: When the number of occurrences is equal to
     * BLACK_LIST_ALARM_COUNT, the search is finished, the host reported as
     * NOT Trustworthy, and the list of the five blacklists returned.
     * @param ipaddress suspicious host's IP address.
     * @return  Blacklists numbers where the given host's IP address was found.
     */
    public List<Integer> checkHost(String ipaddress, int totalThreads){
        
        LinkedList<Integer> blackListOcurrences=new LinkedList<>();
        
        int ocurrencesCount=0;
        
        this.skds=HostBlacklistsDataSourceFacade.getInstance();
        
        int checkedListsCount=0;

        // Calculate the intervals
        this.calculateDivisions(totalThreads);

        return null;
        
        /*for (int i=0;i<skds.getRegisteredServersCount() && ocurrencesCount<BLACK_LIST_ALARM_COUNT;i++){
            checkedListsCount++;
            
            if (skds.isInBlackListServer(i, ipaddress)){
                
                blackListOcurrences.add(i);
                
                ocurrencesCount++;
            }
        }
        
        if (ocurrencesCount>=BLACK_LIST_ALARM_COUNT){
            skds.reportAsNotTrustworthy(ipaddress);
        }
        else{
            skds.reportAsTrustworthy(ipaddress);
        }                
        
        LOG.log(Level.INFO, "Checked Black Lists:{0} of {1}", new Object[]{checkedListsCount, skds.getRegisteredServersCount()});
        
        return blackListOcurrences; */
    }

    private void calculateDivisions(int totalThreads) {
        this.startValues = new int[totalThreads];
        this.endValues = new int[totalThreads];

        for(int i = 0; i < totalThreads; i++){
            startValues[i] = i * (this.skds.getRegisteredServersCount() / totalThreads);
            endValues[i] = startValues[i] + (this.skds.getRegisteredServersCount() / totalThreads);

            // TODO
            if (i != 0) {
                startValues[i] += 1;
            }

            if ((totalThreads % 2) != 0 && i == totalThreads - 1) {
                endValues[i] += this.skds.getRegisteredServersCount() % totalThreads;
            }
        }

        System.out.println("Start values:");
        System.out.println(Arrays.toString(startValues));
        System.out.println("End values:");
        System.out.println(Arrays.toString(endValues));

        System.out.println("Total servers: " + this.skds.getRegisteredServersCount());
    }
    
    
    private static final Logger LOG = Logger.getLogger(HostBlackListsValidator.class.getName());
    
    
    
}
