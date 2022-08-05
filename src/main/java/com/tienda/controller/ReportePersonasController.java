/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.enums.TipoReporteEnum;
import com.model.ReportePersonasDTO;
import com.tienda.service.api.ReportePersonasServiceAPI;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author rivil
 */
@RestController
@RequestMapping("/report")
public class ReportePersonasController {

	@Autowired
	private ReportePersonasServiceAPI reportePersonasServiceAPI;

	@GetMapping(path = "/personas/download")
	public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params)
			throws JRException, IOException, SQLException {
		ReportePersonasDTO dto = reportePersonasServiceAPI.obtenerReporte(params);

		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFilename()+ "\"")
				.contentLength(dto.getLenght()).contentType(mediaType).body(streamResource);
	}

}
