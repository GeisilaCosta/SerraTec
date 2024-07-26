package br.com.serratec.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta {
	private Integer status;
	private String titulo;
	private LocalDateTime dataHora;
	private String desc;
	private List<String> erros;
	
	public ErroResposta(Integer status, String titulo, LocalDate dataHoraTime, List<String> erros) {
		super();
		this.status = status;
		this.titulo = titulo;
		this.erros = erros;
	}
	
	public ErroResposta(Integer status, String desc, LocalDateTime dataHoraTime, String message, List<String> erros, String titulo) {
		super();
		this.status = status;
		this.titulo = titulo;
		this.erros = erros;
		this.dataHora = dataHoraTime;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public List<String> getErros() {
		return erros;
	}

	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
}
