/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThreadsMain {
    
    public static void main(String a[]){
        // Part 1 - 1
//         CountThread countThread = new CountThread(0, 5);
//         countThread.startThread();


        // Part 1 - 2
        CountThread countThreadOne = new CountThread(0, 99);
        CountThread countThreadTwo = new CountThread(99, 199);
        CountThread countThreadThree = new CountThread(200, 299);

        // Part 1 - 2
//        countThreadOne.startThread();
//        countThreadTwo.startThread();
//        countThreadThree.startThread();

        // Part 1 - 3
        countThreadOne.runThread();
        countThreadTwo.runThread();
        countThreadThree.runThread();


    }
    
}
