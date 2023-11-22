import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManagerApp {

    private static List<Task> tasks = new ArrayList<>();
    private static JList<Task> taskJList;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());  
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Task Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        DefaultListModel<Task> taskListModel = new DefaultListModel<>();
        taskJList = new JList<>(taskListModel);
        JScrollPane taskListScrollPane = new JScrollPane(taskJList);
        JTextField taskTextField = new JTextField(20);
        JButton addButton = new JButton("Adicionar Tarefa");
        JButton removeButton = new JButton("Remover Tarefa Selecionada"); 
        JButton toggleButton = new JButton("Alternar Estado de Todas");
        JButton toggleSelectedButton = new JButton("Alternar Estado da Tarefa Selecionada");
        JButton filterButton = new JButton("Filtrar Tarefas Concluídas");

        JLabel titleLabel = new JLabel("Gerenciador de Tarefas");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));  //TITULO

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        panel.add(taskTextField, gbc);

        gbc.gridx = 1;
        panel.add(addButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(removeButton, gbc);             //POSIÇÕES BOTÕES INTERFACE

        gbc.gridx = 1;
        panel.add(toggleButton, gbc);

        gbc.gridx = 2;
        panel.add(toggleSelectedButton, gbc);

        gbc.gridx = 3;
        panel.add(filterButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        panel.add(taskListScrollPane, gbc);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTask(new Task(taskTextField.getText(), false));   //ADICIONAR NOVA TAREFA
                updateTaskList(taskListModel);
                taskTextField.setText("");
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeSelectedTask();   // REMOVER TAREFA SELECIONADA
                updateTaskList(taskListModel);
            }
        });

        toggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    //CONCLUIR TODAS AS TAREFAS
                toggleTaskState();
                updateTaskList(taskListModel);
            }
        });

        toggleSelectedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleSelectedTaskState();                             //CONCLUIR SOMENTE A TAREFA SELECIONADA
                updateTaskList(taskListModel);
            }
        });

        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Task> completedTasks = filterTasks(Task::isCompleted);          //FILTRAR CONCLUÍDAS
                displayFilteredTasks(completedTasks, "Tarefas Concluídas", taskListModel);
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // CENTRALIZAR INTERFACE
        frame.setVisible(true);
    }

    private static void addTask(Task task) {
        tasks.add(task);
    }

    private static void removeSelectedTask() {
        Task selectedTask = taskJList.getSelectedValue();
        if (selectedTask != null) {
            tasks.remove(selectedTask);
        }
    }

    private static void toggleTaskState() {
        for (Task task : tasks) {
            task.setCompleted(!task.isCompleted());
        }
    }

    private static void toggleSelectedTaskState() {
        Task selectedTask = taskJList.getSelectedValue();
        if (selectedTask != null) {
            selectedTask.setCompleted(!selectedTask.isCompleted());
        }
    }

    private static void updateTaskList(DefaultListModel<Task> taskListModel) {
        taskListModel.clear();
        for (Task task : tasks) {
            taskListModel.addElement(task);
        }
    }

    private static List<Task> filterTasks(java.util.function.Predicate<Task> filter) {
        return tasks.stream()
                .filter(filter)                        //PEGA A LISTA E FILTRA SOMENTE CONCLUÍDAS
                .collect(Collectors.toList());
    }

    private static void displayFilteredTasks(List<Task> filteredTasks, String filterName, DefaultListModel<Task> taskListModel) {
        taskListModel.clear();
        for (Task task : filteredTasks) {
            taskListModel.addElement(task);
        }
    }

    private static class Task {
        private String description;
        private boolean completed;

        public Task(String description, boolean completed) {
            this.description = description;
            this.completed = completed;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        @Override
        public String toString() {
            return getDescription() + " - " + (isCompleted() ? "Concluída" : "Não Concluída");
        }
    }
}
