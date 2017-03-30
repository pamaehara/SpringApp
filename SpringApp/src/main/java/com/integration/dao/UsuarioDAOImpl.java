package com.integration.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.integration.model.Usuario;

@Repository
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Usuario getUsuario(String nomeUsuario, String senha) {
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("nomeUsuario", nomeUsuario));
			criteria.add(Restrictions.eq("senha", senha));
			return (Usuario) criteria.uniqueResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void inserirUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().save(usuario);
	}

	@Override
	public void deletarUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().update(usuario);
	}

}
