package br.com.moser.controller;

import br.com.moser.model.Cambio;
import br.com.moser.repository.CambioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Juliano Moser
 */
@Tag(name = "Cambio Service API")
@RestController
@RequestMapping("cambio-service")
public class CambioController {

    private Logger logger = LoggerFactory.getLogger(CambioController.class);
    @Autowired
    private Environment environment;
    @Autowired
    private CambioRepository cambioRepository;

    @Operation(description = "Get cambio from currency")
    @GetMapping(value = "/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable("amount")BigDecimal amount,
                            @PathVariable("from")String from,
                            @PathVariable("to")String to) {

        logger.info("getCambio is called whit -> {}, {} and {}", amount, from, to);
        var cambio = cambioRepository.findByFromAndTo(from, to);
        if(cambio == null) throw new RuntimeException("Currency Unsupported");
        var port = environment.getProperty("local.server.port");
        BigDecimal conversionFactory = cambio.getConversionFactor();
        BigDecimal converterValue = conversionFactory.multiply(amount);
        cambio.setConverterValue(converterValue.setScale(2, RoundingMode.CEILING));
        cambio.setEnvironment(port);
        return cambio;
    }
}
