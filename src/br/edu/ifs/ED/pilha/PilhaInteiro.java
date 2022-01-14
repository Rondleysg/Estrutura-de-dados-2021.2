package br.edu.ifs.ED.pilha;
public class PilhaInteiro extends PilhaSequencial<Integer>{

    public PilhaInteiro() {
        super(Integer.class);
    }

    @Override
    public void empilhar(Integer valor) throws PilhaCheiaException {
        super.empilhar(valor);
    }

    @Override
    public Integer desempilhar() throws PilhaVaziaException {
        return super.desempilhar();
    }

    @Override
    public Integer getTopo() throws PilhaVaziaException {
        return super.getTopo();
    }

    @Override
    public int getQtd() {
        return super.getQtd();
    }

    @Override
    public boolean estahVazia() {
        return super.estahVazia();
    }
}
