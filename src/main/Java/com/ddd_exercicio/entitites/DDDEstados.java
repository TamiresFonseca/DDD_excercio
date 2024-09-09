package com.ddd_exercicio.entitites;



    public class DDDEstados {

        private int ddd;
        private String nome;
        private String caminhoImagem;

        // Construtor completo
        public DDDEstados(int ddd, String nome, String caminhoImagem) {
            this.ddd = ddd;
            this.nome = nome;
            this.caminhoImagem = caminhoImagem;
        }

        // Getter e setter para o DDD
        public int getDdd() {
            return ddd;
        }

        public void setDdd(int ddd) {
            this.ddd = ddd;
        }

        // Getter e setter para o nome do estado
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        // Getter e setter para o caminho da imagem
        public String getCaminhoImagem() {
            return caminhoImagem;
        }

        public void setCaminhoImagem(String caminhoImagem) {
            this.caminhoImagem = caminhoImagem;
        }
    }


