package br.com.yukita.liggaProject.controller;

import br.com.yukita.liggaProject.dto.BoredApiResponse;
import br.com.yukita.liggaProject.entity.Activity;
import br.com.yukita.liggaProject.service.BoredService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BoredController {

    private final BoredService boredService;

    public BoredController(BoredService boredService) {
        this.boredService = boredService;
    }

    @GetMapping("/gerarAtividade")
    public BoredApiResponse gerarAtividade(String valor) {
        return boredService.getResponseFromApi();
    }

    @GetMapping("/listar")
    public List<Activity> buscarHistorico(@RequestParam(required = false) Map<String, String> filtros) {
        return boredService.listAll(filtros);
    }

}
