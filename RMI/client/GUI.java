import java.io.File;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import server.StudentService;
import server.Student;

public class GUI extends javax.swing.JFrame {
    public int extractXML_counter = 0;
    public StudentService server2;

    /**
     * Creates new form GUI
     */
    public GUI() throws NotBoundException, RemoteException {

        initComponents();
        connectToServer();
        Fetch();
    }

    private void Sort() throws RemoteException {
        String sort = txtSort.getSelectedItem().toString();

        List<Student> students = server2.sortStudent(sort);
        DefaultTableModel df = (DefaultTableModel) jTable2.getModel();
        df.setRowCount(0);
        for (Student student : students) {
            Vector<String> v2 = new Vector<>();
            v2.add(String.valueOf(student.getId()));
            v2.add(student.getName());
            v2.add(String.valueOf(student.getAge()));
            v2.add(student.getAddress());
            v2.add(student.getContact());
            df.addRow(v2);
        }
    }

    private void Fetch() throws RemoteException {
        List<Student> students = server2.fetchStudent();
        DefaultTableModel df = (DefaultTableModel) jTable2.getModel();
        df.setRowCount(0);
        for (Student student : students) {
            Vector<String> v2 = new Vector<>();
            v2.add(String.valueOf(student.getId()));
            v2.add(student.getName());
            v2.add(String.valueOf(student.getAge()));
            v2.add(student.getAddress());
            v2.add(student.getContact());

            df.addRow(v2);
        }
    }

