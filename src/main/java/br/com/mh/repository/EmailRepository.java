package br.com.mh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mh.entity.Email;

/**
 * EmailRepository
 */
public interface EmailRepository extends JpaRepository<Email, Long>{


}
