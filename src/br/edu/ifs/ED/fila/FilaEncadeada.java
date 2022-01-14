package br.edu.ifs.ED.fila;

import br.edu.ifs.ED.lista.No;

public class FilaEncadeada<T extends Comparable<T>> implements IFila<T>{
    No<T> posUltimo,posPrimeiro;
    int qntd=0;
    No<T> no1=new No<>();
    No<T> auxNo = new No<>();
    public FilaEncadeada(Class<T> dataType){
        this.posUltimo=new No<>();
        this.posPrimeiro=new No<>();
    }

    public void incluir(T valor) {
        try{
            if (getQtd()==0){
                no1.dado=valor;
                no1.prox=null;
                posPrimeiro=no1;
                posUltimo=no1;
                qntd++;
            }else{
                auxNo=no1;
                while (auxNo.prox!=null){
                    auxNo=auxNo.prox;
                }
                No newDado = new No<>();
                newDado.dado=valor;
                newDado.prox=null;
                auxNo.prox=newDado;
                posUltimo=newDado;
                qntd++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public T remover() throws FilaVaziaException{
        try {
            if (getQtd() > 0) {
                T salvarDado = posPrimeiro.dado;
                no1=no1.prox;
                posPrimeiro=no1;
                qntd--;
                return salvarDado;
            } else {
                throw new FilaVaziaException("Fila vazia.");
            }
        }catch (FilaVaziaException e){
            throw new FilaVaziaException("Fila vazia.");
        }
    }

    public int getQtd() {
        return  qntd;
    }

    @Override
    public int getQtdMaxSuportada() {
        //O tamanho máximo suportado não existe, a fila é infinita.
        return 50;
    }

    public boolean estaVazia() {
        if (getQtd()>0){
            return false;
        }else{
            return true;
        }
    }

    public void limpar(){
        no1.dado=null;
        no1.prox=null;
        posPrimeiro=null;
        posUltimo=null;
        qntd=0;
    }

    public T visualizarProximo() throws FilaVaziaException{
        try {
            if (getQtd()>0){
                return posPrimeiro.dado;
            }else {
                throw new FilaVaziaException("Fila vazia.");
            }
        } catch (FilaVaziaException e) {
            throw new FilaVaziaException("Fila vazia.");
        }
    }
}