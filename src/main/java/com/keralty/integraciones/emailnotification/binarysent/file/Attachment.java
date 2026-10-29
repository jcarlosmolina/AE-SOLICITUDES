package com.keralty.integraciones.emailnotification.binarysent.file;

import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import jakarta.ws.rs.FormParam;

public class Attachment {

    //@FormParam("file")
    @PartType("application/octet-stream")
    public byte[] contenido;

//    @FormParam("filename")
//    @PartType("text/plain")
//    public String nombre;
    
    public Attachment( byte[] contenido) {
    	//this.nombre = nombre;
    	this.contenido = contenido;
    }
}
