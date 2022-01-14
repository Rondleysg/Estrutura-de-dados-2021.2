package br.edu.ifs.ED.pilha;

import br.edu.ifs.ED.lista.No;

public class PilhaEncadeada<T extends Comparable<T>> implements IPilha<T>{
    public PilhaEncadeada(Class<T> dataType){
        this.posTopo=-1;
    }
    int posTopo;
    No no1=new No<>();
    No<T> auxNo = new No<>();
    @Override
    public void empilhar(T valor) throws PilhaCheiaException {
        try{
            if (getQtd()==0){
                no1.dado = valor;
                no1.prox = null;
                posTopo++;
            }else{
                auxNo=no1;
                while (auxNo.prox!=null) {
                    auxNo=auxNo.prox;
                }
                No novoDado=new No<>();
                novoDado.dado=valor;
                novoDado.prox=null;
                auxNo.prox=novoDado;
                posTopo++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T desempilhar() throws PilhaVaziaException {
        try {
            if (getQtd()>0){
                auxNo=no1;
                while (auxNo.prox!=null) {
                    auxNo=auxNo.prox;
                }
                No<T> returnDado=new No<>();
                returnDado.dado= auxNo.dado;
                auxNo=no1;
                while (auxNo.prox!=null) {
                    auxNo = auxNo.prox;
                }
                auxNo.dado=null;
                auxNo.prox=null;
                posTopo--;
                return returnDado.dado;
            }else {
                throw new PilhaVaziaException("Pilha vazia.");
            }
        } catch (PilhaVaziaException | NullPointerException e) {
            throw new PilhaVaziaException("Pilha vazia.");
        }
    }

    @Override
    public T getTopo() throws PilhaVaziaException{
        try{
            if (posTopo>-1){
                auxNo=no1;
                while (auxNo.prox!=null){
                    auxNo=auxNo.prox;
                }
                return auxNo.dado;
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