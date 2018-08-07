/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Matías & Bastían
 */
public class Taller5 {

    //Variable global que guardara la cantidad de sumas hechas en cada ciclo de fibonacci
    private static int cantidadSumas = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
               
        Scanner scan_menu = new Scanner(System.in);
        int seleccion_menu = 0;
        
        //Loop menu principal
        while(seleccion_menu != 2){
            try{
                desplegarMenu();
                seleccion_menu = scan_menu.nextInt();
            }catch(InputMismatchException ex){
		System.out.println("No es un número entero");
                System.out.println("Intentelo de nuevo");
                scan_menu.next();
                seleccion_menu = 0;
            }
            switch(seleccion_menu){
                
                case 1:
                    //Cuando se quiere ingresar el termino a calcular
                    Scanner scan_termino = new Scanner(System.in);
                    System.out.println("Escriba el término que quiera saber de la sucesión de Fibonacci: ");
                    try{
                        int seleccion_termino;
                        seleccion_termino = scan_termino.nextInt();
                        
                        if(seleccion_termino < 0){
                            System.out.println("No se aceptan números negativos");
                            break;
                        }
                        System.out.println("\n~El término "+ seleccion_termino + " es el número " + fibonacci(seleccion_termino));
                        System.out.println("~La cantidad de sumas realizadas fueron " + cantidadSumas + " sumas.");
                        
                    }catch(InputMismatchException ex){
                        System.out.println("No es un número entero");
                        System.out.println("Intentelo de nuevo");
                        scan_termino.next();
                    }                    
                    break;
                
                default:
                    if(seleccion_menu != 2 )
                        System.out.println("Escriba un numero entre las opciones dadas por favor.");                    
                    break;
            }
            cantidadSumas = 0;
                    
        }
        
    }
        
    public static void desplegarMenu(){
        System.out.println("\n");
        System.out.println("...MENU PRINCIPAL...");
        System.out.println("[1] Calcular un término de la sucesión de Fibonacci.");
        System.out.println("[2] SALIR");
        System.out.println("\n Ingrese una opcion: ");
    }
    
    
    /**
     * Funcion para poder recibir como parametro una variable 'i' del tipo 'int' 
     * y utlizar el metodo de fibonacci recursivo con la clase BigInteger.
     */ 
    public static BigInteger fibonacci(int i){
        if(i < 0){
            System.out.println("Negativos no permitidos >:( ");
            return BigInteger.ZERO;
        }
        return fibonacciBig(BigInteger.valueOf(i));
    }
    
    /**
     * Funcion que representa la sucesion de Fibonacci, recibiendo 'n' como la posicion del termino requerido y devolviendo
     * el valor de ese termino en la sucesion de Fibonacci.
     */
    private static BigInteger fibonacciBig(BigInteger n){
               
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE) ){
            return n;
        }
        cantidadSumas++;
        return fibonacciBig(n.subtract(BigInteger.valueOf(1)))  //fibonacci(n-1) 
               .add(fibonacciBig(n.subtract(BigInteger.valueOf(2)))); //+ fibonacci(n-2)
        
    }
}
