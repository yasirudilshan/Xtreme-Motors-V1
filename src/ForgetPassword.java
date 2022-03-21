
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dinus
 */
public class ForgetPassword extends javax.swing.JFrame {

    /**
     * Creates new form ForgetPassword
     */
    Connection con = null;
    Statement stmt = null;
    
    public ForgetPassword() {
        
        initComponents();
        con = Database_connection_CLASS.connection();
        
        step1.setVisible(true);step2.setVisible(false);
        errorMassage.setVisible(false);
        
        errorMassage2.setVisible(false);
    }
    
    public void checkAnswers(){
    
        try{
        
            if( email.getText().equals("")||answer.getText().equals("")  )
            {
                errorMassage.setVisible(true);errorMassage.setText("Some fields are missing");
            }
            else
            {
                boolean loopcheck = false;

                stmt = con.createStatement();
                String query = "SELECT * FROM users ";

                ResultSet rs = stmt.executeQuery(query);

                while(rs.next())
                {
                    if (email.getText().equals(rs.getString(5)) && questions.getSelectedItem().toString().equals(rs.getString(8))  && answer.getText().equals(rs.getString(9)))
                    {

                        loopcheck = true;
                        step1.setVisible(false);
                        step2.setVisible(true);
                        
                    }
                }
                if(!loopcheck){

                    errorMassage.setVisible(true);errorMassage.setText("Invalid username or password");
                }
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void changePassword(){
        try{
        
            if( newPassword.getText().equals("")||confirmPassword.getText().equals("")  )
            {
                errorMassage2.setVisible(true);errorMassage2.setText("Some fields are missing");
            }
            else
            {
                if(!newPassword.getText().equals(confirmPassword.getText())){
                
                    errorMassage2.setVisible(true);errorMassage2.setText("Passwords Doesnot match");
                }
                else{
                    
                    String Query = "UPDATE `users` SET `password` = ? WHERE `email` = ?;";

                    PreparedStatement preparedStmt = con.prepareStatement(Query);
                    preparedStmt.setString(1, newPassword.getText());
                    preparedStmt.setString(2, email.getText());
                    preparedStmt.execute();
                    
                    JOptionPane.showMessageDialog (null, "Password successfully changed", "success!", JOptionPane.INFORMATION_MESSAGE);
                    UIManager UI=new UIManager();
                    UIManager.put("OptionPane.background", Color.white);
                    UIManager.put("Panel.background", Color.white);
                    
                    this.setVisible(false);
                    Login ln = new Login ();
                    ln.setVisible(true);
                }
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Backgriund = new javax.swing.JLabel();
        step1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        answer = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        questions = new javax.swing.JComboBox<>();
        button1 = new Assests.Button();
        errorMassage = new javax.swing.JLabel();
        step2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        button2 = new Assests.Button();
        newPassword = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        confirmPassword = new javax.swing.JPasswordField();
        errorMassage2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(53, 126, 199));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/icons8_back_to_20px_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 700, 100, 30));

        Backgriund.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Memo3-01.png"))); // NOI18N
        Backgriund.setText("jLabel1");
        jPanel1.add(Backgriund, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, -1));

        step1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(10, 34, 53));
        jLabel2.setText("Forget password");

        jLabel3.setText("Forget your account password in few steps");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Enter your email address");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("Select your security question");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Answer");

        answer.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        answer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                answerKeyPressed(evt);
            }
        });

        email.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailKeyPressed(evt);
            }
        });

        questions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "In what city were you born?", "What is the name of your favorite pet?", "What is your mother's maiden name?", "What high school did you attend?", "What is the name of your first school?", "What was the make of your first car?", "What was your favorite food as a child?", "Where did you meet your spouse?" }));

        button1.setBackground(new java.awt.Color(68, 104, 122));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Next");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        errorMassage.setText("jLabel1");

        javax.swing.GroupLayout step1Layout = new javax.swing.GroupLayout(step1);
        step1.setLayout(step1Layout);
        step1Layout.setHorizontalGroup(
            step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(step1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answer, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(email, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(questions, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addComponent(errorMassage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        step1Layout.setVerticalGroup(
            step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(step1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questions, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(errorMassage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jPanel1.add(step1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 620, 630));

        step2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(10, 34, 53));
        jLabel7.setText("Change password");

        jLabel8.setText("lets set more secure password for your account");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setText("Confirm password");

        button2.setBackground(new java.awt.Color(68, 104, 122));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Change password");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        newPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newPasswordKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel12.setText("New password");

        confirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmPasswordKeyPressed(evt);
            }
        });

        errorMassage2.setText("jLabel1");

        javax.swing.GroupLayout step2Layout = new javax.swing.GroupLayout(step2);
        step2.setLayout(step2Layout);
        step2Layout.setHorizontalGroup(
            step2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(step2Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(step2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addComponent(newPassword)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confirmPassword)
                    .addComponent(errorMassage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        step2Layout.setVerticalGroup(
            step2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(step2Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorMassage2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        jPanel1.add(step2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 620, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        try{
            checkAnswers();
        }
        catch(Exception e){
            
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        try{
            changePassword();
        }
        catch(Exception e){
        
            }
    }//GEN-LAST:event_button2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Login load = new Login ();
        load.setVisible (true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyPressed
        // TODO add your handling code here:
         errorMassage.setVisible(false);
    }//GEN-LAST:event_emailKeyPressed

    private void answerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_answerKeyPressed
        // TODO add your handling code here:
        errorMassage.setVisible(false);
    }//GEN-LAST:event_answerKeyPressed

    private void newPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newPasswordKeyPressed
        // TODO add your handling code here:
        errorMassage2.setVisible(false);
    }//GEN-LAST:event_newPasswordKeyPressed

    private void confirmPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmPasswordKeyPressed
        // TODO add your handling code here:
        errorMassage2.setVisible(false);
    }//GEN-LAST:event_confirmPasswordKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ForgetPassword().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backgriund;
    private javax.swing.JTextField answer;
    private Assests.Button button1;
    private Assests.Button button2;
    private javax.swing.JPasswordField confirmPassword;
    private javax.swing.JTextField email;
    private javax.swing.JLabel errorMassage;
    private javax.swing.JLabel errorMassage2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newPassword;
    private javax.swing.JComboBox<String> questions;
    private javax.swing.JPanel step1;
    private javax.swing.JPanel step2;
    // End of variables declaration//GEN-END:variables
}
