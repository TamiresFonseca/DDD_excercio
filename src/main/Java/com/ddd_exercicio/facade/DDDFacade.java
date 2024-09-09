package com.ddd_exercicio.facade;

import com.ddd_exercicio.application.DDDApplication;
import com.ddd_exercicio.entitites.DDDEstados;
import java.util.List;

public class DDDFacade {

    private DDDApplication dddApplication;

    public DDDFacade(DDDApplication dddApplication) {
        this.dddApplication = dddApplication;
    }

    public void adicionarEstado(int ddd, String nome, String imagem) {
        DDDEstados estado = new DDDEstados(ddd, nome, imagem);
        dddApplication.criarEstado(ddd, nome, imagem);
    }

    public void removerEstado(int ddd) {
        dddApplication.removerEstado(ddd);
    }

    public DDDEstados buscarPorDDD(int ddd) {
        return dddApplication.buscarPorDDD(ddd);
    }

    public List<DDDEstados> listarTodosEstados() {
        return dddApplication.listarEstados();

    public void atualizarEstado(int ddd, String nome, String imagem) {
        dddApplication.atualizarEstado(ddd, nome, imagem);
    }
}
