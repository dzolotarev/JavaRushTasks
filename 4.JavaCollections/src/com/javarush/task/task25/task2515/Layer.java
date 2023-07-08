package com.javarush.task.task25.task2515;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Denis Zolotarev
 */
public class Layer extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.ORANGE); //Задаем цвет ракет
        List<Rocket> rockets = Space.game.getRockets(); //Получаем ракеты
        //одна точка у нас будет 10 пикселей, все умножаем на 10
        for (int i = 0; i < rockets.size(); i++) {
            g.fillRect((int) (rockets.get(i).getX() * 10), (int) (rockets.get(i).getY() * 10), 10, 10); //Рисуем по очереди ракеты
        }

        g.setColor(Color.RED); //цвет бомб
        List<Bomb> bombs = Space.game.getBombs(); //Получаем бомбы
        for (int i = 0; i < bombs.size(); i++) {
            g.fillRect((int) (bombs.get(i).getX() * 10), (int) (bombs.get(i).getY() * 10), 10, 10); //Рисуем по очереди бомбы
        }
        g.setColor(Color.MAGENTA); //цвет корабля
        g.fillRect((int) Space.game.getShip().getX() * 10, (int) Space.game.getShip().getY() * 10, 10, 10);
        g.fillRect((int) Space.game.getShip().getX() * 10, (int) Space.game.getShip().getY() * 10 + 10, 10, 10);
        g.fillRect((int) Space.game.getShip().getX() * 10, (int) Space.game.getShip().getY() * 10 - 10, 10, 10);
        g.fillRect((int) Space.game.getShip().getX() * 10 - 20, (int) Space.game.getShip().getY() * 10 + 10, 10, 10);
        g.fillRect((int) Space.game.getShip().getX() * 10 + 20, (int) Space.game.getShip().getY() * 10 + 10, 10, 10);
        g.fillRect((int) Space.game.getShip().getX() * 10, (int) Space.game.getShip().getY() * 10 + 20, 10, 10);
        g.fillRect((int) Space.game.getShip().getX() * 10 - 10, (int) Space.game.getShip().getY() * 10 + 20, 10, 10);
        g.fillRect((int) Space.game.getShip().getX() * 10 + 10, (int) Space.game.getShip().getY() * 10 + 20, 10, 10);
        g.fillRect((int) Space.game.getShip().getX() * 10 - 20, (int) Space.game.getShip().getY() * 10 + 20, 10, 10);
        g.fillRect((int) Space.game.getShip().getX() * 10 + 20, (int) Space.game.getShip().getY() * 10 + 20, 10, 10);
        g.setColor(Color.GREEN); //цвет НЛО
        List<Ufo> ufos = Space.game.getUfos(); //Получаем НЛО
        for (int i = 0; i < ufos.size(); i++) {
            g.fillRect((int) (ufos.get(i).getX() * 10), (int) (ufos.get(i).getY() * 10), 10, 10);
            g.fillRect((int) (ufos.get(i).getX() * 10), (int) (ufos.get(i).getY() * 10 - 10), 10, 10);
            g.fillRect((int) (ufos.get(i).getX() * 10 - 10), (int) (ufos.get(i).getY() * 10), 10, 10);
            g.fillRect((int) (ufos.get(i).getX() * 10 + 10), (int) (ufos.get(i).getY() * 10), 10, 10);
            g.fillRect((int) (ufos.get(i).getX() * 10 - 20), (int) (ufos.get(i).getY() * 10), 10, 10);
            g.fillRect((int) (ufos.get(i).getX() * 10 + 20), (int) (ufos.get(i).getY() * 10), 10, 10);
            g.fillRect((int) (ufos.get(i).getX() * 10), (int) (ufos.get(i).getY() * 10 + 10), 10, 10);
            g.fillRect((int) (ufos.get(i).getX() * 10 - 10), (int) (ufos.get(i).getY() * 10 + 10), 10, 10);
            g.fillRect((int) (ufos.get(i).getX() * 10 + 10), (int) (ufos.get(i).getY() * 10 + 10), 10, 10);
        }
    }
}
