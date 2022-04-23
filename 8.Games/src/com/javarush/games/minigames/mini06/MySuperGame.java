package com.javarush.games.minigames.mini06;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

public class MySuperGame extends Game {
    @Override
    public void initialize() {
        // Устанавливаем размер игрового поля 3x3
        setScreenSize(3, 3);

        // Закрашиваем игровое поле белым цветом
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        // Ставим символ "X" в клетку, по которой кликнули левой кнопкой мыши
        setCellValue(x, y, "X");
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        // Очищаем клетку, по которой кликнули правой кнопкой мыши
        setCellValue(x, y, "");
    }
}