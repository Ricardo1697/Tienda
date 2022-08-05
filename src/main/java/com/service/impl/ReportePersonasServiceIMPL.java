/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.commons.JasperReportManager;
import com.enums.TipoReporteEnum;
import com.model.ReportePersonasDTO;
import com.service.api.ReportePersonasServiceAPI;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author rivil
 */
@Service
public class ReportePersonasServiceIMPL implements ReportePersonasServiceAPI {
    @Autowired
    private JasperReportManager reportManager;
    
    @Autowired
    private DataSource dataSource;
    
    
    @Override
    public ReportePersonasDTO obtenerReporte(Map<String, Object> params) 
            throws JRException, IOException,SQLException{
        String fileName = "reporte_de_personas";
		ReportePersonasDTO dto = new ReportePersonasDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFilename(fileName + extension);

		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLenght(bs.length);

		return dto;
    }
}
