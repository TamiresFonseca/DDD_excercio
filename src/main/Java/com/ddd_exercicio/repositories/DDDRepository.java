package com.ddd_exercicio.repositories;

import com.ddd_exercicio.entitites.DDDEstados;

import java.util.ArrayList;
import java.util.List;

public class DDDRepository {

    private List<DDDEstados> estados;

    public DDDRepository() {
        this.estados = new ArrayList<>();
    }


    public void adicionarEstado(DDDEstados estado) {
        estados.add(estado);
    }


    public void atualizarEstado(int ddd, DDDEstados novoEstado) {
        for (DDDEstados estado : estados) {
            if (estado.getDdd() == ddd) {
                estado.setNome(novoEstado.getNome());
                estado.setCaminhoImagem(novoEstado.getCaminhoImagem());
                break;
            }
        }
    }


    public List<DDDEstados> listarEstados() {
        return new ArrayList<>(estados);
    }


    public DDDEstados buscarPorDDD(int ddd) {
        for (DDDEstados estado : estados) {
            if (estado.getDdd() == ddd) {
                return estado;
            }
        }
        return null;
    }

    public void removerEstado(int ddd) {
        estados.removeIf(estado -> estado.getDdd() == ddd);
    }
}
