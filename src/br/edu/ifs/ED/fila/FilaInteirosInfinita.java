package br.edu.ifs.ED.fila;

public class FilaInteirosInfinita  extends FilaSequencial<Integer> {
    private int max;
    private Integer[] dados;
    private int inicio=-1,ultimo=-1;
    private int qntd=0;

    public FilaInteirosInfinita() {
        super(java.lang.Integer.class);
        this.max = 2;
        this.dados = (Integer[]) java.lang.reflect.Array.newInstance(Integer.class, this.max);
    }

    private static Object aumentarMax (Object dados, int newMax) {
        int oldMax = java.lang.reflect.Array.getLength(dados);
        Class T = dados.getClass().getComponentType();
        Object newDados = java.lang.reflect.Array.newInstance(T, newMax);
            System.arraycopy(dados, 0, newDados, 0, oldMax);
        return newDados;
    }

    public void incluir(Integer valor) throws FilaCheiaException {
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
                    max++;
                    dados=((Integer[])aumentarMax(dados,max));
                    incluir(valor);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Integer remover() throws FilaVaziaException{
        try {
            if (getQtd() > 0) {
                Integer salvarDado = dados[inicio];
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

    public Integer visualizarProximo() throws FilaVaziaException{
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
