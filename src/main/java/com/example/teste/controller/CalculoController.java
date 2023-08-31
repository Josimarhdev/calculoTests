package com.example.teste.controller;



import com.example.teste.dto.EntradaDTO;
import com.example.teste.service.CalculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("api/calculo")
public class CalculoController {
    @Autowired
    private CalculaService calculaService;

    @PostMapping ("/calcular")
    private ResponseEntity <?> calcular (@RequestBody EntradaDTO entradaDTO) {
        return ResponseEntity.ok(calculaService.calcular(entradaDTO));
    }


}
