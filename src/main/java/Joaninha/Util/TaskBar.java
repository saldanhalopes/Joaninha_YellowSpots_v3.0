/*
 * Copyright (C) 2018 rafael.lopes
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package joaninha.util;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael.lopes
 */
public class TaskBar {

    private static SystemTray Tray = SystemTray.getSystemTray();
    private static TrayIcon TrayIconBar;

//variables
    private static String IconMain;
    private static JFrame frame;
    private static MouseListener mlOpcoes;
    private static String NameTask;

//variables the alteration image
    private static boolean AlterCountTray = false;

    /**
     *
     * @param icon
     * @param frame
     * @param nameTask
     */
    public TaskBar(String icon, JFrame frame, String nameTask) {
        this.IconMain = icon;
        this.frame = frame;
        this.NameTask = nameTask;
    }

    public void instanceTask() {

        //alter image and instance task
        alterImageTray(IconMain);

    //add events mouse
        //initEventsMouse();
        //add icon in SystemTray
        try {
            Tray.add(TrayIconBar);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        AlterCountTray = true;

    }

    /**
     *
     * @param image
     */
    public void alterImageTray(String image) {
        Image imageIcon = new ImageIcon(
                (this.getClass()
                .getClassLoader()
                .getResource(image + ".png")))//image get param
                .getImage();

        //if not exist instance create new
        if (this.AlterCountTray == false) {
            TrayIconBar = new TrayIcon(imageIcon, NameTask, initPopUpMenu());
        } else {
            TrayIconBar.setImage(imageIcon);
        }

        //image auto resize
        TrayIconBar.setImageAutoSize(true);
    }

    /**
     *
     * @param imageOne
     * @param imageTwo
     * @param time
     */
//used with timerbean
    public void useSequenceImage(String imageOne, String imageTwo, int time) {
        try {

            alterImageTray(imageOne); //image footprint parameter changes

            Thread.sleep(time); //time for change

            alterImageTray(imageTwo); //image footprint parameter changes

        } catch (InterruptedException ex) {
            Logger.getLogger(TaskBar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initEventsMouse() {
        //instantiates a mouse listener for use user be in TrayIcon
        mlOpcoes = new MouseListener() {

            public void mouseClicked(MouseEvent e) {
//                     frame.setVisible(true);
//                     frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
                /*  if the mouse is clicked with the wheel mouse or with
                 *  button right close the application 
                 if(e.getButton() == 2 || e.getButton() == 3){
                 //System.exit(0);
                 }*/
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        };

        //add mouseListener in TrayIcon
        TrayIconBar.addMouseListener(mlOpcoes);
    }

    /**
     * @return PopUp
     */
    private PopupMenu initPopUpMenu() {

        PopupMenu popup = new PopupMenu();

        MenuItem miAbout = new MenuItem("Sobre");
        miAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "TASK BAR\n"
                        + "Versão 1.0\n\n"
                        + "Desenvolvido por Charleston Anjos\n");

            }
        });

        MenuItem miReturn = new MenuItem("Voltar");
        miReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

        MenuItem miExit = new MenuItem("Sair");
        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        popup.add(miAbout);
        popup.addSeparator();
        popup.add(miReturn);
        popup.addSeparator();
        popup.add(miExit);

        return popup;
    }

    /**
     *
     * @param title
     * @param message
     * @param type
     */
    public void displayMessageTask(String title, String message, int type) {

        String style = "";

        if (type == 0) {
            style = "NONE";
        }
        if (type == 1) {
            style = "INFO";
        }
        if (type == 2) {
            style = "ERROR";
        }
        if (type == 3) {
            style = "WARNING";
        }

        TrayIconBar.displayMessage(title, message, TrayIcon.MessageType.valueOf(style));
    }
}
