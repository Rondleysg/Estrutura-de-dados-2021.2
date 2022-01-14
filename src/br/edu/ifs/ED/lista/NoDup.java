package br.edu.ifs.ED.lista;

public class NoDup<T> extends No<T> {
    public T dado;
    public NoDup prox;
    public NoDup ant;
    @Override
    public String toString() {
        return "dado=" + dado;
    }
}
