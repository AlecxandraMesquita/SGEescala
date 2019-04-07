package br.com.sgeescala.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import org.eclipse.persistence.internal.jpa.metamodel.proxy.ListAttributeProxyImpl;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.omg.PortableInterceptor.Interceptor;

import br.com.sgeescala.factory.JPAFactory;
import br.com.sgeescala.model.CorEquipes;
import br.com.sgeescala.model.Escala;
import br.com.sgeescala.model.Evento;
import br.com.sgeescala.model.TipoEvento;
import br.com.sgeescala.model.TurmaVoluntario;
import br.com.sgeescala.model.Voluntario;
import br.com.sgeescala.repository.CorEquipesRepository;
import br.com.sgeescala.repository.EscalaRepository;
import br.com.sgeescala.repository.EventoRepository;
import br.com.sgeescala.repository.TurmaVoluntarioRepository;
import br.com.sgeescala.validation.EscalaValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class EscalaController extends Controller<Escala>{

	private List<Escala> listaEscala;
//	private List<TurmaVoluntario> listaTurma;
	private List<Evento> listaEvento;
	private List<CorEquipes> listaCor;
	private Date inicio;
	private Date fim;
	private CorEquipes cor;
	private Voluntario voluntario;

	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}
	
	@Override
	public Escala getEntity() {
		if(entity == null) {
			entity = new Escala();
			
			entity.setVoluntario(new Voluntario());
		}
		return entity;	
	}
	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaEscala(null);
	}

	@Override
	public Validation<Escala> getValidation() {
		// TODO Auto-generated method stub
		return new EscalaValidation();
		
	}
	
	public List<Escala> getListaEscala(){
		if(listaEscala == null) {
			EscalaRepository repository = new EscalaRepository(JPAFactory.getEntityManager());
			listaEscala = repository.buscarTodos();
		}
		return listaEscala;
	}
	
	private void setListaEscala(List<Escala> listaEscala) {
		this.listaEscala = listaEscala;
		
	}
	public List<Evento> getListaEvento() {
		if(listaEvento == null) {
			EventoRepository repository = new EventoRepository(JPAFactory.getEntityManager());
			listaEvento = repository.buscarTodos();
		}
		return listaEvento;
	}
	public void setEvento(List<Evento> listaEvento) {
		this.listaEvento = listaEvento;
	}

	public void trocaMembroEscala() {
		
	}
