package view;

import interfaces.ChatWebService;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * Created by Rubens Santos Barbosa. Web Services and MOM - WSChat December 2018
 */
public class WSChat extends javax.swing.JFrame {

    private static String username;
    private ArrayList<String> listUsers;
    private static final long serialVersionUID = 1L;
    public static ChatWebService chatManager;

    public WSChat() {
        createUser();
        addWindowListener(new ExitListener());
        initComponents();
    }

    public void createUser() {
        username = JOptionPane.showInputDialog("Username: ");

        listUsers = chatManager.getUser();
        for (String user : listUsers) {
            
            if (username == null ? user == null : username.equals(user)) {
                JOptionPane.showMessageDialog(null, "Este usuario ja existe, digete outro nome!");
                System.exit(0);
            } else {
                chatManager.addUser(username);
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_sendTo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaShowMessage = new javax.swing.JTextArea();
        textFieldSendTo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lb_Users = new javax.swing.JLabel();
        iconUsers = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaShowUsers = new javax.swing.JTextArea();
        btnShowUsers = new javax.swing.JButton();
        textFieldMessage = new javax.swing.JTextField();
        btnSendMessage = new javax.swing.JButton();
        btnChat = new javax.swing.JButton();
        lbName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WSChat");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_sendTo.setText(" Enviar para:");
        getContentPane().add(lb_sendTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 80, 30));

        textAreaShowMessage.setEditable(false);
        textAreaShowMessage.setColumns(20);
        textAreaShowMessage.setRows(5);
        jScrollPane1.setViewportView(textAreaShowMessage);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 220, 250));
        getContentPane().add(textFieldSendTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 140, 30));

        jPanel1.setBackground(new java.awt.Color(36, 24, 88));

        lb_Users.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lb_Users.setForeground(new java.awt.Color(255, 255, 255));
        lb_Users.setText("Usuários");

        iconUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/team.png"))); // NOI18N
        iconUsers.setBorderPainted(false);

        textAreaShowUsers.setColumns(20);
        textAreaShowUsers.setRows(5);
        jScrollPane2.setViewportView(textAreaShowUsers);

        btnShowUsers.setText("Mostrar");
        btnShowUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowUsersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 42, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(iconUsers)
                                    .addComponent(lb_Users))
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnShowUsers)
                                .addGap(40, 40, 40))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lb_Users)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconUsers)
                .addGap(1, 1, 1)
                .addComponent(btnShowUsers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 180, 400));
        getContentPane().add(textFieldMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 346, 153, 50));

        btnSendMessage.setText("Enviar");
        btnSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMessageActionPerformed(evt);
            }
        });
        getContentPane().add(btnSendMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 71, 44));

        btnChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chat.png"))); // NOI18N
        btnChat.setBorderPainted(false);
        btnChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatActionPerformed(evt);
            }
        });
        getContentPane().add(btnChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        lbName.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        getContentPane().add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 130, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMessageActionPerformed
        try {

            String sendTo = textFieldSendTo.getText();
            String message = textFieldMessage.getText();
            String showMsg = username + ": " + message + "\n";

            chatManager.sendMessage(sendTo, showMsg);

            textFieldSendTo.setText("");
            textFieldMessage.setText("");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnSendMessageActionPerformed


    private void btnShowUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowUsersActionPerformed
        try {

            listUsers = chatManager.getUser();
            listUsers.toString();

            textAreaShowUsers.append(listUsers.toString());
            textAreaShowUsers.append("\n\n\n");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnShowUsersActionPerformed

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatActionPerformed
        getMessages();
    }//GEN-LAST:event_btnChatActionPerformed

    public void getMessages() {
        String messages = chatManager.receiveMessage(username);
        while (messages != null) {
            textAreaShowMessage.append(messages + "\n");
            messages = chatManager.receiveMessage(username);
        }
    }

    public class ExitListener implements WindowListener {

        @Override
        public void windowClosing(WindowEvent e) {
            if (!(JOptionPane.showConfirmDialog(null, "Deseja sair do WSChat?") == JOptionPane.OK_OPTION)) {
                return;
            } else {
                try {

                    chatManager.removeUser(username);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }

        }

        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                URL url;
                try {

                    url = new URL("http://localhost:9998/chat?wsdl");

                    QName qname = new QName("http://webserver/", "ChatWebServerService");
                    Service ws = Service.create(url, qname);
                    chatManager = ws.getPort(ChatWebService.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                new WSChat().setVisible(true);
                lbName.setText(username);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChat;
    private javax.swing.JButton btnSendMessage;
    private javax.swing.JButton btnShowUsers;
    private javax.swing.JButton iconUsers;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JLabel lbName;
    private javax.swing.JLabel lb_Users;
    private javax.swing.JLabel lb_sendTo;
    private javax.swing.JTextArea textAreaShowMessage;
    private javax.swing.JTextArea textAreaShowUsers;
    private javax.swing.JTextField textFieldMessage;
    private javax.swing.JTextField textFieldSendTo;
    // End of variables declaration//GEN-END:variables
}
