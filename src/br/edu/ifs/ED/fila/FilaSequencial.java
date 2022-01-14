package br.edu.ifs.ED.fila;

public class FilaSequencial<T> implements IFila<T> {
    private int max;
    private T[] dados;
    private int inicio=-1,ultimo=-1;
    private int qntd=0;
    public FilaSequencial(Class<T> dataType){
        this.max = 10;
        this.dados = (T[]) java.lang.reflect.Array.newInstance(dataType, this.max);

    }

    public void incluir(T valor) throws FilaCheiaException {
        try{
            if (getQtd()==0){
                dados[0]=valor;
                inicio++;
                ultimo++;
                qntd++;
            }else{
                if (getQtd()!=max){
                    if (ultimo==max-1){
                        ultimo=0;
                        dados[ultimo]=valor;
                        qntd++;
                        return;
                    }
                    ultimo++;
                    dados[ultimo] = valor;
                    qntd++;
                }else{
                    throw new FilaCheiaException("Fila cheia.");
                }
            }
        }catch (FilaCheiaException e){
            throw new FilaCheiaException("Fila cheia.");
        }
    }

    public T remover() throws FilaVaziaException{
        try {
            if (getQtd() > 0) {
                T salvarDado = dados[inicio];
                dados[inicio]=null;
                qntd--;
                if (inicio==max-1){
                    inicio=0;
                    return salvarDado;
                }
                inicio++;
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
        return max;
    }

    public boolean estaVazia() {
        if (getQtd()>0){
            return false;
        }else{
            return true;
        }
    }

    public void limpar(){
        qntd=0;
        inicio=-1;
        ultimo=-1;
    }

    public T visualizarProximo() throws FilaVaziaException{
        try {
            if (getQtd()>0){
                return dados[inicio];
            }else {
                throw new FilaVaziaException("Fila vazia.");
            }
        } catch (FilaVaziaException e) {
            throw new FilaVaziaException("Fila vazia.");
        }
    }
}
