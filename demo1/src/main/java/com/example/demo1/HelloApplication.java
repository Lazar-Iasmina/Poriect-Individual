package com.example.demo1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        //Stage stage =new Stage(root);
      //Group root = new Group();
        User x = new User("abcd","1223",123);
        User x2 = new User("gbcd","1223",123);
        User x3 = new User("fbcd","1523",123);
        User x4 = new User("ebcd","1223",123);
        List<User> l= new ArrayList<>();
        l.add(x);
        l.add(x2);
        l.add(x3);
        l.add(x4);
        Zbor z1= new Zbor("Bucuresti","Atena",LocalDate.of(2022,12,8),"12.30",1500);
        Zbor z2= new Zbor("Atena","Bucuresti",LocalDate.of(2022,12,15),"18.30",2000);
        Zbor z3= new Zbor("Bucuresti","Budapesta",LocalDate.of(2022,12,12),"20.30",1000);
        Zbor z4= new Zbor("Budapesta","Bucuresti",LocalDate.of(2022,12,22),"05.30",750);
        Zbor z5= new Zbor("Budapesta","Atena",LocalDate.of(2022,12,26),"14.30",400);
        Zbor z6= new Zbor("Atena","Budapesta",LocalDate.of(2022,12,31),"10.30",600);
        List<Zbor> zboruri= new ArrayList<>();
        zboruri.add(z1);
        zboruri.add(z2);
        zboruri.add(z3);
        zboruri.add(z4);
        zboruri.add(z5);
        zboruri.add(z6);


        File fisier = new File("useri.txt");
        File fisier2 = new File("zboruri2.txt");
        //serializareZboruri2(zboruri,fisier2);
        //serializareUseri(l,fisier);
        Scene scene=new Scene(root);
        //primaryStage.setResizable(true);

        //primaryStage.setFullScreen(true);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void serializareUseri(List<User> l, File f){
        try{
            FileOutputStream fos= new FileOutputStream(f);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            for(User i: l){
                oos.writeObject(i);
            }
            oos.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<User> deserializare2Useri(File f, int numar){
        List<User> l= new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            for(int i=0;i<numar;i++){
                l.add((User) ois.readObject());
            }
            ois.close();
            fis.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return l;
    }
    public static void serializareZboruri(List<Zbor> l, File f){
        try{
            FileOutputStream fos= new FileOutputStream(f);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            for(Zbor i: l){
                oos.writeObject(i);
            }
            oos.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<Zbor> deserializareZboruri(File f, int numar){
        List<Zbor> l= new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            for(int i=0;i<numar;i++){
                l.add((Zbor) ois.readObject());
            }
            ois.close();
            fis.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return l;
    }
    public static void serializareZboruri2(List<Zbor> l, File f){
        try{
            FileOutputStream fos= new FileOutputStream(f);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            for(Zbor i: l){
                oos.writeObject(i);
            }
            oos.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<Zbor> deserializareZboruri2(File f, int numar){
        List<Zbor> l= new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            for(int i=0;i<numar;i++){
                l.add((Zbor) ois.readObject());
            }
            ois.close();
            fis.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return l;
    }

}