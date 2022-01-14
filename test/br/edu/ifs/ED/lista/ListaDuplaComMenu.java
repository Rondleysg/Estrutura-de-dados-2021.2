package br.edu.ifs.ED.lista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ListaDuplaComMenu {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Lista<Integer> lista = new ListaDupEnc<>();
        int op;
        try {
            do {
                menu();
                op = scan.nextInt();
                try {

                    switch (op) {
                        case 1: {
                            System.out.print("Digite um numero: ");
                            int elemento = scan.nextInt();
                            lista.incluir(elemento);
                            break;
                        }
                        case 2: {
                            System.out.println("Digite um numero: ");
                            int elemento = scan.nextInt();
                            lista.incluirInicio(elemento);
                            break;
                        }
                        case 3: {
                            System.out.print("Informe o elemento");
                            int elemento = scan.nextInt();
                            System.out.print("Informe a posição");
                            int posicao = scan.nextInt();
                            lista.incluir(elemento, posicao);
                            break;
                        }
                        case 4: {
                            System.out.print("Informa a posição que deseja :");
                            int posicao = scan.nextInt();
                            System.out.println(lista.get(posicao));
                            break;
                        }
                        case 5: {
                            System.out.print("Informa o elemento que deseja :");
                            int elemento = scan.nextInt();
                            System.out.println(lista.getPosElemento(elemento));
                            break;
                        }
                        case 6: {
                            System.out.print("Informa a posição que deseja remover :");
                            int posicao = scan.nextInt();
                            lista.remover(posicao);
                            break;
                        }
                        case 7: {
                            lista.limpar();
                            break;
                        }
                        case 8: {
                            System.out.println("Tamanho: " + lista.getTamanho());
                            break;
                        }
                        case 9: {
                            System.out.print("Informa o elemento que deseja procurar :");
                            int elemento = scan.nextInt();
                            System.out.println(lista.contem(elemento));
                            break;
                        }
                        case 10: {
                            //lista.impimir();
                            System.out.println(lista.toString());
                            break;
                        }
                        case 11: {
                            System.out.println(lista.checkList());
                            break;
                        }
                        case 0: {
                            break;
                        }
                        default:
                            System.out.println("Opçăo inválida!");
                    }


                } catch (Exception erro) {
                    System.out.println(erro.getMessage());
                }
            } while (op != 0);

            scan.close();
        }
        catch (InputMismatchException e){
            System.out.println("Valor inválido.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void menu() {
        System.out.println();
        System.out.println("1 – Inserir elemento");
        System.out.println("2 - Inserir no inicio");
        System.out.println("3 - Inserir elemento na posição");
        System.out.println("4 - buscar elemento da posição");
        System.out.println("5 - buscar posicao do elemento");
        System.out.println("6 - remover posicao");
        System.out.println("7 - Limpar lista");
        System.out.println("8 - Tamanho da lista");
        System.out.println("9 - Verificar se contém elemento na lista");
        System.out.println("10 – Mostrar lista");
        System.out.println("11 – Checar lista");

        System.out.println("0 - Sair");

    }
}
