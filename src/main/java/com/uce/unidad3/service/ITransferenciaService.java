package com.uce.unidad3.service;

import java.math.BigDecimal;

public interface ITransferenciaService {

	public void realizarTransferencia(String ctaOrigen, String ctaDestino, BigDecimal monto);
	public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto);
}

