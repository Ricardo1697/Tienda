/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.api;

import com.model.ReportePersonasDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author rivil
 */

public interface ReportePersonasServiceAPI {
    
    ReportePersonasDTO obtenerReporte(Map<String,Object> params)throws JRException, IOException, SQLException;
    
}
