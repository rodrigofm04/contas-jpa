package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaConsulta {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(2);

		Query query = em.createQuery("select m from Movimentacao m where m.conta=:pConta");
		query.setParameter("pConta", conta);

/*		Query query = em.createQuery("select m from Movimentacao m where m.tipoMovimentacao=:pTipo");
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
*/

/*		Query query = em.createQuery("select m from Movimentacao m where m.conta.titular like :pTitular and m.tipoMovimentacao=:pTipo");
		query.setParameter("pTitular", "Maria%");
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
*/
		List<Movimentacao> movimentacoes = query.getResultList();

		movimentacoes.forEach(mov->System.out.println(mov.toString()));

	}
}
