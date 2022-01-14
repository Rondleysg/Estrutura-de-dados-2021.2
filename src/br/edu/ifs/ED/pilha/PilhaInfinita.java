package br.edu.ifs.ED.pilha;

public class PilhaInfinita<T> extends PilhaSequencial<T>{
    public PilhaInfinita(Class<T> dataType) {
        super(dataType);
        this.max = 1;
        this.posTopo=-1;
        this.dados = (T[]) java.lang.reflect.Array.newInstance(dataType, this.max);
    }
    T[] dados;
    static int max;
    int posTopo;

    private static Object aumentarMax (Object dados, int newMax) {
        int oldMax = java.lang.reflect.Array.getLength(dados);
        Class T = dados.getClass().getComponentType();
        Object newDados = java.lang.reflect.Array.newInstance(T, newMax);
            System.arraycopy(dados, 0, newDados, 0, oldMax);
        return newDados;
    }

    @Override
    public void empilhar(T valor) throws PilhaCheiaException {
        try{
                max++;
                dados = (T[])aumentarMax(dados,max);
                posTopo++;
                dados[posTopo]=valor;
        } catch (Exception e) {
            throw new PilhaCheiaException("Limite de memoria");
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
