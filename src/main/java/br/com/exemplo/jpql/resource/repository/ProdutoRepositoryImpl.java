package br.com.exemplo.jpql.resource.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("ProdutoRepository")
public class ProdutoRepositoryImpl implements ProdutoRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public String list() {
		final String sql = "select p.id, p.descricao, p.paginas, p.sumarioPath, p.titulo from produto as p";
		final Query q = em.createNativeQuery(sql);
		List<Object[]> l = q.getResultList();
		
		return l.get(0)[4].toString();
	}

}
