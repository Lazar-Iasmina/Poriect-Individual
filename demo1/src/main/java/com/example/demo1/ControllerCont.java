package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControllerCont {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    Label listaZboruri;
    @FXML
    Label nume;

    public void displayDestinatie() throws  FileNotFoundException{
        List<ZboruriRezervate> l=new ArrayList<>();
        File file=new File("zboruriRezervate.txt");
        String nrul="";
        File myObj7= new File("nrZboruri.txt");
        Scanner myReader7= new Scanner(myObj7);
        while(myReader7.hasNextLine()){
            nrul=myReader7.nextLine();

        }
        l.addAll(deserializareZboruriRezervate2(file,Integer.parseInt(nrul)));
        File myObj= new File("userPass.txt");
        Scanner myReader= new Scanner(myObj);
        File myObj2= new File("uPass.txt");
        Scanner myReader2= new Scanner(myObj);
        String uname1,pass1;
        uname1="user";
        pass1="1234";
        while(myReader.hasNextLine()){
            uname1=myReader.nextLine();

        }
        while(myReader2.hasNextLine()){
            pass1=myReader2.nextLine();

        }
        for(ZboruriRezervate i : l){
            if(i.getUser().equals(uname1)){
                listaZboruri.setText(listaZboruri.getText()+"\n"+i.getaPlecare()+" "+i.getaSosire()+" "+i.getDataPlecare());
            }
        }

    }
    public void nume() throws FileNotFoundException{
        File myObj= new File("userPass.txt");
        Scanner myReader= new Scanner(myObj);
        String uname1;
        uname1="user";
        while(myReader.hasNextLine()){
            uname1=myReader.nextLine();

        }
        nume.setText(nume.getText()+uname1);
    }
    public static void serializareZboruriRezervate2(List<ZboruriRezervate> l, File f){
        try{
            FileOutputStream fos= new FileOutputStream(f);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            for(ZboruriRezervate i: l){
                oos.writeObject(i);
            }
            oos.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<ZboruriRezervate> deserializareZboruriRezervate2(File f, int numar){
        List<ZboruriRezervate> l= new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            for(int i=0;i<numar;i++){
                l.add((ZboruriRezervate) ois.readObject());
            }
            ois.close();
            fis.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return l;
    }
    public void switchtoScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
