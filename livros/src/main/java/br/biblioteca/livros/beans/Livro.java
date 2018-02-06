package br.biblioteca.livros.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message = "Nome não pode ser vazio")
	@Size(min = 2, max = 100)
	private String nome;
	
	@NotNull(message = "Quantidade de paginas não pode ser vazio")
	@Min(value = 10, message = "valor mínimo é 10 páginas")
	@Column(name = "QUANTIDADE_PAGINAS")
	private Long quantidadePaginas;

	private String capa;
	
	private Long quantidade;
	
	private String isbn;
	
	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	private Autor autor;
	
	@OneToMany(mappedBy="livro")
	private List<Review> reviews = new ArrayList<>();
	
	@OneToMany(mappedBy="livro")
	private List<Emprestimo> emprestimos = new ArrayList<>();
		
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Long getQuantidadePaginas() {
		return quantidadePaginas;
	}

	public void setQuantidadePaginas(Long quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}
	
	

}
