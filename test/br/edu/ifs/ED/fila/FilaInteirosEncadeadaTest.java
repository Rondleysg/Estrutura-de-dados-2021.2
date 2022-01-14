package br.edu.ifs.ED.fila;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.*;
public class FilaInteirosEncadeadaTest {

    protected FilaEncadeada<Integer> fila;
    @BeforeEach
    public void setUp() {
        fila = new FilaInteirosEncadeada();
    }


    @Test
    public void _0_5_incluir_UmElemento() throws FilaVaziaException {
        assertThat(fila.getQtd()).isEqualTo(0);
        fila.incluir(1);
        assertThat(fila.getQtd()).isEqualTo(1);
        assertThat(fila.remover()).isEqualTo(1);
    }

    @Test
    public void _0_5_incluir_MaisDeUmElemento() throws FilaVaziaException {
        for(int i = 0; i < 5; i++){
            fila.incluir(i);
        }
        assertThat(fila.getQtd()).isEqualTo(5);
        assertThat(fila.remover()).isEqualTo(0);
        int get_qtd = fila.getQtd();
        for(int i = 0; i < get_qtd; i++){
            assertThat(fila.remover()).isEqualTo(i+1);
        }
        assertThat(fila.getQtd()).isZero();
    }

    @Test
    public void _0_5_removerElementosAposFilaCheiaExceptionTest() throws FilaCheiaException, FilaVaziaException {    }

    @Test
    public void _0_5_lancarFilaCheiaException() throws FilaCheiaException, FilaVaziaException {    }

    @Test
    public void _0_5_incluirAposRemocaoElementosTest() throws FilaVaziaException {
        for(int i = 0; i < 10; i++){
            fila.incluir(i);
        }
        int get_qtd = fila.getQtd();

        for(int i = 0; i < 5; i++){
            fila.remover();
        }

        assertThat(fila.getQtd()).isEqualTo(5);
        assertThat(fila.visualizarProximo()).isEqualTo(5);

        for(int i = 0; i < 5; i++){
            fila.incluir(10+i);
        }

        assertThat(fila.getQtd()).isEqualTo(10);


        assertThat(fila.visualizarProximo()).isEqualTo(5);

        get_qtd = fila.getQtd();
        for(int i = 0; i < 5; i++){
            assertThat(fila.remover()).isEqualTo(i+5);
        }

        assertThat(fila.visualizarProximo()).isEqualTo(10);
        assertThat(fila.getQtd()).isEqualTo(5);

        for(int i = 0; i < 5; i++){
            assertThat(fila.remover()).isEqualTo(10+i);
        }
        assertThat(fila.getQtd()).isZero();
    }

    @Test
    public void _0_5_lancarFilaVaziaException() throws FilaVaziaException {
        fila.incluir(1);
        fila.remover();
        assertThatExceptionOfType(FilaVaziaException.class).isThrownBy(() -> fila.remover());
        assertThat(fila.estaVazia()).isTrue();
        assertThat(fila.getQtd()).isZero();
    }

    @Test
    public void _0_5_removerElementosTest() throws FilaVaziaException {
        for(int i =0; i < 5; i++){
            fila.incluir(i);
        }
        for(int i = 0; i < 5; i++) {
            assertThat(fila.remover()).isEqualTo(i);
        }
        assertThat(fila.getQtd()).isZero();
    }

    @Test
    public void _0_5_getQtd_FilaVaziaTest() {
        assertThat(fila.getQtd()).isEqualTo(0);
    }
    @Test
    public void _0_5_getQtd_FilaComItemTest(){
        fila.incluir(1);
        assertThat(fila.getQtd()).isEqualTo(1);
    }
    @Test
    public void _0_5_getQtd_FilaCheiaTest(){
        int x = fila.getQtdMaxSuportada();
        for (int i= 0; i< x; i++)
            fila.incluir(i);
        assertThat(fila.getQtd()).isEqualTo(x);
    }

    @Test
    public void _0_5_estaVazia_FilaVaziaTest() {
        assertThat(fila.estaVazia()).isTrue();
    }

    @Test
    public void _0_5_limpar_FilaComItensTest(){
        fila.incluir(1);
        fila.limpar();
        assertThat(fila.estaVazia()).isTrue();
        assertThat(fila.getQtd()).isZero();
    }

    @Test
    public void _0_5_limpar_FilaVazia() {
        fila.limpar();
        assertThat(fila.estaVazia()).isTrue();
        assertThat(fila.getQtd()).isZero();
    }

    @Test
    void verProxQuandoFilaVazia(){
        assertThatExceptionOfType(FilaVaziaException.class).isThrownBy(() -> fila.visualizarProximo());
    }
    @Test
    void _0_5_visualizarProximo() throws FilaVaziaException {
        for(int i = 0; i < 5; i++){
            fila.incluir(i);
        }
        assertThat(fila.getQtd()).isEqualTo(5);
        assertThat(fila.remover()).isEqualTo(0);
        assertThat(fila.visualizarProximo()).isEqualTo(1);
    }
    @Test
    void _4_0_aumentoCapacidadeTest()throws FilaVaziaException{
        int i=0;
        int qtd = fila.getQtdMaxSuportada();
        for (int j = 0;j<qtd+5; j++) {
            fila.incluir(j);
        }
        assertThat(fila.getQtd()).isEqualTo(qtd+5);
        for (int j = 0;j<qtd+5; j++) {
            assertThat(fila.remover()).isEqualTo(j);
        }
        assertThat(fila.getQtd()).isZero();
    }
    @Test
    void imprimirFila() throws FilaVaziaException{
        for (int i=0;i<50;i++){
            fila.incluir(i);
        }
        for (int i=0;i<50;i++){
            System.out.println(fila.remover());
        }
    }
}
