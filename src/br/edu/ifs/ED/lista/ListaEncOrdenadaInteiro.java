package br.edu.ifs.ED.lista;

public class ListaEncOrdenadaInteiro extends ListaEncOrdenada<Integer>{
    No<Integer> no1=new No<>();
    No<Integer> auxNo = new No<>();
    int qntdElementos=-1;
    No fimLista;
    No inicioLista=no1;
    @Override
    public void incluir(Integer elemento) throws Exception {
        if(getTamanho()==-1||no1.dado==null){
            incluirInicio(elemento);
            fimLista=no1;
        }else{
            if (no1.prox==null){
                if(elemento.compareTo(no1.dado)>0){
                    No<Integer> noFinal = new No<>();
                    noFinal.dado = elemento;
                    no1.prox = noFinal;
                    noFinal.prox = null;
                    fimLista = noFinal;
                    qntdElementos++;
                }else{
                    No<Integer> novoElemento = new No<>();
                    novoElemento.prox = no1;
                    novoElemento.dado = elemento;
                    No<Integer> auxTemp = new No<>();
                    auxTemp = no1;
                    no1 = novoElemento;
                    novoElemento = auxTemp;
                    inicioLista = no1;
                    qntdElementos++;
                }
            }
            else{
                auxNo = no1;
                do {
                    auxNo = auxNo.prox;
                } while (auxNo.prox != null);
                if(auxNo.dado.compareTo(elemento)<0){
                    No<Integer> noFinal = new No<>();
                    noFinal.dado = elemento;
                    auxNo.prox = noFinal;
                    noFinal.prox=null;
                    fimLista = noFinal;
                    qntdElementos++;
                }else{
                    No<Integer> noFinal = new No<>();
                    noFinal=no1;
                    int auxPos=0;
                    while (noFinal.dado.compareTo(elemento)<0) {
                        noFinal = noFinal.prox;
                        auxPos++;
                    }
                    incluir(elemento,auxPos);
                }
            }
        }
    }

    @Override
    public void incluirInicio(Integer elemento) throws Exception {
        if(no1.dado==null){
            no1.dado = elemento;
            no1.prox=null;
            inicioLista=no1;
            qntdElementos=1;
        }else{
            if(elemento.compareTo(no1.dado)<0){
                No<Integer> novoElemento = new No<>();
                novoElemento.prox = no1;
                novoElemento.dado = elemento;
                No<Integer> auxTemp = new No<>();
                auxTemp = no1;
                no1 = novoElemento;
                novoElemento = auxTemp;
                inicioLista = no1;
                qntdElementos++;
            }else{
                throw new Exception("Elemento viola a ordenação.");
            }
        }
    }

    @Override
    public void incluir(Integer elemento, int posicao) throws Exception {
        if(posicao==0){
            incluirInicio(elemento);
        }else {
            if (posicao > getTamanho()) {
                throw new Exception("Posição inválida.");
            } else {
                auxNo = no1;
                int tempPos=0;
                while((posicao-1)!=tempPos){
                    auxNo = auxNo.prox;
                    tempPos++;
                }
                if(elemento.compareTo(no1.dado)>0){
                    No<Integer> auxNo2 = new No<>();
                    auxNo2.dado= (Integer) auxNo.prox.dado;
                    if ((auxNo2.dado.compareTo(elemento))>0){
                        No<Integer> no2 = new No<>();
                        no2.prox=auxNo.prox;
                        auxNo.prox=no2;
                        no2.dado=elemento;
                        qntdElementos++;
                    }else{
                        throw new Exception("Elemento viola a ordenação.");
                    }
                }else{
                    throw new Exception("Elemento viola a ordenação.");
                }

            }
        }
    }

    @Override
    public Integer get(int posicao) throws Exception {
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

    @Override
    public int getPosElemento(Integer elemento) throws Exception {
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
                No<Integer> salvarNo = new No<>();
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
    public void limpar() {
        no1.dado=null;
        no1.prox=null;
        qntdElementos=0;
    }

    @Override
    public int getTamanho() {
        return qntdElementos;
    }

    @Override
    public boolean contem(Integer elemento) throws Exception {
        for (int i=0;i<getTamanho();i++){
            if (get(i).equals(elemento)){
                return true;
            }
        }
        return false;
    }
}
