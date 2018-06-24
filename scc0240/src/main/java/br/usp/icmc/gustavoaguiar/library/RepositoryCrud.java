package br.usp.icmc.gustavoaguiar.library;

public interface RepositoryCrud<T, K> {
    T create(T obj);
    T get(K key);
    boolean delete(K key);
    boolean update(T obj);
}
