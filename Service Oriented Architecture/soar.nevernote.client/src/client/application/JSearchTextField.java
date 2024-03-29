package client.application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.UIManager;

public class JSearchTextField extends JTextField implements FocusListener {
 
    private String textWhenNotFocused;
 
    public JSearchTextField() {
        super();
        textWhenNotFocused = "Search...";
        setSize(500, 100);
        
        addFocusListener(this);
    }
 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
 
        if (!this.hasFocus() && this.getText().equals("")) {
            int width = this.getWidth();
          
            int height = this.getHeight();
            
            Font prev = g.getFont();
            Font italic = prev.deriveFont(Font.ITALIC);
            Color prevColor = g.getColor();
            g.setFont(italic);
            g.setColor(UIManager.getColor("textInactiveText"));
            int h = g.getFontMetrics().getHeight();
         
            int textBottom = (height - h) / 2 + h - 4;
            int x = this.getInsets().left;
            Graphics2D g2d = (Graphics2D) g;
            RenderingHints hints = g2d.getRenderingHints();
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.drawString(textWhenNotFocused, x, textBottom);
            g2d.setRenderingHints(hints);
            g.setFont(prev);
            g.setColor(prevColor);
        }
 
    }

    public void focusGained(FocusEvent e) {
        this.repaint();
    }
 
    public void focusLost(FocusEvent e) {
        this.repaint();
    }

}