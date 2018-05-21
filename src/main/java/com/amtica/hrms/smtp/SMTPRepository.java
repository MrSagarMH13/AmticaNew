package com.amtica.hrms.smtp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SMTPRepository extends JpaRepository<Smtp, Integer> {

}
