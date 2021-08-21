package com.cenfotec.sucondofeliz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/condominio"})
public class CondominoController {

    @Autowired
    private  condominioService;

}
