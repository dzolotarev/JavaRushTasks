package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init() {
        createNewDocument();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public static void main(String[] args) {
        View v = new View();
        Controller controller = new Controller(v);
        v.setController(controller);
        v.init();
        controller.init();
    }

    public void exit() {
        System.exit(0);
    }

    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text) {
        resetDocument();
        Reader stringReader = new StringReader(text);
        HTMLEditorKit htmlKit = new HTMLEditorKit();
        try {
            htmlKit.read(stringReader, document, 0);
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }

    }

    public String getPlainText() {
        Writer writer = new StringWriter();
        HTMLEditorKit htmlKit = new HTMLEditorKit();
        try {
            htmlKit.write(writer, document, 0, document.getLength());
            writer.close();
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }


    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        jFileChooser.setDialogTitle("Open File");
        int userSelection = jFileChooser.showOpenDialog(view);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());

            HTMLEditorKit htmlKit = new HTMLEditorKit();
            try {
                FileReader fileReader = new FileReader(currentFile);
                htmlKit.read(fileReader, document, 0);
                view.resetUndo();
                fileReader.close();
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }


        }
    }

    public void saveDocument() {
        view.selectHtmlTab();
        if (currentFile != null) {
            HTMLEditorKit htmlKit = new HTMLEditorKit();
            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                htmlKit.write(fileWriter, document, 0, document.getLength());
                fileWriter.close();
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }

        } else {
            saveDocumentAs();
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        jFileChooser.setDialogTitle("Save File");
        int userSelection = jFileChooser.showSaveDialog(view);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            HTMLEditorKit htmlKit = new HTMLEditorKit();
            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                htmlKit.write(fileWriter, document, 0, document.getLength());
                fileWriter.close();
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }

        }

    }

}
