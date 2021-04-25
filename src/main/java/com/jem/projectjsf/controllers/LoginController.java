/**
 * 
 */
package com.jem.projectjsf.controllers;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author JEM Clase que permite controlar el funcionamiento con la pantalla de
 *         login.xhml
 */
@ManagedBean
public class LoginController {

	/**
	 * Usuario que ingresan en el login
	 */
	private String usuario;

	/**
	 * contraseña ingresada en el login
	 */
	private String password;

	/**
	 * 
	 * Metodo que permite ingresar a la pantalla principal del proyecto
	 */
	public void ingresar() {
		System.out.println("Usuario: " + usuario);

		if (usuario.equals("jem") && password.equals("12345")) {
			/*FacesContext.getCurrentInstance().addMessage("formLogin:txtUsuario",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Correcto", "test"));*/
			try {
				this.redireccionar("principal.xhtml");
			} catch (IOException e) {
				FacesContext.getCurrentInstance().addMessage("formLogin:txtUsuario",
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "La página no existe.", ""));
				e.printStackTrace();
			}
		} else {
			FacesContext.getCurrentInstance().addMessage("formLogin:txtUsuario",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o Password Incorrecto", "testE"));
		}
	}
	
	
	private void redireccionar(String pagina) throws IOException {
		ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(pagina);
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
