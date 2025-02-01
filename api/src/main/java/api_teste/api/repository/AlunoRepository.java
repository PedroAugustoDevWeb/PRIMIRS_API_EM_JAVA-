package api_teste.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api_teste.api.models.Alunos;

public interface AlunoRepository extends JpaRepository<Alunos, Long> {

    
}
