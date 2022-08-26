package com.uce.unidad3.tareas.service.funcional;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExamenConsumerImpl implements IExamenConsumer<BigDecimal> {

    private static Logger LOG = LogManager.getLogger(ExamenConsumerImpl.class);

    @Override
    public void accept(BigDecimal arg1) {
        LOG.info(arg1  + "\t es de tipo " +arg1.getClass());
    }

}
