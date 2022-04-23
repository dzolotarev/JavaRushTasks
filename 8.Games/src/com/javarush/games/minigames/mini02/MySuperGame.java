package com.javarush.games.minigames.mini02;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

public class MySuperGame extends Game {
    @Override
    public void initialize() {
        // Создаем игровое поле 3x3 клетки
        setScreenSize(3, 3);
        // Выключаем отображение сетки
        showGrid(true);
        // Меняем фон центральной клетки на синий и отображаем в ней "Х"
        setCellValueEx(1, 1, Color.RED, "Х", Color.FIREBRICK, 100);
        setCellValueEx(2, 2, Color.BLUE, "G", Color.RED, 100);
    }
}
