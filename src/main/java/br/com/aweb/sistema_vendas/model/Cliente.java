package br.com.aweb.sistema_vendas.model;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode ser vazio.")
    private String nome;

    @NotBlank(message = "Email não pode ser vazio.")
    @Email(message = "O email deve ser válido.")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "CPF não pode ser vazio.")
    @CPF(message = "O CPF inválido")
    @Column(unique = true)
    private String cpf;

    @NotBlank(message = "O telefone não pode ser vazio.")
    private String telefone;

    @NotBlank(message = "Logradouro não pode ser vazio.")
    private String logradouro;

    private String numero;

    private String complemento;

    @NotBlank(message = "Bairro não pode ser vazio.")
    private String bairro;

    @NotBlank(message = "Cidade não pode ser vazia.")
    private String cidade;

    @NotBlank(message = "UF não pode ser vazia.")
    private String uf;

    @NotBlank(message = "CEP não pode ser vazio.")
    private String cep;
}