//	public List<TurmaVoluntario> getListaTurmaCores(){
//		if(listaTurma == null) {
//			TurmaVoluntarioController turmas = new TurmaVoluntarioController();
//			TurmaVoluntarioRepository repositoryt = new TurmaVoluntarioRepository(JPAFactory.getEntityManager());
//			listaTurma = repositoryt.buscarTurmaCor(turmas.getEntity().getCor().getId());
//		}
//		return listaTurma;
//	}
	public void getGerarEscala(ActionEvent actionEvent) {
		//chama a lista de eventos
		EventoRepository eventoRep = new EventoRepository(JPAFactory.getEntityManager());
		listaEvento = eventoRep.buscarEventos(inicio,fim);
		
		CorEquipesController grupoCores = new CorEquipesController();
		TurmaVoluntarioRepository repository = new TurmaVoluntarioRepository(JPAFactory.getEntityManager());
		List<Voluntario> listaVoluntario = repository.buscarVoluntarioCor(cor);
		List<Voluntario> equipeA = new ArrayList<Voluntario>();
		List<Voluntario> equipeB = new ArrayList<Voluntario>();
		List<Voluntario> listPopulacaoI = new ArrayList<Voluntario>();			
		List<Voluntario> escalaA = new ArrayList<Voluntario>();
		List<Voluntario> escalaB = new ArrayList<Voluntario>();
		List<Integer> intervaloSorteio = new ArrayList<Integer>();
		if(cor!=null) {	
//			For de verificação para não repetição dos campos sorteados
			for (int i=0; i<listaVoluntario.size(); i++) {
				intervaloSorteio.add(i);
			}
			//População inicial	
			for (int i=0; i<listaVoluntario.size(); i++) {
				Random rand = new Random();
				
				int posicaoSorteada = rand.nextInt(intervaloSorteio.size());
				
				System.out.println("Size: "+intervaloSorteio.size());
				int conteudoSorteado = intervaloSorteio.get(posicaoSorteada);
				
				System.out.println("Randomico: "+posicaoSorteada);
				System.out.println("Indice de L: "+conteudoSorteado);
				
				listPopulacaoI.add(listaVoluntario.get(conteudoSorteado));

				System.out.println(listPopulacaoI.get(i).getPessoa().getNome());

				for (int j = 0; j<intervaloSorteio.size(); j++) {
					if (conteudoSorteado==intervaloSorteio.get(j)) {
						intervaloSorteio.remove(j);
						break;
					}
				}
			}
			//Gera os pais
			for (int i=0; i<listaVoluntario.size(); i++) {
				intervaloSorteio.add(i);
			}
			for(int k = 0; k<listPopulacaoI.size();k++) {
				Random rand = new Random();
				//vrifica a lista para adicionar na equipe A (pai1)
				if (intervaloSorteio.isEmpty()) {
					break;
				}else {
					int posicaoSorteadaA = rand.nextInt(intervaloSorteio.size());
					int conteudoSorteadoA = intervaloSorteio.get(posicaoSorteadaA);
					equipeA.add(listPopulacaoI.get(conteudoSorteadoA));
					for (int j = 0; j<intervaloSorteio.size(); j++) {
						if (conteudoSorteadoA==intervaloSorteio.get(j)) {
							intervaloSorteio.remove(j);
							break;
						}
					}
					System.out.println(equipeA.get(k).getPessoa().getNome());
				}
				//vrifica a lista para adicionar na equipe B (pai2)
				if(intervaloSorteio.isEmpty()) {
					break;
				}else {
					int posicaoSorteadaB = rand.nextInt(intervaloSorteio.size());
					int conteudoSorteadoB = intervaloSorteio.get(posicaoSorteadaB);
					equipeB.add(listPopulacaoI.get(conteudoSorteadoB));
					for (int j = 0; j<intervaloSorteio.size(); j++) {
						if (conteudoSorteadoB==intervaloSorteio.get(j)) {
							intervaloSorteio.remove(j);
							break;
						}
					}
					System.out.println(equipeB.get(k).getPessoa().getNome());
				}
			}
			//Cruzamento
			int tamanhoA = equipeA.size();
			int tamanhoB = equipeB.size();
			int metadeA = (int) tamanhoA/2;
			int metadeB = (int) tamanhoB/2;
			for (int i=0; i<metadeA; i++) {
				escalaA.add(equipeA.get(i));
				System.out.println("escala A: "+ escalaA.get(i).getPessoa().getNome());
			}
			for (int i=metadeA; i<tamanhoA; i++) {
				escalaB.add(equipeA.get(i));
//				System.out.println("escala B: "+ escalaB.get(i).getPessoa().getNome());
			}
			for (int i=0; i<metadeB; i++) {
				escalaB.add(equipeB.get(i));
				System.out.println("escala B: "+ escalaB.get(i).getPessoa().getNome());
			}
			for (int i=metadeB; i<tamanhoB; i++) {
				escalaA.add(equipeB.get(i));
				System.out.println("escala A: "+ escalaA.get(i).getPessoa().getNome());
			}
			
			//grava dados na base
			System.out.println("cor : "+ cor.getNome());
			int tamanhoEvanto = listaEvento.size();
			int metadeTamanhoEv = tamanhoEvanto/2;
			for (int i = 0; i < listaEvento.size(); i ++) {
				System.out.println("listaEvento : "+ listaEvento.get(i).getNome());
				if (listaEvento.get(i).getTipoEvento().getValor().equals(0)) {
					System.out.println("listaEvento : "+ listaEvento.get(i).getTipoEvento());
					for(int j = 0; j < equipeA.size(); j++) {
						getEntity().setCorE(cor);
						getEntity().setEvento(listaEvento.get(i));
						getEntity().setVoluntario(equipeA.get(j));
						System.out.println("escalado A: "+ getEntity().getVoluntario().getPessoa().getNome());
						insert(actionEvent);
					}
					i++;
					System.out.println("listaEvento : "+ listaEvento.get(i).getNome());
					System.out.println("listaEvento : "+ listaEvento.get(i).getTipoEvento());
					for(int j = 0; j < equipeB.size(); j++) {
						getEntity().setCorE(cor);
						getEntity().setEvento(listaEvento.get(i));
						getEntity().setVoluntario(equipeB.get(j));
						System.out.println("escalado B: "+ getEntity().getVoluntario().getPessoa().getNome());
						insert(actionEvent);
					}
				}else {
					for(int j = 0; j < listPopulacaoI.size(); j++) {
						getEntity().setCorE(cor);
						getEntity().setEvento(listaEvento.get(i));
						getEntity().setVoluntario(listPopulacaoI.get(j));
						System.out.println("escalado A e B: "+ getEntity().getVoluntario().getPessoa().getNome());
						insert(actionEvent);
					}
				}
			}
			
		}
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public List<CorEquipes> getListaCor() {
		if (listaCor == null) {
			CorEquipesRepository repository = new CorEquipesRepository(JPAFactory.getEntityManager());
			listaCor = repository.buscarTodos();
		}
		return listaCor;
	}

	public void setListaCor(List<CorEquipes> listaCor) {
		this.listaCor = listaCor;
	}

	public CorEquipes getCor() {
		return cor;
	}

	public void setCor(CorEquipes cor) {
		this.cor = cor;
	}

	public Voluntario getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(Voluntario voluntario) {
		this.voluntario = voluntario;
	}
}
