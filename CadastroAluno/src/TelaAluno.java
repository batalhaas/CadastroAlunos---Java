import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

public class TelaAluno extends JFrame {

    private JTextField txtNome;

    private JButton btnOk;
    private JButton btnLimpar;
    private JButton btnMostrar;
    private JButton btnSair;

    private List<Aluno> alunos = new ArrayList<>();

    public TelaAluno() {

        setTitle("Cadastro de Alunos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(6, 1, 5, 5));

        JLabel lblNome = new JLabel("Nome do aluno:");

        txtNome = new JTextField();

        btnOk = new JButton("OK");
        btnLimpar = new JButton("Limpar");
        btnMostrar = new JButton("Mostrar");
        btnSair = new JButton("Sair");

        add(lblNome);
        add(txtNome);
        add(btnOk);
        add(btnLimpar);
        add(btnMostrar);
        add(btnSair);

        btnOk.addActionListener(e -> cadastrarAluno());
        btnLimpar.addActionListener(e -> limpar());
        btnMostrar.addActionListener(e -> mostrarAlunos());
        btnSair.addActionListener(e -> System.exit(0));
    }

    private void cadastrarAluno() {

        String nome = txtNome.getText();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Digite o nome do aluno.");
            return;
        }

        Aluno aluno = new Aluno(nome);
        alunos.add(aluno);

        JOptionPane.showMessageDialog(this,
                "Aluno cadastrado com sucesso!");

        limpar();
    }

    private void limpar() {
        txtNome.setText("");
    }

    private void mostrarAlunos() {

        if (alunos.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum aluno cadastrado.");
            return;
        }

        String mensagem = "";

        for (Aluno aluno : alunos) {

            mensagem += "ID: " + aluno.getId() + "\n";
            mensagem += "Nome: " + aluno.getNome() + "\n";
            mensagem += "-----------------------------\n";
        }

        JOptionPane.showMessageDialog(this, mensagem);
    }

    public static void main(String[] args) {

        TelaAluno tela = new TelaAluno();

        tela.setVisible(true);
    }
}