public class Main {
    static void main (String[]args){
        TaskManager taskManager = new TaskManager();
        MenuTask menu = new MenuTask(taskManager);
        taskManager.start();
    }
}
