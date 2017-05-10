package View.Application;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class FileBrowser implements TreeSelectionListener {

    private JPanel jpanel_;

    private DefaultMutableTreeNode root;

    private DefaultTreeModel treeModel;

    private JTree tree;
    private Application toto;

    JPanel GetPanel() {
        return jpanel_;
    }
    public JPanel FileBrowser(Application test) {
        toto = test;
        JPanel jpanel_ = new JPanel(new BorderLayout());

        File fileRoot = new File("../MyRpgMaker/src/main/resources/World");
        root = new DefaultMutableTreeNode(new FileNode(fileRoot));
        treeModel = new DefaultTreeModel(root);

        tree = new JTree(treeModel);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(this);
        tree.setShowsRootHandles(true);
        JScrollPane scrollPane = new JScrollPane(tree);

        jpanel_.add(BorderLayout.CENTER, scrollPane);
        jpanel_.setVisible(true);

        CreateChildNodes ccn =
                new CreateChildNodes(fileRoot, root);
        new Thread(ccn).start();
        return jpanel_;
    }

    //tree selction event on the tree triggers this method
    public void valueChanged(TreeSelectionEvent e) {
        //which node was selected
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
        if (node == null) return;
        Object nodeInfo = node.getUserObject();

        //if node is a leaf
        if (node.isLeaf()) {
                File tmp = new File("../MyRpgMaker/src/main/resources/World/" + nodeInfo.toString());
                toto.GetEditor().LoadMap(tmp.toString());
            }
        }

    public class CreateChildNodes implements Runnable {

        private DefaultMutableTreeNode root;

        private File fileRoot;

        public CreateChildNodes(File fileRoot,
            DefaultMutableTreeNode root) {
                this.fileRoot = fileRoot;
                this.root = root;
        }

        @Override
        public void run() {
            createChildren(fileRoot, root);
        }

        private void createChildren(File fileRoot,
                                    DefaultMutableTreeNode node) {
            File[] files = fileRoot.listFiles();
            if (files == null) return;

            for (File file : files) {
                DefaultMutableTreeNode childNode =
                        new DefaultMutableTreeNode(new FileNode(file));
                node.add(childNode);
                if (file.isDirectory()) {
                    createChildren(file, childNode);
                }
            }
        }

    }

    public class FileNode {

        private File file;

        public FileNode(File file) {
            this.file = file;
        }

        @Override
        public String toString() {
            String name = file.getName();
            if (name.equals("")) {
                return file.getAbsolutePath();
            } else {
                return name;
            }
        }
    }

}