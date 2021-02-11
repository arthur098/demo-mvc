package com.arthur.curso.boot.util;

import java.util.List;

public class PaginationUtil<T> {

	private int tamanho;
	private int pagina;
	private long totalPaginas;
	private List<T> list;
	private String direcao;
	private String field;
	
	public PaginationUtil(int tamanho, int pagina, long totalPaginas, List<T> list) {
		super();
		this.tamanho = tamanho;
		this.pagina = pagina;
		this.totalPaginas = totalPaginas;
		this.list = list;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public int getPagina() {
		return pagina;
	}
	
	public long getTotalPaginas() {
		return totalPaginas;
	}
	
	public List<T> getList() {
		return list;
	}

	public String getDirecao() {
		return direcao;
	}

	public String getField() {
		return field;
	}
}
