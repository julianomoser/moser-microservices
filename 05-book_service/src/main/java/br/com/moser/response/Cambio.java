package br.com.moser.response;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Juliano Moser
 */
public class Cambio implements Serializable {

    private static final long serialVersionUID = 1;

    private Long id;
    private String from;
    private String to;
    private Double conversionFactor;
    private Double converterValue;
    private String environment;

    public Cambio() {
    }

    public Cambio(Long id, String from, String to, Double conversionFactor, Double converterValue, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.converterValue = converterValue;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Double getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public Double getConverterValue() {
        return converterValue;
    }

    public void setConverterValue(Double converterValue) {
        this.converterValue = converterValue;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cambio cambio = (Cambio) o;
        return Objects.equals(id, cambio.id) && Objects.equals(from, cambio.from) && Objects.equals(to, cambio.to) && Objects.equals(conversionFactor, cambio.conversionFactor) && Objects.equals(converterValue, cambio.converterValue) && Objects.equals(environment, cambio.environment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, conversionFactor, converterValue, environment);
    }
}
