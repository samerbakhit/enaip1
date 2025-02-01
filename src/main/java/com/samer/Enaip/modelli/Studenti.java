package com.samer.Enaip.modelli;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="studenti")
public class Studenti {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long matricola;
	
	 @NotBlank(message = "Il nome dello studente è obbligatorio")
	private String nome;
	 
	 @NotBlank(message = "Il cognome dello studente è obbligatorio")
	private String cognome;
	 
	 @NotBlank(message = "Il cell è obbligatorio")
	private String cell;
	 @NotBlank(message = "l'email è obbligatorio")
	 @Email
	 
	private String email;
	
//	@PrePersist
//	private void generateMatricola() {
//		int i=1;
//	    if (this.matricola == 0) {
//	        this.matricola = 80001 + i++ ; // Id deve essere già stato settato
//	
//	    }
//	}

	

	public Long getMatricola() {
		return matricola;
	}
	public void setMatricola(Long matricola) {
		this.matricola = matricola;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Studenti(Long matricola, String nome, String cognome, String cell, String email) {
		super();
		
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.cell = cell;
		this.email = email;
	}
	public Studenti() {
		super();
	}
	@Override
	public String toString() {
		return "Studenti [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", cell="
				+ cell + ", email=" + email + "]";
	}
	public Studenti(String nome, String cognome, String cell, String email) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.cell = cell;
		this.email = email;
	}

	
	

}
