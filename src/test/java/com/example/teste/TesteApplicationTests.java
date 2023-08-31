package com.example.teste;


import com.example.teste.dto.EntradaDTO;
import com.example.teste.service.CalculaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TesteApplicationTests {

	@Autowired
	private CalculaService calculaService;

	@Test
	public void testeMedia(){
		EntradaDTO entradaDTO = new EntradaDTO();
		entradaDTO.setNumeros(List.of(9,6,2,5,4));
		double media = calculaService.media(entradaDTO);
		Assertions.assertEquals(5.0, media);
	}

	@Test
	public void testeMaior(){
		EntradaDTO entradaDTO = new EntradaDTO();
		entradaDTO.setNumeros(List.of(9,6,2,5,4));
		double maior = calculaService.maiorNumero(entradaDTO);
		Assertions.assertEquals(9.0,maior);
	}

	@Test
	public void testeMenor(){
		EntradaDTO entradaDTO = new EntradaDTO();
		entradaDTO.setNumeros(List.of(9,6,2,5,4));
		double menor = calculaService.menorNumero(entradaDTO);
		Assertions.assertEquals(2.0,menor);
	}

	@Test
	public void testeSoma(){
		EntradaDTO entradaDTO = new EntradaDTO();
		entradaDTO.setNumeros(List.of(9,6,2,5,4));
		double soma = calculaService.somatotal(entradaDTO);
		Assertions.assertEquals(26.0, soma);
	}


	@Test
	public void testeMediana(){
		EntradaDTO entradaDTO = new EntradaDTO();
		entradaDTO.setNumeros(List.of(9,6,2,5,4));
		double mediana = calculaService.mediana(entradaDTO);
		Assertions.assertEquals(2.0,mediana);
	}



	@Test
	public void  testeDesvio(){
		EntradaDTO entradaDTO = new EntradaDTO();
		entradaDTO.setNumeros(List.of(9,6,2,5,4));
		double desvio = calculaService.desvioPadrao(entradaDTO);
		Assertions.assertEquals(2.32379000772445, desvio);
	}

}