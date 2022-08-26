package com.uce.unidad3.tareas.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.unidad3.tareas.repository.IFacturaElectronicaRepo;
import com.uce.unidad3.tareas.repository.modelo.FacturaElectronica;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService {

    @Autowired
    private IFacturaElectronicaRepo faElectronicaRepo;

    // C
    // Como tabla independiente significa que es una entidad sin un relacionamiento
    // y no simplemente un DTO
    // por tanto se inserta como tal
    
    @Override
    @Transactional(value = TxType.REQUIRES_NEW)
    public void crearFacturaElectronica(String numeroFact, BigDecimal monto, Integer items) {
        FacturaElectronica facturaElectronica = new FacturaElectronica();
        facturaElectronica.setFechaCreacion(LocalDateTime.now());
        facturaElectronica.setMonto(monto);
        facturaElectronica.setNumItems(items);
        facturaElectronica.setNumero(numeroFact);

        this.faElectronicaRepo.insertar(facturaElectronica);

        throw new RuntimeException();

    }

}
