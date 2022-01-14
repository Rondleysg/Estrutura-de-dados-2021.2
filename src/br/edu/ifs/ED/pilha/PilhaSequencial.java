package br.edu.ifs.ED.pilha;

public class PilhaSequencial<T> implements IPilha<T>{

    public PilhaSequencial(Class<T> dataType){
        this.max = 10;
        this.posTopo=-1;
        this.dados = (T[]) java.lang.reflect.Array.newInstance(dataType, this.max);
    }
    T[] dados;
    int max;
    int posTopo;

    @Override
    public void empilhar(T valor) throws PilhaCheiaException {
        try{
            if (posTopo<(max)){
                posTopo++;
                dados[posTopo]=valor;
            }else{
                throw new PilhaCheiaException("Pilha cheia.");
            }
        } catch (PilhaCheiaException | ArrayIndexOutOfBoundsException e) {
            throw new PilhaCheiaException("Pilha cheia.");
        }
    }

    @Override
    public T desempilhar() throws PilhaVaziaException {
        try {
            if (posTopo>-1){
                int temp=posTopo;
                posTopo--;
                return dados[temp];
            }else {
                throw new PilhaVaziaException("Pilha vazia.");
            }
        } catch (PilhaVaziaException e) {
            throw new PilhaVaziaException("Pilha vazia.");
        }
    }

    @Override
    public T getTopo() throws PilhaVaziaException{
        try{
            if (posTopo>-1){
                return dados[posTopo];
            }else{
                throw new PilhaVaziaException("Pilha vazia.");
            }
        } catch (PilhaVaziaException | ArrayIndexOutOfBoundsException e) {
            throw new PilhaVaziaException("Pilha vazia.");
        }
    }

    @Override
    public int getQtd() {
        return (posTopo+1);
    }

    @Override
    public boolean estahVazia() {
        if (posTopo>-1){
            return false;
        }else{
            return true;
        }
    }
}
