package com.uce.unidad3.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.unidad3.repository.ITransferenciaRepo;
import com.uce.unidad3.repository.modelo.CuentaBancaria;
import com.uce.unidad3.repository.modelo.Transferencia;



@Service
public class TransferenciaServiceImpl implements ITransferenciaService {
	
	private static Logger LOG =  LogManager.getLogger(TransferenciaServiceImpl.class);

	@Autowired
	private ITransferenciaRepo tranRepo ;

    @Autowired
    private ICuentaBancariaService cuentaBancariaService;

	
    @Override
    @Transactional(value = TxType.REQUIRES_NEW)
    public void realizarTransferencia(String ctaOrigen, String ctaDestino, BigDecimal monto) {

        
        CuentaBancaria cOrigen = this.cuentaBancariaService.buscarPorNumero(ctaOrigen);
        CuentaBancaria cDestino = this.cuentaBancariaService.buscarPorNumero(ctaDestino);
        
        cOrigen.setSaldo(cOrigen.getSaldo().subtract(monto));
        cDestino.setSaldo(cDestino.getSaldo().add(monto));


        this.cuentaBancariaService.actualizar(cOrigen);
        this.cuentaBancariaService.actualizar(cDestino);

        Transferencia t = new Transferencia();
        t.setCtaDestino(cDestino);
        t.setCtaOrigen(cOrigen);
        t.setFecha(LocalDateTime.now());
        t.setMonto(monto);

        this.tranRepo.insertar(t);
    //    if (ctaOrigen.getTipo.equals("Ahorros")) {
    //     throw new RuntimeException();
    //    }

        if(monto.compareTo(cOrigen.getSaldo().subtract(monto))>0){
            throw new RuntimeException();
        }


    }


    @Override
    @Transactional(value = TxType.REQUIRED)
    public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto) {
        this.realizarTransferencia(ctaOrigen, ctaDestino, monto);
        
    }


    @Override
    public Transferencia buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.tranRepo.buscar(id);
    }

}

