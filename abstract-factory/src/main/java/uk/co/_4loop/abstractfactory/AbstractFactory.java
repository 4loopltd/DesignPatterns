package uk.co._4loop.abstractfactory;

public interface AbstractFactory<T> {
    T create(String type);
}
