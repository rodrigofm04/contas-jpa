package br.com.caelum.financas.teste;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class ContaTest {

	@Test
	public void insereContaNoBanco() {
		Conta conta = new Conta();
		conta.setTitular("Rodrigo Melo");
		conta.setBanco("Itau");
		conta.setAgencia("013");
		conta.setNumero("5561");

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
		em.close();

	}

	@Test
	public void buscaContaNoBanco() {
		EntityManager em = new JPAUtil().getEntityManager();
		Conta conta = em.find(Conta.class, 169);
		assertEquals("Jose dos Santos", conta.getTitular());
	}

}
