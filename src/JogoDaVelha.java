import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class JogoDaVelha extends JFrame {
    JButton[] bt = new JButton[9]; 
    JLabel placar = new JLabel("Placar");
    JLabel pX = new JLabel("X ");
    JLabel pO = new JLabel("O ");
    JLabel empate = new JLabel("Empate ");
    JButton novo = new JButton("Novo jogo");
    JButton zerar = new JButton("Zerar placar");
    int PX = 0;
    int PO = 0;
    int EMPATE = 0;
    boolean xo = false;
    boolean[] click = new boolean[9];
    public static void main(String... args) {
        new JogoDaVelha();
    }

    protected JogoDaVelha() {
        settar();
        novo();
        zerar();
        campos();
        atualizar();
    }    

    protected void campos() {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bt[count] = new JButton();
                add(bt[count]);
                bt[count].setBounds((100 * i) + 50, (100 * j) + 50, 95, 95);
                bt[count].setFont(new Font("Arial", Font.BOLD, 40));
                count++;
            }
        }

        for (int i = 0; i < 9; i++) click[i] = false;

        bt[0].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (click[0] == false) {
                    click[0] = true;
                    marcar(bt[0]);
                } else JOptionPane.showMessageDialog(null, "Botão já selecionado");
            }
        });
        bt[1].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (click[1] == false) {
                    click[1] = true;
                    marcar(bt[1]);
                } else JOptionPane.showMessageDialog(null, "Botão já selecionado");
            }
        });
        bt[2].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (click[2] == false) {
                    click[2] = true;
                    marcar(bt[2]);
                } else JOptionPane.showMessageDialog(null, "Botão já selecionado");
            }
        });
        bt[3].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (click[3] == false) {
                    click[3] = true;
                    marcar(bt[3]);
                } else JOptionPane.showMessageDialog(null, "Botão já selecionado");
            }
        });
        bt[4].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (click[4] == false) {
                    click[4] = true;
                    marcar(bt[4]);
                } else JOptionPane.showMessageDialog(null, "Botão já selecionado");
            }
        });
        bt[5].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (click[5] == false) {
                    click[5] = true;
                    marcar(bt[5]);
                } else JOptionPane.showMessageDialog(null, "Botão já selecionado");
            }
        });
        bt[6].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (click[6] == false) {
                    click[6] = true;
                    marcar(bt[6]);
                } else JOptionPane.showMessageDialog(null, "Botão já selecionado");
            }
        });
        bt[7].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (click[7] == false) {
                    click[7] = true;
                    marcar(bt[7]);
                } else JOptionPane.showMessageDialog(null, "Botão já selecionado");
            }
        });
        bt[8].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (click[8] == false) {
                    click[8] = true;
                    marcar(bt[8]);
                } else JOptionPane.showMessageDialog(null, "Botão já selecionado");
            }
        });
    }

    protected void marcar(JButton btn) {
        btn.setText("X");
        xo = true;
        maquina();
    }

    protected void maquina() {
        int random = (int) (Math.random() * 9);

        if (click[0] && click[1] && click[2] && click[3] && click[4] && click[5] && click[6] && click[7] && click[8]) ganhou();
        else if (!click[0] && (bt[1].getText() == "X" && bt[2].getText() == "X" || bt[3].getText() == "X" && bt[6].getText() == "X")) Selecionar(0);
        else if (!click[2] && (bt[5].getText() == "X" && bt[8].getText() == "X")) Selecionar(2);
        else if (!click[8] && (bt[7].getText() == "X" && bt[6].getText() == "X" || bt[2].getText() == "X" && bt[5].getText() == "X")) Selecionar(8);
        else if (!click[7] && bt[4].getText() == "X" && bt[1].getText() == "X") Selecionar(7);
        else if (!click[6] && (bt[3].getText() == "X" && bt[0].getText() == "X")) Selecionar(6);
        else if (click[0] || click[1] || click[2] || click[3] || click[4] || click[5] || click[6] || click[7] || click[8] || click[9]) {
            if (click[4] && !click[random]) Selecionar(random);
            else if (!click[4]) Selecionar(4);
            else maquina();
        }
        ganhou();
    }

    protected void atualizar() {
        pX.setText("X " + PX);
        pO.setText("O " + PO);
        empate.setText("Empate " + EMPATE);
    }




    protected void ganhou() {
        if(
        (bt[0].getText() == "X" && bt[1].getText() == "X" && bt[2].getText() == "X") ||
        (bt[3].getText() == "X" && bt[4].getText() == "X" && bt[5].getText() == "X") ||
        (bt[6].getText() == "X" && bt[7].getText() == "X" && bt[8].getText() == "X") ||
        (bt[0].getText() == "X" && bt[3].getText() == "X" && bt[6].getText() == "X") ||
        (bt[1].getText() == "X" && bt[4].getText() == "X" && bt[7].getText() == "X") ||
        (bt[2].getText() == "X" && bt[5].getText() == "X" && bt[8].getText() == "X") ||
        (bt[0].getText() == "X" && bt[4].getText() == "X" && bt[8].getText() == "X") ||
        (bt[2].getText() == "X" && bt[4].getText() == "X" && bt[6].getText() == "X")
        ) {
            JOptionPane.showMessageDialog(null, "X ganhou");
            PX++;
            atualizar();
            limpar();
            xo = false;
        } else if(
        (bt[0].getText() == "O" && bt[1].getText() == "O" && bt[2].getText() == "O") ||
        (bt[3].getText() == "O" && bt[4].getText() == "O" && bt[5].getText() == "O") ||
        (bt[6].getText() == "O" && bt[7].getText() == "O" && bt[8].getText() == "O") ||
        (bt[0].getText() == "O" && bt[3].getText() == "O" && bt[6].getText() == "O") ||
        (bt[1].getText() == "O" && bt[4].getText() == "O" && bt[7].getText() == "O") ||
        (bt[2].getText() == "O" && bt[5].getText() == "O" && bt[8].getText() == "O") ||
        (bt[0].getText() == "O" && bt[4].getText() == "O" && bt[8].getText() == "O") ||
        (bt[2].getText() == "O" && bt[4].getText() == "O" && bt[6].getText() == "O")
        ) {
            JOptionPane.showMessageDialog(null, "O ganhou");
            PO++;
            atualizar();
            limpar();
            xo = false;
        } else if (
            bt[0].getText() != "" &&
            bt[1].getText() != "" &&
            bt[2].getText() != "" &&
            bt[3].getText() != "" &&
            bt[4].getText() != "" &&
            bt[5].getText() != "" &&
            bt[6].getText() != "" &&
            bt[7].getText() != "" && 
            bt[8].getText() != "" 
            ){
            JOptionPane.showMessageDialog(null, "O jogo empatou");
            EMPATE++;
            atualizar();
            limpar();
            xo = false;
        } 
    }

    protected void limpar() {
        for (int i = 0; i < 9; i++) {
            bt[i].setText("");
            click[i] = false;
        }
    }

    protected void novo() {
        novo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                limpar();
            }
        });
    }

    protected void zerar() {
        zerar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PO = 0;
                PX = 0;
                EMPATE = 0;
                atualizar();
            }
        });
    }

    protected void settar() {
        setVisible(true);
        setTitle("Jogo da Velha");
        setDefaultCloseOperation(3);
        setLayout(null);
        setBounds(200, 100, 700, 500);
        add(placar);
        add(pX);
        add(pO);
        add(empate);
        add(novo);
        add(zerar);
        placar.setFont(new Font("Arial", Font.BOLD, 17));
        placar.setBounds(455, 50, 100, 30);
        pX.setBounds(400, 75, 100, 30);
        pO.setBounds(450, 75, 100, 30);
        empate.setBounds(500, 75, 100, 30);
        novo.setBounds(425, 120, 120, 30);
        zerar.setBounds(425, 170, 120, 30);
    }

    protected void Selecionar (int num) {
        if (xo) {
            bt[num].setText("O");
            xo = false;
        }
        click[num] = true;
    }

}