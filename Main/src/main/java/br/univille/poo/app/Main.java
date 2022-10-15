package br.univille.poo.app;

import java.util.Scanner;

import br.univille.poo.app.entidade.Lista;
import br.univille.poo.app.entidade.Tarefa;
import br.univille.poo.app.persistencia.CriarTabelas;
import br.univille.poo.app.servico.ConcluirTarefa;
import br.univille.poo.app.servico.CriarLista;
import br.univille.poo.app.servico.CriarTarefa;
import br.univille.poo.app.servico.ListarListas;
import br.univille.poo.app.servico.ListarTarefas;
import br.univille.poo.app.servico.PriorizarTarefa;
import br.univille.poo.app.servico.VincularTarefa;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    CriarTabelas.criarTabelas();

    boolean trigger = true;

    while (trigger) {

      System.out.println("\n========================================\n");
      System.out.println("----------- Escolha um comando -----------\n");
      System.out.println(" 1. Adiconar Tarefa \n");
      System.out.println(" 2. Listar Tarefas \n");
      System.out.println(" 3. Concluir Tarefas \n");
      System.out.println(" 4. Priorizar Tarefas \n");
      System.out.println(" 5. Adicionar Lista \n");
      System.out.println(" 6. Adicionar Tarefas à uma Lista \n");
      System.out.println(" 0. Encerrar Programa \n");
      System.out.println("========================================\n");
      System.out.println("\n");
    
      System.out.print("Insira o número do comando a ser executado: ");


      Scanner teclado = new Scanner(System.in);
      

      Integer comparador = teclado.nextInt();

      if(comparador == 1){

        System.out.print("Escreva a descrição da sua tarefa: ");

        Scanner teclado2 = new Scanner(System.in);
        String descricao = teclado2.nextLine();

        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(descricao);

        CriarTarefa criarTarefa = new CriarTarefa();


        try {

          criarTarefa.criar(tarefa);

        }catch (Exception e){

          e.printStackTrace();

        }


        System.out.println(" Tarefa Criada com sucesso !!! \n");


      }else if(comparador == 2){

        ListarTarefas listarTarefas = new ListarTarefas();

        
        for(Tarefa t : listarTarefas.obterTodos()){

          System.out.println(t);

        }


      }else if(comparador == 3){

        System.out.println("Digite o ID da tarefa que deseja concluir: ");
        ListarTarefas listarTarefas = new ListarTarefas();


        for(Tarefa t : listarTarefas.obterTodos()){

          System.out.println(t);

        }


        Scanner teclado2 = new Scanner(System.in);
        Integer escolha = teclado2.nextInt();

        ConcluirTarefa concluirTarefa = new ConcluirTarefa();


        try {

          concluirTarefa.concluir(escolha);

        }catch (Exception e){

          e.printStackTrace();

        }


        System.out.println("A tarefa foi concluida com sucesso. \n");

      }else if(comparador == 4){

        System.out.println("Digite o ID da tarefa que deseja priorizar: \n");

        ListarTarefas listarTarefas = new ListarTarefas();
        
        
        for(Tarefa t : listarTarefas.obterTodos()){
          System.out.println(t);
        }


        Scanner teclado2 = new Scanner(System.in);
        Integer escolha = teclado2.nextInt();
        
        System.out.println("\n---  Escolha o nível de Prioridade ---");
        System.out.println(" Alto");
        System.out.println(" Mediano");
        System.out.println(" Baixo\n");

        Scanner teclado3 = new Scanner(System.in);
        String nvlPriori = teclado3.nextLine();

        PriorizarTarefa priorizarTarefa = new PriorizarTarefa();
        

        try {

          priorizarTarefa.priorizar(escolha,nvlPriori);

        }catch (Exception e){

          e.printStackTrace();

        }


        System.out.println("A tarefa " + escolha +" foi alterada para o nível " + nvlPriori + "\n");

        Thread.sleep(3000);


      }else if(comparador == 5){

        System.out.print("Qual seria o nome da lista que deseja criar? ");

        Scanner teclado2 = new Scanner(System.in);
        String listaName = teclado2.nextLine();

        Lista lista = new Lista();
        lista.setLista_name(listaName);

        CriarLista criarLista = new CriarLista();

        
        try {

          criarLista.criar(listaName);

        }catch (Exception e){

          e.printStackTrace();
          
        }


        System.out.println(" Lista Criada com sucesso !!! \n");

      }else if(comparador == 6){

        System.out.println("Qual seria a tarefa que deseja Adicionar a lista? (escolha pelo ID da tarefa) \n");

        ListarTarefas listarTarefas = new ListarTarefas();


        for(Tarefa t : listarTarefas.obterTodos()){

          System.out.println(t);

        }


        Scanner teclado2 = new Scanner(System.in);
        Integer tarefaId = teclado2.nextInt();

        System.out.println("\n\n Em qual lista deseja adicionar a tarefa? (escolha pelo ID da lista) \n");

        
        ListarListas listarListas = new ListarListas();


        for(Lista l : listarListas.obterTodos()){

          System.out.println(l);

        }


        Scanner teclado3 = new Scanner(System.in);
        Integer listaId = teclado3.nextInt();

        VincularTarefa vincularTarefa = new VincularTarefa();


        try {

          vincularTarefa.vincular(tarefaId,listaId);

        }catch (Exception e){

          e.printStackTrace();

        }


        System.out.println(" Tarefa Priorizada com sucesso !!! \n");

      }else if(comparador == 0){

        System.out.println("Finalizando Programa");

        trigger = false;

      }else{

        System.out.println("Comando Inválido");

      }
    }
  }
}
