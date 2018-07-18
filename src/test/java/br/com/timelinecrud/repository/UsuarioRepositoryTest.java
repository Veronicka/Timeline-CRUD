package br.com.timelinecrud.repository;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.timelinecrud.model.Usuario;
import br.com.timelinecrud.repository.UsuarioRepository;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class UsuarioRepositoryTest extends TestCase{
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	private ArrayList<Usuario> list;
	
	@Test
	public void testFindAll() throws Exception{
		list = (ArrayList<Usuario>) usuarioRepo.findAll();
		Usuario p = (Usuario) list.get(0);
		Assert.assertEquals("jose", p.getNome());
	}
//	@Test
//	public void testGetById() throws Exception{
//		Assert.assertEquals("jose", usuarioRepo.findById(3L).getNome());
//	}
//	@Test
//	public void testGetByName() throws Exception{
//		Assert.assertEquals("jose", usuarioRepo.findByNome("jose").getNome());
//	}
//	@Test
//	public void testGetByNames() throws Exception{
//		list = (ArrayList<Usuario>) usuarioRepo.listaUsuariosNome("jose");
//		Usuario p = (Usuario) list.get(0);
//		Assert.assertEquals("mesa", p.getNome());
//	}
//	@Test
//	public void testGetByIds() throws Exception{
//		list = (ArrayList<Usuario>) usuarioRepo.findUsuarioById(2l);
//		Usuario p = (Usuario) list.get(0);
//		Assert.assertEquals("mesa", p.getNome());
//	}
//	
//	@Test
//	public void testSave() throws Exception{
//		Usuario p = new Usuario("jose", "1234", "jose@email.com", "(12)9999-9999", Calendar.getInstance());
//		Integer antes = (int) usuarioRepo.count();
//		usuarioRepo.save(usuarioRepo.save(p));
//		assertEquals(antes + 1, usuarioRepo.count());
//		Assert.assertEquals("violao", p.getNome().toString());
//	}
//
//	@Test
//	public void testDelete() throws Exception{
//		Usuario p = usuarioRepo.findByNome("jose");
//		Integer antes = (int) usuarioRepo.count();
//		usuarioRepo.delete(p.getId());
//		assertEquals(antes - 1, usuarioRepo.count());
//	}
	
	public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}
	

}
