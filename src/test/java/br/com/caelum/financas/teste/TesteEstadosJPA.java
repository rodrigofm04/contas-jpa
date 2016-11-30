package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteEstadosJPA {

  public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		// Testes do capitulo
		Conta conta = manager.find(Conta.class, 179);
		conta.setTitular("Pedro Ferreira");
		System.out.println(conta.toString());

		manager.getTransaction().commit();

		manager.close();

	}
}