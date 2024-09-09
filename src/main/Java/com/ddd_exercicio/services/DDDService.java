package com.ddd_exercicio.services;

import com.ddd_exercicio.entitites.DDDEstados;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DDDService {

        private String caminhoDestino = "C:\\Users\\aluno\\LancheNLayer\\src\\main\\resources\\images\\";


        public static String getFileExtension(String filePath) {
            String fileName = new File(filePath).getName();
            int dotIndex = fileName.lastIndexOf('.');
            return (dotIndex == -1) ? "No extension" : fileName.substring(dotIndex + 1);
        }


        public boolean salvarImagem(DDDEstados estado) {
            Path caminhoOrigem = Paths.get(estado.getCaminhoImagem());
            Path caminhoDestino = Paths.get(String.format("%s%d.%s", this.caminhoDestino, estado.getDdd(), getFileExtension(estado.getCaminhoImagem())));

            if (Files.exists(caminhoOrigem)) {
                try {
                    Files.copy(caminhoOrigem, caminhoDestino, StandardCopyOption.REPLACE_EXISTING);
                    estado.setCaminhoImagem(caminhoDestino.getFileName().toString());
                    return true;
                } catch (Exception ex) {
                    System.out.println("Erro ao copiar imagem: " + ex.getMessage());
                    return false;
                }
            } else {
                System.out.println("Arquivo de imagem não encontrado.");
                return false;
            }
        }


        private String buscarCaminhoArquivoPorId(int ddd) {
            File diretorio = new File(caminhoDestino);
            File[] matches = diretorio.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.startsWith(String.valueOf(ddd));
                }
            });

            if (matches != null && matches.length > 0) {
                return matches[0].getAbsolutePath();
            }
            return null;
        }


        public void removerImagem(int ddd) {
            String caminhoArquivo = buscarCaminhoArquivoPorId(ddd);
            if (caminhoArquivo != null) {
                Path path = Paths.get(caminhoArquivo);
                try {
                    Files.deleteIfExists(path);
                } catch (IOException e) {
                    throw new RuntimeException("Erro ao remover a imagem: " + e.getMessage());
                }
            } else {
                System.out.println("Imagem não encontrada para o DDD: " + ddd);
            }
        }


        public void atualizarImagem(DDDEstados estado) {
            removerImagem(estado.getDdd());  // Remove a imagem antiga
            salvarImagem(estado);  // Salva a nova imagem
        }
    }




