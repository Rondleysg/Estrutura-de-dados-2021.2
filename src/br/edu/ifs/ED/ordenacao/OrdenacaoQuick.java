package br.edu.ifs.ED.ordenacao;
public class OrdenacaoQuick implements Ordenacao{
    static int[] dados= new int[10];
    static int qtd=0,aux=0,inicio,fim;
    public static void ordenar(boolean crescente, int[] dados, int inicio, int fim) {
        if (inicio < fim) {
            int posPivo = particionar(dados, inicio, fim);
            ordenar(true, dados, inicio, posPivo - 1);
            ordenar(true, dados, posPivo + 1, fim);
            if (dados[fim - 1] > dados[fim]) {
                trocar(dados, fim - 1, fim);
            }
        }
        if (crescente == false) {
            int i = 0, j = 0;
            for (int k=0;k<fim/2;k++){
                trocar(dados, inicio + i, fim - j);
                i++;
                j++;
            }
        }
    }
    private static int particionar(int[] dados, int inicio, int fim){
       inicio=inicio;
        fim=fim;
        int i=inicio-1;
        int r=fim;
        int j=inicio;
            for(j=inicio;j<r;j++){
                if (dados[j] < dados[r]) {
                    i++;
                    trocar(dados,i,j);
                }
            }
            trocar(dados,i+1, r);
        return r;
    }
    public static void adicionar(int dado) {
            if(qtd<dados.length){
            dados[qtd++] = dado;
            }
    }
    public static void trocar(int[] dados, int a, int b){
        int temp=dados[a];
        dados[a]=dados[b];
        dados[b]=temp;
    }
    public int[] obterDados() {
        return  this.dados;
    }
    public static void mostrarOrdem(int[] dados){
        for(int i=0;i< dados.length;i++){
            if (i+1!= dados.length) {
                System.out.print(dados[i] + " ");
            }else{
                System.out.println(dados[i] + " ");
            }
        }
}
}

