package com.DesafioPP.Repository;

import com.DesafioPP.Domain.TransacaoClasse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<TransacaoClasse, Long> {
}
