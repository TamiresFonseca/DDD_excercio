package com.ddd_exercicio.application;

import com.ddd_exercicio.entitites.DDDEstados;
import com.ddd_exercicio.repositories.DDDRepository;
import com.ddd_exercicio.services.DDDService;

import java.util.List;

public class DDDApplication {

    private DDDRepository dddRepository;
    private DDDService dddService;


    public DDDApplication(DDDRepository dddRepository, DDDService dddService) {
        this.dddRepository = dddRepository;
        this.dddService = dddService;
    }


    public void criarEstado(int ddd, String nome, String imagem) {
        DDDEstados estado = new DDDEstados(ddd, nome, imagem);
        dddRepository.adicionarEstado(estado);
    }


    public void atualizarEstado(int ddd, String nome, String imagem) {
        DDDEstados novoEstado = new DDDEstados(ddd, nome, imagem);
        dddRepository.atualizarEstado(ddd, novoEstado);
    }


    public List<DDDEstados> listarEstados() {
        return dddRepository.listarEstados();
    }


    public DDDEstados buscarPorDDD(int ddd) {
        return dddRepository.buscarPorDDD(ddd);
    }


    public void removerEstado(int ddd) {
        dddRepository.removerEstado(ddd);
    }
}
