package com.keralty.integraciones.emailnotification.binarysent.file;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.FormParam;

public class AttachmentList {

    
	public List<Attachment> listaFicheros;
    
    public AttachmentList() {
    	listaFicheros = new ArrayList<Attachment>();
    }
}
