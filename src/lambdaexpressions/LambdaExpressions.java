/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaexpressions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Comparator;

/**
 *
 * @author me
 */
public class LambdaExpressions {
    
    static String staticVariable = "Hello";
    
    private String privateVariable = "Private ( Instance ) variable";
    
    public static void main(String[] args) throws IOException {
        
        //Usual way
        //----------------------------------------------------------------------
        
        Comparator<String> stringComparator = new  Comparator<String> (){
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
            
        };
        
        int comparison = stringComparator.compare("Hello", "Hello there");
        System.out.println(comparison);
        //----------------------------------------------------------------------
        
        
        //With lambda expression
        //----------------------------------------------------------------------
        Comparator<String> stringLambdaComparator = 
                (String o1,String o2) -> {return o1.compareTo(o2);};
        
        
        int lamdbdaComparison = stringLambdaComparator.compare("Hello", "Hello there");
        System.out.println(lamdbdaComparison);
        //----------------------------------------------------------------------
        
        //Simplyfied 
        //----------------------------------------------------------------------
        Comparator<String> stringLambdaComparator2 = 
                (o1, o2) ->  o1.compareTo(o2);
        
        
        int lamdbdaComparison2 = stringLambdaComparator2.compare("Hello", "Hello there");
        System.out.println(lamdbdaComparison2);
        //----------------------------------------------------------------------
        
        
        
        //Using interface
        //----------------------------------------------------------------------
//        MyFunction myFunction = () -> {System.out.println("Hello from interface");};
//        myFunction.apply();
        
        //----------------------------------------------------------------------
        MyFunction myFunction = (text1,text2) -> {System.out.println(text1+" "+text2);};
        
        myFunction.apply("Hello","World");
        //----------------------------------------------------------------------
        
        //Using interface + return
        MyFunctionWithReturn myFunctionWithReturn = (text1,text2) -> {
            System.out.println(text1+" "+text2);
            return text1 + " + " + text2;
        };
        
        String returnValue = myFunctionWithReturn.apply("Hello","World");
        System.out.println(returnValue);
        //----------------------------------------------------------------------
        
        //Fuctional interface
        
        //Java lambda expressions can implement intefaces with a single 
        //unimplemented (abstract) method
        //but as many static or default methods as we like
        
        
        MyInterface myInterface = (String text) -> {
            System.out.println(text);
        };
        
        myInterface.printIt("Hello World");
        
        myInterface.printUtf8To("Hello File", new FileOutputStream("data.txt"));
        
        MyInterface.printItToSystemOut("Hello Out");
        
        //Simple Variable Capture-----------------------------------------------
        
        final String variable = "Word";
        
        MyInterface myInterface3 = (String text) -> {
            System.out.println(text+variable);
        };
        
        myInterface3.printIt("Simple variable: ");
        
        //variable="word2"; the variable cannot be changed after... better to be
        //declared final
        
        
        //Static variable capture-----------------------------------------------
        
        MyInterface myInterface4 = (String text) -> {
            System.out.println(text+staticVariable);
        };
        
        myInterface4.printIt("With static variable: ");
        
        staticVariable= "Changed static variable";
        
        myInterface4.printIt("With new static variable: ");
        
        LambdaExpressions instance = new LambdaExpressions();
        instance.doIt();
    }
        //Instance variable capture---------------------------------------------
    public void doIt(){
        
        MyInterface myInterface5 = (String text) -> {
            System.out.println(text+privateVariable);
        };
        
        myInterface5.printIt("Private variable: ");
        
        privateVariable= "Changed private variable";
        
        myInterface5.printIt("With new private variable: ");
    }
    
}
