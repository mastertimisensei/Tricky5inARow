/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tricky5inarow;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author BISOLA-OJO
 */

public class fiveInArowGUI extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private Model model;
    private ArrayList<JButton> but = new ArrayList();

    public fiveInArowGUI(){
        setTitle("Tricky Five in a Row");
        setSize(450,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //getContentPane();
        start();
    }
    void start(){
        getContentPane().removeAll();
        getContentPane().revalidate();
        getContentPane().repaint();
        JButton small = new JButton();
        small.setText("6x6");
        small.addActionListener(getActionListener(6));
        JButton mid = new JButton();
        mid.setText("10x10");
        mid.addActionListener(getActionListener(10));
        JButton large = new JButton();
        large.setText("14x14");
        large.addActionListener(getActionListener(14));
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        getContentPane().add(small);
        getContentPane().add(mid);
        getContentPane().add(large);
    }

    private ActionListener getActionListener(final int size){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().revalidate();
                getContentPane().repaint();

                //getContentPane().setLayout(new GridLayout(size,size));
                JPanel top = new JPanel();
                //top.setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
                JButton b2 = new JButton();
                b2.setText("New game");
                b2.addActionListener(k -> start());
                top.add(b2);

                JPanel main = new JPanel();
                main.setLayout(new GridLayout(size,size));
                model = new Model(size);
                for (int i = 0; i < size; i++){
                    for (int j=0; j<size; j++){
                        addButton(main,i,j);
                    }
                }
                getContentPane().add(top,BorderLayout.NORTH);
                getContentPane().add(main,BorderLayout.CENTER);

            }

        };

        }
             private void addButton(JPanel panel,final int i, final int j){
            final JButton b = new JButton();
            but.add(b);
            b.addActionListener(e-> {
                Player newValue = model.step(i,j);
                b.setText(newValue.name());
                //insert code here
                Player winner = model.getWinner();
                if (winner!= Player.NOBODY){
                    showGameOverMessage(winner);
                }
                /*model.PUnstep(newValue);
                if (winner == Player.NOBODY){
                    if (model.c1 != null){
                      but.get((model.c1.getRow())*model.size + (model.c1.getColumn())).setText("");
                      model.c1 = null;
                    }
                    if (model.c2 != null){
                      but.get((model.c2.getRow())*model.size + (model.c2.getColumn())).setText("");
                      model.c2 = null;
                    }
                }*/
            });
            panel.add(b);
    }
    private void showGameOverMessage(Player winner){
        JOptionPane.showMessageDialog(this,"Game Over. Winner: "+winner.name());
        start();
    }
}
