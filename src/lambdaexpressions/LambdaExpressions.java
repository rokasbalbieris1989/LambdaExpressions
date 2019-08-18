/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaexpressions;

import java.util.Comparator;

/**
 *
 * @author me
 */
public class LambdaExpressions {

    
    public static void main(String[] args) {
        
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
    }
    
}
