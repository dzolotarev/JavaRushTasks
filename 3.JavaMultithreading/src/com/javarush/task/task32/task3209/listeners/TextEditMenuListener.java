package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class TextEditMenuListener implements MenuListener {
    private View view;

    public TextEditMenuListener(View view) {
        this.view = view;
    }


    public void menuSelected(MenuEvent e) {
        Component[] components = ((JMenu) e.getSource()).getMenuComponents();
        for (Component component: components) {
            component.setEnabled(view.isHtmlTabSelected());
        }

    }


    public void menuDeselected(MenuEvent e) {

    }

    public void menuCanceled(MenuEvent e) {

    }
}
