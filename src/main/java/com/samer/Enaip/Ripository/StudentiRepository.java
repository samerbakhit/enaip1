package com.samer.Enaip.Ripository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samer.Enaip.modelli.Studenti;

public interface StudentiRepository extends JpaRepository<Studenti,Long> {
long count();





}
