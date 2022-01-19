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
public class CountThread implements Runnable {
    Thread myThread;
    int start;
    int end;

    @Override
    public void run() {
        try {
            for(int i = this.start; i <= this.end; i++){
                System.out.println(i);
                Thread.sleep(100);
            }
        } catch(InterruptedException e) {
            System.out.println("Error!");
        }

        System.out.println("Thread end");
    }

    CountThread(int start, int end) {
        this.start = start;
        this.end = end;

        this.myThread = new Thread(this, "Holi crayoli");
        System.out.println("Thread created: " + myThread);

    }

    public void startThread(){
        this.myThread.start();
    }

    public void runThread(){
        this.myThread.run();
    }
}
