package br.edu.ifs.ED.lista;

import org.assertj.core.api.AssertionsForInterfaceTypes;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ListaEnc<T extends Comparable<T>> extends Lista<T> {
    No<T> no1=new No<>();
    No<T> auxNo = new No<>();
    int qntdElementos=-1;
    No fimLista;
    No inicioLista=no1;
    public ListaEnc(){
        super();
    }

    @Override
    public void incluir(T elemento) throws Exception {
        if(getTamanho()==-1||no1.dado==null){
            incluirInicio(elemento);
            fimLista=no1;
        }else{
            No<T> noFinal = new No<>();
            if (no1.prox==null){
                noFinal.dado=elemento;
                no1.prox=noFinal;
            }
            else{
                auxNo = no1;
                do {
                    auxNo = auxNo.prox;
                } while (auxNo.prox != null);
                noFinal.dado = elemento;
                auxNo.prox = noFinal;
            }
            noFinal.prox=null;
            fimLista=noFinal;
            qntdElementos++;
        }
    }


    public T get(int posicao)  throws Exception {
        if(posicao<=getTamanho()){
            int tempPosicao = 0;
            auxNo = no1;
            while (posicao != tempPosicao){
                auxNo = auxNo.prox;
                tempPosicao++;
            }
            return auxNo.dado;
        }else {
            System.out.println("Posição solicitada não existe na lista");
            return null;
        }
    }

    public int getPosElemento(T elemento)  throws Exception {
            int tempPosicao = 0;
            auxNo = no1;
        if (no1.dado!=elemento) {
            while (auxNo.prox != null) {
                auxNo = auxNo.prox;
                tempPosicao++;
                if (auxNo.dado.equals(elemento)) {
                    return tempPosicao;
                }
            }
        }else{
            return 0;
        }
                System.out.println("Elemento não encontrado.");
                return -1;
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        if(no1.dado==null){
            no1.dado = elemento;
            no1.prox=null;
            inicioLista=no1;
            qntdElementos=1;
        }else{
            No<T> novoElemento=new No<>();
            novoElemento.prox=no1;
            novoElemento.dado=elemento;
            No<T> auxTemp=new No<>();
            auxTemp= no1;
            no1= novoElemento;
            novoElemento= auxTemp;
            inicioLista=no1;
            qntdElementos++;
        }
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if(posicao==0){
            incluirInicio(elemento);
        }else {
            if (posicao > getTamanho()) {
                incluir(elemento);
            } else {
                auxNo = no1;
                int tempPos=0;
               while((posicao-1)!=tempPos){
                   auxNo = auxNo.prox;
                   tempPos++;
               }
               No<T> no2 = new No<>();
               no2.dado=elemento;
               no2.prox=auxNo.prox;
               auxNo.prox=no2;
               qntdElementos++;
            }
        }
    }

    @Override
    public void remover(int posicao) throws Exception {
        if(posicao>getTamanho()||posicao<0){
            System.out.println("Posição solicitada não existe na lista");
        }else{
            if(posicao>0){
                auxNo = no1;
                int tempPos = 0;
                while ((posicao) != tempPos) {
                    auxNo = auxNo.prox;
                    tempPos++;
                }
                No<T> salvarNo = new No<>();
                salvarNo = auxNo.prox;
                tempPos = 0;
                auxNo=no1;
                while ((posicao - 1) != tempPos) {
                    auxNo = auxNo.prox;
                    tempPos++;
                }
                auxNo.prox=salvarNo;
                qntdElementos--;
            }else{
                no1=no1.prox;
                inicioLista=no1;
                qntdElementos--;
            }
        }
    }

    @Override
    public int getTamanho() {
        return qntdElementos;
    }

    public void limpar() {
        no1.dado=null;
        no1.prox=null;
        qntdElementos=0;
    }


    @Override
    public boolean contem(T elemento) throws Exception {
        for (int i=0;i<getTamanho();i++){
            if (get(i).equals(elemento)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkList() throws Exception {
        return false;
    }

    @Override
    public void corrigirLista() throws Exception {
    }

}
