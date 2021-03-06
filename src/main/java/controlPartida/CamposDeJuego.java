/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlPartida;

import Tienda.Mascotas;
import java.util.Scanner;

/**
 *
 * @author Jonwil
 */
public class CamposDeJuego {
    
    private Mascotas[] mascotasCampo;
    
    public CamposDeJuego(Mascotas[] mascotasCampo) {
        this.mascotasCampo = mascotasCampo;
    }
    
    public void aplicarEfectosCampoJuego(){
        System.out.println("Elija un Campo de Juego conforme a sus preferencias");
        Scanner scanner = new Scanner(System.in);
        mostrarCamposDeJuego();
        int seleccionCampo= scanner.nextInt();
        switch(seleccionCampo){
            case 1:                
                pantano();
                break;
            case 2:               
                nubes();
                break;
            case 3:               
                mar();
                break;
            case 4:                
                bosque();
                break;
            case 5:               
                granja();
                break;
            case 6:                
                sinCampo();
                break;
            case 7:               
                sabana();
                break;
        }
    }
    
    public void pantano(){
        System.out.println("Ha seleccionado el mapa del Pantano");
        System.out.println("Los Animales tipo reptil han Aumentado(+1/+1)");
        for (Mascotas mascotas : mascotasCampo) {
            String [] TiposDeLaMascotas=mascotas.getTipos();
            for (String tip : TiposDeLaMascotas) {
                if(tip.equals("reptil")){
                    mascotas.ganarDano(1);
                    mascotas.ganarVida(1);
                }
            }
        }
    }
    
    public void nubes(){
         System.out.println("Ha seleccionado el mapa de Las Nubes");
         System.out.println("Los Animales tipo Volador han Aumentado(+1/+1)");
        for (Mascotas mascotas : mascotasCampo) {
            String [] TiposDeLaMascotas=mascotas.getTipos();
            for (String tip : TiposDeLaMascotas) {
                if(tip.equals("volador")){
                    mascotas.ganarDano(1);
                    mascotas.ganarVida(1);
                }
            }
        }
    }
    
    public void mar(){
        System.out.println("Ha seleccionado el mapa del Mar");
        System.out.println("Los Animales tipo acuativo han Aumentado(+1/+1)");
        for (Mascotas mascotas : mascotasCampo) {
            String [] TiposDeLaMascotas=mascotas.getTipos();
            for (String tip : TiposDeLaMascotas) {
                if(tip.equals("acuatico")){
                    mascotas.ganarDano(1);
                    mascotas.ganarVida(1);
                }
            }
        }
    }
    
    public void bosque(){
        System.out.println("Ha seleccionado el del Bosque");
                System.out.println("Los animales tipo terrestre/mam??fero tendr??n un buff de (+2/0) por cada tipo terrestre\n" +
"            (aplica solo a terrestres) y (0/+2) por cada tipo mam??fero (aplica solo a mam??feros), los animales\n" +
"            tipo solitario ser??n nerfeados tal que su da??o al atacar ser?? reducido en un 20%");
        for (Mascotas mascotas : mascotasCampo) {
            String [] TiposDeLaMascotas=mascotas.getTipos();
            for (String tip : TiposDeLaMascotas) {
                if(tip.equals("terrestre")){
                    mascotas.ganarDano(2);
                }
                if(tip.equals("mamifero")){
                    mascotas.ganarVida(2);
                }
                if(tip.equals("solitario")){
                    double reducir=mascotas.getUnidadesDeDanoInicial()*0.2;
                    double danoreducido = mascotas.getUnidadesDeDanoInicial()-reducir;
                    mascotas.setUnidadesDeDanoInicial(danoreducido);//solitario ser??n nerfeados tal que su da??o al atacar ser?? reducido en un 20%.
                }
            }
        }
    }
    
    public void granja(){
         System.out.println("Ha seleccionado el mapa de la Granja");
         System.out.println("buff a dom??stico/mam??fero -> nerfeo a solitario");
        for (Mascotas mascotas : mascotasCampo) {
            String [] TiposDeLaMascotas=mascotas.getTipos();
            for (String tip : TiposDeLaMascotas) {
                if(tip.equals("domestico")){
                    mascotas.ganarDano(1);
                    mascotas.ganarVida(1);
                }
                if(tip.equals("mamifero")){
                    mascotas.ganarDano(1);
                    mascotas.ganarVida(1);
                }
                if(tip.equals("solitario")){
                    mascotas.ganarDano(-1);
                    mascotas.ganarVida(-1);
                }
            }
        }
    }
    public void sinCampo(){ //PENDIENTE
        int cantidadSolitarios=0;
        System.out.println("No ha seleccionado ningun campo");
        System.out.println("Los solitarios ganan una bonificaci??n de (+3/+3) si solo hay uno en el equipo.");
        for (Mascotas mascotas : mascotasCampo) {
            String [] TiposDeLaMascotas=mascotas.getTipos();
            for (String tip : TiposDeLaMascotas) {
                if(tip.equals("solitario")){
                    cantidadSolitarios++;
                }
               mascotas.ganarDano(1);
                    mascotas.ganarVida(1);
            }
        }
    }
    public void sabana(){   //PENDIENTE
         System.out.println("Ha seleccionado el mapa dela Sabana");
         System.out.println("Los Des??rticos ganan (0/+1) extra por cada alimento que se les de.");
        for (Mascotas mascotas : mascotasCampo) {
            String [] TiposDeLaMascotas=mascotas.getTipos();
            for (String tip : TiposDeLaMascotas) {
                if(tip.equals("desertico")){
                    mascotas.ganarVida(1);
                }
                
            }
        }
    }
    
    
    
    public void mostrarCamposDeJuego(){
        System.out.println("Debido a que existen diferentes tipos de mascotas, al iniciar una batalla puede seleccionarse un\n" +
"tipo de campo el cual dar?? una bonificaci??n a todos los animales de un tipo espec??fico, los campos por\n" +
"defecto son:\n" +
" 1. Pantano: \n            Los animales tipo reptil ganar??n (+1/+1) por cada animal reptil en batalla\n" +
" 2. Nubes: \n            Los animales tipo volador ganar??n (+1/+1) por cada animal volador en batalla\n" +
" 3. Mar: \n            Los animales de tipo acu??tico ganar??n (+1/+1) por cada animal acu??tico en batalla\n" +
" 4. Bosque: \n            Los animales tipo terrestre/mam??fero tendr??n un buff de (+2/0) por cada tipo terrestre\n" +
"            (aplica solo a terrestres) y (0/+2) por cada tipo mam??fero (aplica solo a mam??feros), los animales\n" +
"            tipo solitario ser??n nerfeados tal que su da??o al atacar ser?? reducido en un 20%.\n" +
" 5. Granja: \n            buff a dom??stico/mam??fero -> nerfeo a solitario\n" +
" 6. <Sin campo> : \n            Los solitarios ganan una bonificaci??n de (+3/+3) si solo hay uno en el equipo.\n" +
" 7. Sabana: \n            Los Des??rticos ganan (0/+1) extra por cada alimento que se les de.");
    }
    
    
    
}
