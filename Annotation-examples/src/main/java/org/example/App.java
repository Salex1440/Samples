package org.example;

import org.example.analyzer.MaxAnnotationAnalyzer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MaxAnnotationAnalyzer analyzer = new MaxAnnotationAnalyzer();
        System.out.println( analyzer.HOLDER.getValue() );
    }
}