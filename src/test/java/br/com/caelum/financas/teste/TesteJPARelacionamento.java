package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {


	public static void main(String[] args) {

/*		Conta conta = new Conta();
		conta.setTitular("Carlos");
		conta.setBanco("Bradesco");
		conta.setNumero("3772");
		conta.setAgencia("999");
*/
/*		Conta conta = new Conta();
		conta.setId(188);
		conta.setBanco("Banco do Brasil");
		conta.setNumero("2222");
		conta.setAgencia("111");
*/
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 185);
		em.persist(conta);

		em.getTransaction().commit();
		em.close();
	}
}
