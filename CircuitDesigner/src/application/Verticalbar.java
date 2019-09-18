package application;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import application.controller.Mouse;


public class Verticalbar extends JPanel{
	private JButton track;
    private JButton component;
    private JButton select;
    private Color activeColor = Color.lightGray;
    private Color inactiveColor = new Color(238,238,238);
    private static Verticalbar instance;

    public Verticalbar() {
        instance = this;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JToolBar selectBar = new JToolBar(JToolBar.VERTICAL);
        selectBar.setBorder(BorderFactory.createLineBorder(Color.red));

        select = new JButton("S");
        select.setToolTipText("Selection Mode");
        component = new JButton("C");
        component.setToolTipText("Component Mode");
        track = new JButton("T");
        select.setToolTipText("Track Mode");

        select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mouse.setMode(Mouse.Mode.Select);
                setActive(e);
            }
        });

        component.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mouse.setMode(Mouse.Mode.Component);
                setActive(e);
            }
        });


        track.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mouse.setMode(Mouse.Mode.Track);
                setActive(e);
            }
        });


        selectBar.add(select);
        selectBar.add(component);
        selectBar.add(track);
        selectBar.setFloatable(false);

        this.add(selectBar);
        this.add(new ComponentsViewer());
        this.setBorder(BorderFactory.createLineBorder(Color.green));

    }

    void setActive(ActionEvent e) {
        select.setBackground(inactiveColor);
        component.setBackground(inactiveColor);
        track.setBackground(inactiveColor);
        ((JButton) e.getSource()).setBackground(activeColor);
    }
    
   void setComponentActive(){
        select.setBackground(inactiveColor);
        component.setBackground(activeColor);
        track.setBackground(inactiveColor);
    }

}
