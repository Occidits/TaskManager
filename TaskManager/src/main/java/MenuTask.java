import java.util.Map;

public class MenuTask {
    TaskManager taskManager;
    Map<Integer, Task> tasks;

    public MenuTask(TaskManager taskManager) {
        this.taskManager = taskManager;
        this.tasks = taskManager.tasks;
    }

    public void menuTask() { //Método que mostra as tasks criadas
        if (tasks.isEmpty()) {
            System.out.println("\nNenhuma tarefa criada ainda...");

        }else{
            tasks.forEach((id, task) -> {
                System.out.println();
                System.out.println("\n--------------------" +
                        "\nID: " + id +
                        "\nTítulo: " + task.getTitle() +
                        "\nDescrição: " + task.getDescription() +
                        "\nStatus: " + task.getStatus() +
                        "\nData: " + task.getCreationDate().toString() +
                        "\n--------------------");
            });


            if (taskManager.decision == 3) {
                System.out.println("Digite o número da Task (1,2,3...) que deseja atualizar Status: ");
                if (taskManager.sc.hasNextInt()) {
                    int searchId = taskManager.sc.nextInt();
                    if (tasks.containsKey(searchId)){
                        taskManager.sc.nextLine();
                        Task t = tasks.get(searchId);
                        System.out.println("\nA tarefa com esse ID foi encontrada");
                        System.out.println("\n--------------------" +
                            "\nID: " + t.getId() +
                            "\nTítulo: " + t.getTitle() +
                            "\nDescrição: " + t.getDescription() +
                            "\nStatus: " + t.getStatus() +
                            "\nData: " + t.getCreationDate().toString() +
                            "\n--------------------");

                        System.out.println("Selecione qual Status quer manter" +
                            "\nPENDENTE" + "\nEM ANDAMENTO" + "\nCONCLUÍDA");
                        String answer = taskManager.sc.nextLine().toLowerCase();
                        if (answer.equals("pendente")){
                            t.setStatus(TaskStatus.PENDENTE);
                        }else if(answer.equals("em andamento")){
                            t.setStatus(TaskStatus.EM_ANDAMENTO);
                        }else if(answer.equals("concluida") || answer.equals("concluída")){
                        t.setStatus(TaskStatus.CONCLUIDA);
                        }else{
                        System.out.println("Erro ao tentar atualizar Status");
                        }
                        taskManager.decision = 0;
                    }
                }
            }

            if (taskManager.decision == 4) {
            System.out.println("Digite o número da Task (1,2,3...) que deseja remover: ");
            if (taskManager.sc.hasNextInt()) {
                int searchId = taskManager.sc.nextInt();
                if (tasks.containsKey(searchId)) {
                    taskManager.sc.nextLine();
                    Task t = tasks.get(searchId);
                    System.out.println("\nA tarefa com esse ID foi encontrada");
                    System.out.println("\n--------------------" +
                            "\nID: " + t.getId() +
                            "\nTítulo: " + t.getTitle() +
                            "\nDescrição: " + t.getDescription() +
                            "\nStatus: " + t.getStatus() +
                            "\nData: " + t.getCreationDate().toString() +
                            "\n--------------------");

                    System.out.println("\nCerteza que deseja deletar? (Y/N)");
                    String answerDelete = taskManager.sc.nextLine().toLowerCase();
                    if (answerDelete.equals("yes") || answerDelete.equals("y")) {
                        tasks.remove(t.getId());
                    } else {
                        System.out.println("Processo cancelado");
                    }
                }
            }
        }
    }

        System.out.println("\nDigite \"Voltar\" para voltar ao menu");
        String answer = taskManager.sc.nextLine().toLowerCase();
        if (answer.equals("voltar")) {
            taskManager.exitMenuTask = true;
        }
    }
}
