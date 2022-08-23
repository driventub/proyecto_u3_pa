package com.uce.unidad3.service.funcional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class PersonaConsumerImpl implements IPersonaConsumer<String>{

    private static Logger LOG = LogManager.getLogger(MainInterfacesFuncionales.class);

    @Override
    public void accept(String arg1) {
        LOG.info(arg1);
        
    }

    
}
