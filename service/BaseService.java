package service;

import java.util.List;

public interface BaseService<T> {
    T add(T t);
    List<T> list();

}
