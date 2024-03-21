package br.com.springboot.bo;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.springboot.BO.ClienteBO;
import br.com.springboot.models.Cliente;
import br.com.springboot.models.Sexo;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class ClienteBOTest {
	
	@Autowired
	private ClienteBO bo;
	
	@Test
	@Order(1)
	public void insert() {
		Cliente cliente = new Cliente();
		cliente.setNome("José");
		cliente.setCpf("01234567890");
		cliente.setDataDeNascimento(LocalDate.of(2000, 1, 8));
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setTelefone("0123456789");
		cliente.setCelular("01234567890");
		cliente.setEmail("jose@gmail.com");
		cliente.setAtivo(true);
		bo.insere(cliente);
	}

	@Test
	@Order(2)
	public void pesquisaPorId() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		System.out.println(cliente);
	}
	
	@Test
	@Order(3)
	public void atualiza() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		if (cliente != null) {
	        cliente.setCpf("09876543210");
	        bo.atualiza(cliente);
	    } else {
	        System.out.println("Cliente não encontrado.");
	    }
	}
}
