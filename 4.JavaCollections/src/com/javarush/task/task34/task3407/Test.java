package com.javarush.task.task34.task3407;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

/**
 * @author Denis Zolotarev
 */
public class Test {
    public static void main(String[] args) {
        //специальная очередь для призрачных объектов
        ReferenceQueue<Integer> queue = new ReferenceQueue<Integer>();

//список призрачных ссылок
        ArrayList<PhantomReference<Integer>> list = new ArrayList<PhantomReference<Integer>>();

//создаем 10 объектов и добавляем их в список через призрачные ссылки
        for ( int i = 0; i < 10; i++)
        {
            Integer x = i;
            list.add(new PhantomReference<Integer>(x, queue));
        }

//взываем сборщик мусора, надеемся, что он нас послушается :)
//он должен убить все «призрачно достижимые» объекты и поместить их в очередь
//призраков
        System.gc();

//достаем из очереди все объекты
        Reference<? extends Integer> referenceFromQueue;
        while ((referenceFromQueue = queue.poll()) != null)
        {
            //выводим объект на экран
            System.out.println(referenceFromQueue.get());
            //очищаем ссылку
            referenceFromQueue.clear();
        }
    }
}
