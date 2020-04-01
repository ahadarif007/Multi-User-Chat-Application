/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatapplication;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author ADG
 */
public class subClass implements Runnable{

    
    
    
    @Override
    public void run(){
        System.out.println("javachatapplication.subClass.run()");
    
            client_frame serverC = new client_frame();
            serverC.mainMethod();
          //  serverC.whileProcessingtheApplication1();
          //  serverC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    
}

