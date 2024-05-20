package gradingsystem;

import gradingsystem.Entities.*;
import gradingsystem.GUI.GUI;
import gradingsystem.GUI.NewDirector;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class GradingSystem {
    public static void main(String[] args) {
        
        DBConnector db = new DBConnector();
        db.getData();
        
        GUI gui = new GUI();
    }
}
