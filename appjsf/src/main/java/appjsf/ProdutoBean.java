package appjsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class ProdutoBean {

	private Produto produto;
	private static List<Produto> lista;
	private DataModel<Produto> produtos;
	
	@PostConstruct
	public void init() {
		lista = new ArrayList<Produto>();
		lista.add(new Produto("Iphone", 9000.0));
		lista.add(new Produto("Xiaomi", 2300.0));
	}
	
	
	// Actions
	public String adicionaForm() {
		produto = new Produto();
		return "produto_form";
	}
	
	public String excluirProduto() {
		Produto p = (Produto) (produtos.getRowData());
		lista.remove(p);
		return "home";
	}
		
	public String listarProdutos() {
		return "home";
	}
	
	public String salvarProduto() {
		lista.add(produto);
		return "home";
	}
	
	public String editarProduto() {
		produto = (Produto) (produtos.getRowData());
		return "produto_form2";
	}
	
	public String store() {
		return "home";
	}
	
	
	
	
	// Gets & Sets

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public DataModel<Produto> getProdutos() {
				
		produtos = new ListDataModel<Produto>(lista);
		return produtos;
	}

	public void setProdutos(DataModel<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
}
