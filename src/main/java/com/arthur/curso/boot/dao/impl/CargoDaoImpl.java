package com.arthur.curso.boot.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.arthur.curso.boot.dao.AbstractDao;
import com.arthur.curso.boot.dao.CargoDao;
import com.arthur.curso.boot.domain.Cargo;
import com.arthur.curso.boot.util.PaginationUtil;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {

	@Override
	public PaginationUtil<Cargo> buscaPaginada(int pagina, int tamanho) {
		int inicio = (pagina - 1) * tamanho;
		List<Cargo> cargos = this.getEntityManager()
				.createQuery("SELECT c FROM Cargo c ORDER BY c.nome ASC", Cargo.class)
				.setFirstResult(inicio)
				.setMaxResults(tamanho)
				.getResultList();
		return new PaginationUtil<>(tamanho, pagina, getTotalPaginas(tamanho), cargos);
	}
	
	@Override
	public PaginationUtil<Cargo> buscaPaginadaPorNome(int pagina, String nome, int tamanho) {
		int inicio = (pagina - 1) * tamanho;
		List<Cargo> cargos = this.getEntityManager()
				.createQuery("SELECT c FROM Cargo c WHERE c.nome LIKE CONCAT('%', :nome, '%') ORDER BY c.nome ASC", Cargo.class)
				.setParameter("nome", nome)
				.setFirstResult(inicio)
				.setMaxResults(tamanho)
				.getResultList();
		return new PaginationUtil<>(tamanho, pagina, getTotalPaginasPorNome(tamanho, nome), cargos);
	}
	
	private long getTotalPaginas(double tamanho) {
		double maxResults = (double) this.createQuery("SELECT c FROM Cargo c").size();
		
		return (long) Math.ceil((maxResults / tamanho));
	}
	
	private long getTotalPaginasPorNome(double tamanho, String nome) {
		double maxResults = (double) this.createQuery("SELECT c FROM Cargo c WHERE c.nome like concat('%', ?1, '%')", nome).size();
		return (long) Math.ceil((maxResults / tamanho));
	}
}
