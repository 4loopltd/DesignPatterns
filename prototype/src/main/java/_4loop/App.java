package _4loop;

import _4loop.prototype.Animal;
import _4loop.prototype.Mineral;
import _4loop.prototype.Prototype;
import _4loop.prototype.Vegetable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        Prototype cat = new Animal("Puss");
        log.info("Animal 1:" + cat + " : " + cat.hashCode());
        Prototype cat2 = cat.duplicate();
        log.info("Animal 2:" + cat2 + " : " + cat2.hashCode());

        Prototype carrot = new Vegetable("carrot");
        log.info("Vegetable 1:" + carrot + " : " + carrot.hashCode());
        Prototype carrot2 = carrot.duplicate();
        log.info("Vegetable 2:" + carrot2 + " : " + carrot2.hashCode());

        Prototype quartz = new Mineral("quartz");
        log.info("Mineral 1:" + quartz + " : " + quartz.hashCode());
        Prototype quartz2 = quartz.duplicate();
        log.info("Mineral 2:" + quartz2 + " : " + quartz2.hashCode());

    }

}