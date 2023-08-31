package com.example.teste.service;


import com.example.teste.dto.CalculoDTO;
import com.example.teste.dto.EntradaDTO;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CalculaService {

    public CalculoDTO calcular (EntradaDTO entradaDTO){

        if (entradaDTO.getNumeros().size() < 5){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }else {
            CalculoDTO calculoDTO = new CalculoDTO();
            calculoDTO.setQtdNumeros(entradaDTO.getNumeros().size());
            calculoDTO.setMedia(this.media(entradaDTO));
            calculoDTO.setMediana(this.mediana(entradaDTO));
            calculoDTO.setDesvioPadrao(this.desvioPadrao(entradaDTO));
            calculoDTO.setSomaTotal(this.somatotal(entradaDTO));
            calculoDTO.setMaiorNumero(this.maiorNumero(entradaDTO));
            calculoDTO.setMenorNumero(this.menorNumero(entradaDTO));

            return calculoDTO;
        }
    }

    public double media (EntradaDTO entradaDTO){

        int soma = 0;

        for (int i = 0; i<entradaDTO.getNumeros().size(); i++){
            soma += entradaDTO.getNumeros().get(i);
        }

        return soma / entradaDTO.getNumeros().size();
    }

    public double somatotal(EntradaDTO entradaDTO){
        int soma = 0;

        for (int i = 0; i<entradaDTO.getNumeros().size(); i++){
            soma += entradaDTO.getNumeros().get(i);
        }

        return soma;
    }

    public double maiorNumero(EntradaDTO entradaDTO){
        int maiorNum = entradaDTO.getNumeros().get(0);

        for (int num: entradaDTO.getNumeros()){
            if (num > maiorNum) {
                maiorNum = num;
            }
        }
        return maiorNum;
    }

    public double menorNumero(EntradaDTO entradaDTO){
        int menorNum = entradaDTO.getNumeros().get(0);

        for (int num: entradaDTO.getNumeros()){
            if (num < menorNum){
                menorNum = num;
            }
        }
        return menorNum;
    }

    public double mediana (EntradaDTO entradaDTO){

        List<Integer> NumerosOrd = new ArrayList<>(entradaDTO.getNumeros());
        Collections.sort(NumerosOrd);

        if (entradaDTO.getNumeros().size() % 2 == 0){
            double posicaoDir = entradaDTO.getNumeros().size() / 2;
            double posicaoEsq = posicaoDir - 1;
            return (posicaoDir + posicaoEsq) / 2;
        }else{
            double result = entradaDTO.getNumeros().size() / 2;
            int posicao = (int) result;

            return entradaDTO.getNumeros().get(posicao);
        }
    }

    public double desvioPadrao (EntradaDTO entradaDTO){

        double soma = 0;

        for (int i = 0; i<entradaDTO.getNumeros().size(); i++){
            double aux = (entradaDTO.getNumeros().get(i) - this.media(entradaDTO));
            double resultado = aux * aux;
            soma += resultado;
        }

        double result = soma/entradaDTO.getNumeros().size();

        return Math.sqrt(result);
    }
}