/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecontroller.Entity;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author EVAN
 */
public class Countdown {
     public static void main(final String args[]) {
        if (args.length != 1) {
            System.err.println("Usage: java Countdown <time in secs>");
            System.exit(1);
        }
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = Integer.parseInt(args[0]);
            public void run() {
                System.out.println(i--);
                if (i< 0)
                    timer.cancel();
            }
        }, 0, 1000);
    }
}
