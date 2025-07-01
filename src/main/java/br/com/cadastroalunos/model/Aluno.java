package br.com.cadastroalunos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aluno")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "idade", nullable = false)
    private int idade;

    @Column(name = "nome_responsavel", length = 100, nullable = false)
    private String nomeResponsavel;

    @Column(name = "turma", length = 10, nullable = false)
    private String turma;

}