    private void connectToServer() throws java.rmi.NotBoundException {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            StudentService server = (StudentService) registry.lookup("StudentService");
            server2 = (StudentService) registry.lookup("StudentService");
            if (server != null) {
                System.out.println("Connected to the Server");
            } else {
                System.out.println("Not connected to the Server");
            }
        } catch (NotBoundException e) {
            System.out.println("StudentService is not bound in the registry");
        } catch (RemoteException e) {
            System.out.print(e);
        }
    }

    // This is for the Layout and Design for GUI, including buttons (view, sort,
    // update , delete, extractXML )
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        btn_View = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_extractxml = new javax.swing.JButton();
        btn_Add = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        btn_Search = new javax.swing.JButton();
        btn_sort = new javax.swing.JButton();
        txtSort = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btn_delete = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_View.setText("View");
        btn_View.setBorderPainted(false);
        btn_View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ViewActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_extractxml.setBackground(new java.awt.Color(0, 102, 0));
        btn_extractxml.setForeground(new java.awt.Color(255, 255, 255));
        btn_extractxml.setText("Extract XML");
        btn_extractxml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_extractxmlActionPerformed(evt);
            }
        });

        btn_Add.setText("Store/Add");
        btn_Add.setBorderPainted(false);
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_extractxml, javax.swing.GroupLayout.PREFERRED_SIZE, 199,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Add)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_View)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_update)
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_View)
                                        .addComponent(btn_update)
                                        .addComponent(btn_extractxml)
                                        .addComponent(btn_Add))
                                .addContainerGap()));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null }
                },
                new String[] {
                        "ID", "Name", "Age", "Address", "Contact"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class,
                    java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setText("Student Data");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(267, 267, 267)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(9, Short.MAX_VALUE)));

        txtName.setBackground(new java.awt.Color(255, 255, 255));
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel4.setText("Name");

        jLabel5.setText("ID");

        jLabel6.setText("Age");

        txtAge.setBackground(new java.awt.Color(255, 255, 255));
        txtAge.setForeground(new java.awt.Color(0, 0, 0));
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });

        jLabel7.setText("Address");

        txtAddress.setBackground(new java.awt.Color(255, 255, 255));
        txtAddress.setForeground(new java.awt.Color(0, 0, 0));
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        jLabel8.setText("Contact");

        txtContact.setBackground(new java.awt.Color(255, 255, 255));
        txtContact.setForeground(new java.awt.Color(0, 0, 0));
        txtContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactActionPerformed(evt);
            }
        });

        btn_Search.setText("Search");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });

        btn_sort.setText("Sort");
        btn_sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sortActionPerformed(evt);
            }
        });

        txtSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Name", "Age" }));
        txtSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSortActionPerformed(evt);
            }
        });

        jLabel2.setText("Sort by:");

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtSort,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 130,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btn_sort,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(26, 26, 26))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(txtName,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 197,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        85, Short.MAX_VALUE)
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtId,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btn_Search,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(5, 5, 5)
                                                                .addComponent(btn_delete))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(txtAge,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 197,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 43,
                                                                Short.MAX_VALUE)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(17, 17, 17)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtContact,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 197,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtAddress,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 197,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(btn_Search)
                                        .addComponent(btn_delete)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)
                                        .addComponent(btn_sort)
                                        .addComponent(txtSort, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17,
                                        Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // when 'Update' button is pressed this will run
    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_updateActionPerformed
        if (txtName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name of Student required");
        } else if (txtAge.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Age of Student required");
        } else if (txtAddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Address of Student required");
        } else if (txtContact.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type N/A, if none");
        } else {

            try {

                int studID = Integer.parseInt(txtId.getText());
                String name = txtName.getText();
                int age = Integer.parseInt(txtAge.getText());
                String address = txtAddress.getText();
                String contact = txtContact.getText();

                Student student = new Student(studID, name, age, address, contact);
                server2.updateStudent(student);

                JOptionPane.showMessageDialog(this, "Data has been updated!");
                txtName.setText("");
                txtAge.setText("");
                txtAddress.setText("");
                txtContact.setText("");
                txtName.requestFocus();
                Fetch();

            } catch (RemoteException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }// GEN-LAST:event_btn_updateActionPerformed

    // when 'Extract XML' button is Clicked this will run
    private void btn_extractxmlActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_extractxmlActionPerformed
        // TODO add your handling code here:
        try {
            // int recordedData = 0;
            // tracking the xml file, in this example "students.xml"
            File inputDOCUMENTFile = new File("students.xml");

            // creating builderfactory, instanced as 'factory'
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // creating builder, named as 'builder'
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputDOCUMENTFile);

            // a function to normalize the xml structures, needed for parsing the XML
            doc.getDocumentElement().normalize();

            // In this section, gathers, and parses the xml data. It stores from : id, name,
            // age, address, and contact number
            NodeList nodeList = doc.getElementsByTagName("student");
            for (int i = 0; i < nodeList.getLength(); i++) {

                // in here, the xml data are being parsed from the XML file (students)
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    int id = Integer.parseInt(
                            element.getElementsByTagName("id").item(0).getAttributes()
                                    .getNamedItem("value").getNodeValue());

                    String name = element.getElementsByTagName("name").item(0)
                            .getAttributes()
                            .getNamedItem("value").getNodeValue();
                    int age = Integer.parseInt(
                            element.getElementsByTagName("age").item(0).getAttributes()
                                    .getNamedItem("value").getNodeValue());
                    String address = element.getElementsByTagName("address").item(0).getAttributes()
                            .getNamedItem("value")
                            .getNodeValue();
                    String contact = element.getElementsByTagName("contact").item(0).getAttributes()
                            .getNamedItem("value")
                            .getNodeValue();

                    // in this section, inserts the data from XML to server
                    Student student = new Student(id, name, age, address, contact);
                    server2.extractStudentXML(student);
                }
            }
            // displays how many data are displayed
            JOptionPane.showMessageDialog(this, "5 new data added from student.xml File");
            Fetch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        extractXML_counter++;
        System.out.println("Button Pressed: " + extractXML_counter);
    }// GEN-LAST:event_btn_extractxmlActionPerformed

    // when 'View' button is pressed this will run
    private void btn_ViewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_ViewActionPerformed
        try {
            // TODO add your handling code here:
            Fetch();
        } catch (RemoteException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_btn_ViewActionPerformed

    private void btn_sortActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_sortActionPerformed
        // TODO add your handling code here:
        try {
            Sort();
        } catch (RemoteException e) {
            System.out.println("error: " + e);
        }
    }// GEN-LAST:event_btn_sortActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_deleteActionPerformed
        try {
            // TODO add your handling code here:
            int studID = Integer.parseInt(txtId.getText());
            server2.deleteStudent(studID);

            JOptionPane.showMessageDialog(this, "Data has been deleted!");
            txtName.setText("");
            txtAge.setText("");
            txtAddress.setText("");
            txtContact.setText("");
            txtName.requestFocus();

            Fetch();

        } catch (RemoteException re) {
            System.out.println(re);
        }
    }// GEN-LAST:event_btn_deleteActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtNameActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtAgeActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtAddressActionPerformed

    private void txtContactActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtContactActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtContactActionPerformed

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_SearchActionPerformed
        try {

            int studentID = Integer.parseInt(txtId.getText());
            Student student = server2.getStudentByID(studentID);

            if (student != null) {
                txtName.setText(student.getName());
                txtAge.setText(String.valueOf(student.getAge()));
                txtAddress.setText(student.getAddress());
                txtContact.setText(student.getContact());
            } else {
                JOptionPane.showMessageDialog(this, "No Record found!!");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_btn_SearchActionPerformed

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_AddActionPerformed

        if (server2 != null) {
            if (txtName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name of Student required");
            } else if (txtAge.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Age of Student required");
            } else if (txtAddress.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Address of Student required");
            } else if (txtContact.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please type N/A, if none");
            } else {

                try {
                    // TODO add your handling code here:
                    int id = Integer.parseInt(txtId.getText());
                    String name = txtName.getText();
                    int age = Integer.parseInt(txtAge.getText());
                    String address = txtAddress.getText();
                    String contact = txtContact.getText();

                    Student student = new Student(id, name, age, address, contact);
                    server2.saveStudent(student);
                    JOptionPane.showMessageDialog(this, "Record added!");
                    txtName.setText("");
                    txtAge.setText("");
                    txtAddress.setText("");
                    txtContact.setText("");
                    Fetch();
                } catch (RemoteException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Unable to connect to the Server");
        }
    }// GEN-LAST:event_btn_AddActionPerformed

    private void txtSortActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtSortActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtSortActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtIdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new GUI().setVisible(true);
                } catch (NotBoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_View;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_extractxml;
    private javax.swing.JButton btn_sort;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JComboBox<String> txtSort;
    // End of variables declaration//GEN-END:variables
}
