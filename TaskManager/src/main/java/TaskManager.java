import java.time.LocalDate;
import java.util.*;

public class TaskManager {
    Map<Integer, Task> tasks = new HashMap<Integer, Task>();
    MenuTask menuTask = new MenuTask(this);
    Scanner sc = new Scanner(System.in);

    public int nextId = 0;
    boolean exit = false;
    boolean exitMenuTask = false;
    public int decision;

    public void showMenu() { //Apenas um menu de Inicialização
        exitMenuTask = false;
        System.out.println("\nBem vindo ao programa\n");
        System.out.println("Escolha o que você quer fazer:");
        System.out.println("1 - Criar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Atualizar status da tarefa");
        System.out.println("4 - Remover tarefa");
        System.out.println("5 - Sair");

        if (sc.hasNextInt()) {
            decision = sc.nextInt();
            sc.nextLine();
            decision();
        } else {
            System.out.println("Por favor, insira apenas um dígito de 1 a 5!");
            sc.nextLine();
        }
    }

    public void start () { //Método de Operação
        while (!exit) {
            showMenu();
        }
    }

    public void decision () { //Verificação de Decisão, qual tarefa o usuário quer executar
        switch (decision) {
            case 1:
                insertTask();
                break;
            case 2, 3, 4:
                while (!exitMenuTask) {
                    menuTask.menuTask();
                }
                break;
            case 5:
                exit = true;
                break;
            default:
                System.out.println("Insira um número de 1 a 5!");
                decision = sc.nextInt();
                start();
                break;
        }
    }

    public void insertTask () { //Método que cria uma nova Task
        nextId++;
        System.out.println("Qual o nome da tarefa?");
        String title = sc.nextLine();
        System.out.println("Descreva o que vai fazer na tarefa");
        String description = sc.nextLine();
        TaskStatus status = TaskStatus.PENDENTE;
        LocalDate creationDate = LocalDate.now();
        Task task = new Task(nextId, title, description, status, creationDate);
        tasks.put(nextId, task);
    }
}