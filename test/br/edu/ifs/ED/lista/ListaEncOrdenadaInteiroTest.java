package br.edu.ifs.ED.lista;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ListaEncOrdenadaInteiroTest extends ListaEncOrdenadaBateriaTeste {
        @BeforeEach
        public void setUp() {
            lista = new ListaEncOrdenada<Integer>();
        }
}