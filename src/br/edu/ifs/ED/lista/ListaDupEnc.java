package br.edu.ifs.ED.lista;

public class ListaDupEnc<T extends Comparable<T>> extends Lista<T>{
    NoDup<T> no1 = new NoDup<>();
    NoDup<T> auxNo = new NoDup<>();
    int qntdElementos;
    NoDup fimLista;
    NoDup inicioLista=no1;
    public ListaDupEnc(){
        no1.prox=null;
        no1.ant=null;
        no1.dado=null;
        qntdElementos=0;
    }
    @Override
    public void incluir(T elemento) throws Exception {
        try{
            if(getTamanho()==0||inicioLista.dado==null){
                incluirInicio(elemento);
            }else{
                NoDup<T> noFinal = new NoDup<>();
                noFinal.dado=elemento;
                if (inicioLista.prox==null){
                    inicioLista.prox=noFinal;
                    noFinal.ant=inicioLista;
                }
                else{
                    auxNo = inicioLista;
                    do {
                        auxNo = auxNo.prox;
                    } while (auxNo.prox != null);
                    auxNo.prox = noFinal;
                    noFinal.ant=auxNo;
                }
                noFinal.prox=null;
                fimLista=noFinal;
                qntdElementos++;
            }
        }
        catch(Exception e){
            throw new Exception("Erro ao incluir no final.");
        }
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        try{
            NoDup<T> aux = new NoDup<>();
            aux.dado = elemento;
            if (inicioLista.dado == null) {
                inicioLista.dado = elemento;
                inicioLista.prox = null;
                inicioLista.ant = null;
                fimLista = inicioLista;
                qntdElementos = 1;
                fimLista=inicioLista;
            } else {
                NoDup<T> auxTemp = new NoDup<>();
                aux.prox = inicioLista;
                inicioLista.ant = aux;
                auxTemp = inicioLista;
                inicioLista = aux;
                aux = auxTemp;
                qntdElementos++;
            }
        }
        catch (Exception e){
            throw new Exception("Erro ao incluir no inicio.");
        }

    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        try {
            if(posicao==0){
                incluirInicio(elemento);
            }else {
                if (posicao > getTamanho()) {
                    System.out.println("Posição não existe na lista.");
                } else {
                    if (posicao<0){
                        System.out.println("Posição não existe na lista.");
                    } else{
                        auxNo = inicioLista;
                        int tempPos = 0;
                        while ((posicao - 1) != tempPos) {
                            auxNo = auxNo.prox;
                            tempPos++;
                        }
                        NoDup<T> novo = new NoDup<>();
                        novo.dado = elemento;
                        novo.prox = auxNo.prox;
                        auxNo.prox = novo;
                        novo.ant=auxNo;
                        qntdElementos++;
                    }
                }
            }
        }
        catch (Exception e){
            throw new Exception("Erro ao incluir por posição");
        }
    }

    @Override
    public T get(int posicao) throws Exception {
        try {
            if(posicao<=getTamanho()&&posicao>-1){
                int tempPosicao = 0;
                auxNo = inicioLista;
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
        catch (Exception e){
            throw new Exception("Erro ao pegar elemento por posição");
        }

    }

    @Override
    public int getPosElemento(T elemento) throws Exception {
        try {
            int tempPosicao = 0;
            auxNo = inicioLista;
            if (inicioLista.dado!=elemento) {
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
        catch (Exception e){
            throw new Exception("Erro ao pegar posição do elemento");
        }

    }

    @Override
    public void remover(int posicao) throws Exception {
        try {
            if(posicao>getTamanho()||posicao<0){
                System.out.println("Posição solicitada não existe na lista");
            }else{
                if(posicao>0){
                    auxNo = inicioLista;
                    int tempPos = 0;
                    while ((posicao) != tempPos) {
                        auxNo = auxNo.prox;
                        tempPos++;
                    }
                    auxNo.ant.prox=auxNo.prox;
                    auxNo.prox.ant=auxNo.ant;
                    qntdElementos--;
                }else{
                    inicioLista=inicioLista.prox;
                    inicioLista.ant=null;
                    qntdElementos--;
                }
            }
        }
        catch (Exception e){
            throw new Exception("Erro ao remover elemento.");
        }

    }

    @Override
    public void limpar() {
        inicioLista.dado=null;
        inicioLista.prox=null;
        qntdElementos=0;
    }

    @Override
    public int getTamanho() {
        return qntdElementos;
    }

    @Override
    public boolean contem(T elemento) throws Exception {
        try {
            for (int i=0;i<getTamanho();i++){
                if (get(i).equals(elemento)){
                    return true;
                }
            }
            return false;
        }
        catch (Exception e){
            throw new Exception("Erro no metódo contém");
        }

    }

    /*@Override
    public String toStringContrario() {
        auxNo = fimLista;
        String resposta = "";
        while (auxNo != null) {
            resposta += auxNo.dado + " ";
            auxNo = auxNo.ant;
        }
        return resposta;
    }*/

    @Override
    public String toString(){
        auxNo = inicioLista;
        String resposta = "";
        while (auxNo!=null){
            resposta += auxNo.dado + " ";
            auxNo = auxNo.prox;
        }
        return resposta;
    }

    @Override
    public boolean checkList () throws Exception {
        if(getTamanho()>0){
                auxNo=fimLista;
                while (auxNo.ant != null) {
                    auxNo = auxNo.ant;
                }
                if (auxNo==inicioLista){
                    System.out.println("Lista está correta");
                    return true;
                }else{
                    System.out.println("Lista quebrada.");
                    System.out.println("Corrigindo...");
                    corrigirLista();
                    System.out.println("Lista corrigida.");
                    return true;
                }
        }else{
            System.out.println("Lista sem elementos.");
            return true;
        }
    }
    @Override
    public void corrigirLista () throws Exception {
        auxNo=inicioLista.prox;
        while (auxNo.prox != null) {
                if (auxNo.ant==null){
                    NoDup aux;
                    aux=inicioLista;
                    do {
                        aux=aux.prox;
                    }while (aux.prox!=auxNo);
                    auxNo.ant=aux;
                }
            auxNo = auxNo.prox;
        }
    }
}
