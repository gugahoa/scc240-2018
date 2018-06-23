package br.usp.icmc.gustavoaguiar.library;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {

    R apply(T t, U u, V v);

}

