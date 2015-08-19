import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Gui extends JComponent{



private static class Line{
    final int x1;
    final int y1;
    final int x2;
    final int y2;
    final Color color;

    public Line(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }
}

private static class Building{
    final int x1;
    final int x2;
    final int height;
    final int BASE = 940;
    final int LEFT = 20;
    final int RIGHT = 1900;


    public Building(int x1, int x2, int height) {

        this.x1 = LEFT + x1;
        this.x2 = x2;
        this.height = height;


    }
}


private final LinkedList<Line> lines = new LinkedList<Line>();
private final ArrayList<Building> buildings = new ArrayList<Building>();


public void addLine(int x1, int x2, int x3, int x4) {
    addLine(x1, x2, x3, x4, Color.black);
}

public void addLine(int x1, int x2, int x3, int x4, Color color) {
    lines.add(new Line(x1,x2,x3,x4, color));
    repaint();
}

public void addBuilding(int x1, int x2, int x3) {
	//enforce 5 pixel width minimum and bounds of skyline
	if((x2 - x1) < 5){
		x2+=5;
	}
	//enforce max height
	if(x3 > 900){
		x3 = 900;
	}
	if (x1 > 1900){
		x1 = 1900;
	}
	if(x2 > 1910){
		x2 =1910;
	}

    buildings.add(new Building(x1,x2,x3));
    repaint();
}

public void clearLines() {
    lines.clear();
    repaint();
}

public void clearBuildings() {
    buildings.clear();
    repaint();
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    final int BASE = 940;
    final int LEFT = 20;
    final int RIGHT = 1900;

    g.drawLine(LEFT, BASE, RIGHT , BASE);

    for (Building building : buildings) {
        g.setColor(Color.black);


        g.fillRect(building.x1, building.BASE - building.height, building.x2-building.x1 , building.height);


        //g.drawRect(building.x1, building.BASE, building.x2-building.x1 , building.height);

    }
}

public static void main(String[] args) {

    JFrame testFrame = new JFrame();
    testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    final Gui comp = new Gui();
    comp.setPreferredSize(new Dimension(1920, 1020));
    testFrame.getContentPane().add(comp, BorderLayout.CENTER);
    JPanel buttonsPanel = new JPanel();
    JButton loadSkyButton = new JButton("Load buildings");
    JButton drawSkyLineButton = new JButton("Draw Skyline");
    JButton clearButton = new JButton("Clear");
    buttonsPanel.add(loadSkyButton);
    buttonsPanel.add(drawSkyLineButton);
    buttonsPanel.add(clearButton);
    testFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
    Divider divider = new Divider();


    loadSkyButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {


        	divider.makeList();


        }
    });

    drawSkyLineButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

        	//Generate a pseudo-random skyline
        	HashMap <Integer, ArrayList<Integer>> skyTuples = divider.getList();
        	for(int i = 0; i < 100; i++){
        		ArrayList<Integer> next = skyTuples.get(i);

        		switch (i%7){
        		case 0:
        			comp.addBuilding(500+ next.get(0), 510 + next.get(1), next.get(2)*10);
        			System.out.println("0");
        			break;
        		case 1:
        			comp.addBuilding(next.get(0)*2,  next.get(1)*5, next.get(2)*2);
        			System.out.println("1");
        			break;
        		case 2:
        			comp.addBuilding(1400 + next.get(0), 1430 + next.get(1) , next.get(2)*2);
        			System.out.println("2");
        			break;
        		case 3:
        			comp.addBuilding(next.get(0)*7,  next.get(1)*8, next.get(2)*2);
        			System.out.println("3");
        			break;
        		case 4:
        			comp.addBuilding(next.get(0),  next.get(1)*2, next.get(2)*10);
        			System.out.println("4");
        			break;
           		case 5:
        			comp.addBuilding(1500 + next.get(0), 1520 +  next.get(1)*2, next.get(2)*10);
        			System.out.println("5");
        			break;
        		case 6:
        			comp.addBuilding(800 + next.get(0)*2, 810 + next.get(1)*3, next.get(2)*5);
        			System.out.println("6");
        			break;
        		case 8:
        			comp.addBuilding(1600 + next.get(0)*2, 1610 + next.get(1)*3, next.get(2)*10);
        			System.out.println("8");
        			break;

        		default:
        			comp.addBuilding(next.get(0)*8,  next.get(1)*9, next.get(2)*3);
        			System.out.println("other");
        			break;
        		}



        	}

        }
    });
    clearButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            comp.clearBuildings();
        }
    });
    testFrame.pack();
    testFrame.setVisible(true);
}




}



